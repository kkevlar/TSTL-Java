

public class PropertyEntry 
{
	private String[] javaCodeSplit;
	private Repeatable[] repeatables;
	
	public PropertyEntry(String[] javaCodeSplit, Repeatable[] repeatables)
	{
		super();
		this.setJavaCodeSplit(javaCodeSplit);
		this.setRepeatables(repeatables);
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
	
	
}
