import java.util.ArrayList;
import java.util.HashMap;



public class PropertyEntry extends RepeatablesContainer implements RepeatablesAction
{
	private String[] javaCodeSplit;
	private Repeatable[] repeatables;
	private ArrayList<String> checks;

	public static String generateCheck(PropertyEntry[] propEntries)
	{
		
		String ret = "public String check()\n{\n";
		ret += "String fail = null;\n";
		for (int x = 0; x < propEntries.length; x++) 
		{
			ret += propEntries[x].getMyCheck() + "\n";
			
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
		checks = new ArrayList<String>();
		this.actOnValidCombinations(this);
	}

	public String[] getJavaCodeSplit() 
	{
		return javaCodeSplit;
	}

	private void setJavaCodeSplit(String[] javaCodeSplit)
	{
		this.javaCodeSplit = javaCodeSplit;
	}

	@Override
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
		String check = "";
		check += "if(!(" + add + "))\n";
		check += "fail =\"" + add + "\";\n";
		if(!(this.checks.contains(check)))
			checks.add(check);
		
	}

	private String getMyCheck()
	{
		String checkString = "";
		for(int i = 0; i < this.checks.size(); i++)
		{
			checkString += this.checks.get(i);
		}
		return checkString;
	}



}
