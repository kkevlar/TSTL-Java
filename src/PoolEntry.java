
public class PoolEntry extends Repeatable
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
	@Override
	public String toString()
	{
		return "PoolEntry [className=" + className + ", varName=" + varName
				+ ", listSize=" + listSize + "]";
	}
	public String getVarName() 
	{
		return varName;
	}
	@Override
	public int getListSize() 
	{
		return listSize;
	}
	public String getUsedVarName() 
	{
		return this.getVarName()+TstlConstants.SUFFIX_VAR_USED;
	}
	public String getInstanceVariableDeclaration(String visibilityLevel)
	{
		
		String ret = visibilityLevel + " List<" + this.getClassName() + "> "+ this.getVarName() + ";\n";
		ret += visibilityLevel +  " int[] " + this.getUsedVarName() + ";";
		return ret;
	}
	public String getClearLines()
	{
		String ret =  getVarName() + " = new ArrayList<" + getClassName() + ">();\n";
		//should instead use clear()?
		ret += "for (int i = 0; i < " + this.getListSize() + "; i++)\n";
		ret += getVarName() + ".add(null);\n";
		ret += getUsedVarName() + " = new int[" + this.getListSize() + "];";
		return ret;
	}
	public static PoolEntry getPoolEntryByVarName(PoolEntry[] entirePoolEntries, String varName) 
	{
		
		for (int i = 0; i < entirePoolEntries.length; i++) 
		{
			if(entirePoolEntries[i].getVarName().equals(varName))
				return entirePoolEntries[i];
		}
		return null;
	}
	@Override
	public String getAsJava(int i)
	{
		return this.getVarName() + ".get(" + i + ")";
	}
	public String getUsedAsJava(int i)
	{
		return this.getUsedVarName() + "["+ i + "]";
	}
	public String getAsFormattedTstl(int i)
	{
		return TstlConstants.IDENTIFIER_TSTLVARIABLE + this.getVarName().substring(TstlConstants.PREFIX_JAVA_VARIABLES.length()) +","+i+ TstlConstants.IDENTIFIER_TSTLVARIABLE;
	}	
	@Override
	public String getIsUsableExpression(int i) 
	{
		return this.getAsJava(i) + " != null";
	}
	@Override
	public String getCanOverwriteExpression(int i) 
	{
		return "(" + this.getAsJava(i) + " == null || (" + this.getUsedAsJava(i) + " + " + TstlConstants.DECLARATION_SUT_ALLOW_REINIT_VALUE_FIELD + ">= 2))";
	}
	@Override
	public boolean equalsRepeatable(Repeatable rep)
	{
		if(!(rep instanceof PoolEntry))
			return false;
		PoolEntry pool = (PoolEntry) rep;
		if(pool.varName.equals(this.varName))
			return true;
		return false;		
	}
}
