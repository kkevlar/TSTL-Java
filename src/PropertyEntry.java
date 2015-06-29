import java.util.ArrayList;
import java.util.HashMap;



public class PropertyEntry extends RepeatablesContainer implements RepeatablesAction
{
	private String[] javaCodeSplit;
	private Repeatable[] repeatables;
	private String myCheck;
	private HashMap<Repeatable, int[]> repeatingPoolValues;

	public static String generateCheck(PropertyEntry[] propEntries)
	{
		ArrayList<String> pastChecks = new ArrayList<String>();
		String ret = "public String check()\n{\n";
		ret += "String fail = null;\n";
		for (int i = 0; i < propEntries.length; i++) 
		{
			String check =  propEntries[i].getMyCheck();
			if(!pastChecks.contains(check))
			{
				ret +=check;
				pastChecks.add(check);
			}
		}
		ret += "return fail;\n";
		ret += "}\n";
		return ret;		 
	}

	public PropertyEntry(LineParsePacket packet)
	{
		super();

		this.setJavaCodeSplit(packet.getJavaCodePieces());
		this.setRepeatables(packet.getRepeatables());
		this.buildCheckString();
		this.actOnValidCombinations(this);
	}



	private void buildCheckString() 
	{
		myCheck = "";

		repeatingPoolValues = new HashMap<Repeatable,int[]>();
		for(int x = 0; x < this.getRepeatables().length; x++)
		{
			Repeatable rep = this.getRepeatables()[x];
			Repeatable[] reps = repeatingPoolValues.keySet().toArray(new Repeatable[repeatingPoolValues.size()]);
			Repeatable storeRep = rep;
			int[] newInts = new int[]{x};
			for(int y = 0; y < reps.length; y++)
			{
				Repeatable testRep = reps[y];
				boolean equal = rep.equalsRepeatable(testRep);
				if(!equal)
					continue;
				int[] ints  = repeatingPoolValues.get(testRep);
				newInts = new int[ints.length + 1];
				for (int z = 0; z < ints.length; z++) 
				{
					newInts[z] = ints[z];
				}
				newInts[newInts.length-1] = x;
				storeRep = testRep;
				repeatingPoolValues.remove(testRep);
				break;
			}
			repeatingPoolValues.put(storeRep, newInts);
		}
	}

	public String[] getJavaCodeSplit() 
	{
		return javaCodeSplit;
	}

	private void setJavaCodeSplit(String[] javaCodeSplit)
	{
		this.javaCodeSplit = javaCodeSplit;
	}

	public Repeatable[] getRepeatables() 
	{
		return repeatables;
	}

	private void setRepeatables(Repeatable[] repeatables)
	{
		this.repeatables = repeatables;
	}

	@Override
	public void actOnRepValues(int[] vals, RepeatablesContainer cont)
	{
		HashMap<Repeatable,Integer> pairs = new HashMap<Repeatable,Integer>();
		String add = "";
		for(int i = 0; i < ((this.getRepeatables().length*2)+1); i++)
		{
			if(i % 2 == 0)
				add += javaCodeSplit[i/2];
			else
			{
				Repeatable r = this.getRepeatables()[(i-1)/2];
				if(pairs.containsKey(r))
					add += r.getAsJava(pairs.get(r));
				else
				{
					int num = vals[(i-1)/2];
					add+=r.getAsJava(num);
					pairs.put(r, num);
				}
			}
		}
		myCheck += "if(!(" + add + "))\n";
		myCheck += "fail =\"" + add + "\";\n";
	}

	private String getMyCheck()
	{
		return myCheck;
	}



}
