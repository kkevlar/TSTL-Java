

public class PropertyEntry extends RepeatablesContainer implements RepeatablesAction
{
	private String[] javaCodeSplit;
	private Repeatable[] repeatables;
	private String myCheck;
	
	public static String generateCheck(PropertyEntry[] propEntries)
	{
		String ret = "public String check()\n{\n";
				ret += "String fail = null;\n";
		for (int i = 0; i < propEntries.length; i++) 
		{
			ret += propEntries[i].getMyCheck();
		}
		ret += "return fail;\n";
		ret += "}\n";
		return ret;		 
	}
	
	public PropertyEntry(String[] javaCodeSplit, Repeatable[] repeatables)
	{
		super();
		this.setJavaCodeSplit(javaCodeSplit);
		this.setRepeatables(repeatables);
		this.buildCheckString();
		this.actOnValidCombinations(this);
	}
	
	private void buildCheckString() 
	{
		myCheck = "";
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
		String add = "";
		for(int i = 0; i < ((this.getRepeatables().length*2)+1); i++)
		{
			if(i % 2 == 0)
				add += javaCodeSplit[i/2];
			else
				add += this.getRepeatables()[(i-1)/2].getAsJava(vals[(i-1)/2]);
		}
		myCheck += "if(!(" + add + "))\n";
		myCheck += "fail =\"" + add + "\";\n";
	}

	private String getMyCheck()
	{
		return myCheck;
	}

	
	
}
