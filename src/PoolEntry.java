
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
		return visibilityLevel + " List<" + this.getClassName() + "> "+ this.getVarName() + ";";
	}
	
	public String getClearLines()
	{
		String ret =  getVarName() + " = new ArrayList<" + getClassName() + ">();\n";
		//should instead use clear()?
		ret += "for (int i = 0; i < " + this.getListSize() + "; i++)\n";
		ret += getVarName() + ".add(null);";
		return ret;
	}
	
}