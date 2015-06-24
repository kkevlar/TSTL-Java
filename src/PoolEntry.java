
public class PoolEntry 
{
	private String className;
	private String varName;
	private int listSize;
	
	public PoolEntry(String className, String varName, int listSize)
	{
		super();
		this.className = className.trim();
		this.varName = varName.trim();
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

	public static PoolEntry getPoolEntryByVarName(PoolEntry[] entirePoolEntries, String varName) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
