
public class PoolEntry 
{
	private String className;
	private String varName;
	private int listSize;
	
	public PoolEntry(String className, String varName, int listSize)
	{
		super();
		this.className = className;
		this.varName = varName;
		this.listSize = listSize;
		/*
		if(className.contains("ArrayList"))
			throw new MalformedTstlException("ArrayLists aren't allowed int TSTL pools...");
		*/
	}

	public String getClassName() 
	{
		return className;
	}

	public String getVarName() 
	{
		return varName;
	}

	public int getListSize() 
	{
		return listSize;
	}
	
	public String getInstanceVariableDeclaration(String visibilityLevel)
	{
		return visibilityLevel + " " + this.getClassName() + "[] " + this.getVarName() + ";";
	}
	
	public String getClearLines()
	{
		String ret =  varName + " = new " + className + "[" + listSize + "]" + ";\n";
		ret += "for (int i = 0; i < " + varName + ".length; i++)\n";
		ret += varName + "[i] = null;";
		return ret;
	}
	
}
