import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;

public class PoolEntry extends Repeatable
{
	private static HashMap<Integer,String> poolwideMap;
	private String className;
	private String varName;
	private int listSize;
	public PoolEntry(String className, String varName, int listSize)
	{
		super();
		this.className = className.trim();
		this.varName = varName.trim();
		this.listSize = listSize;
		if(poolwideMap == null)
			poolwideMap = new HashMap<Integer,String>();
		poolwideMap.put(getId(), className+TstlConstants.SPLIT_SYNTAX_POOLVAL_CLASSNAME_WITH_VARNAME+varName.substring(TstlConstants.PREFIX_JAVA_VARIABLES.length()+1).toLowerCase());
	}
	public static void writePoolwideMapToFile()
	{
		File mapFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), TstlConstants.FILE_POOLWIDE_MAP));			
		PrintWriter writer = null;
		try 
		{
			mapFile.createNewFile();
			writer = new PrintWriter(mapFile);
		} 
		catch (IOException e) 
		{
			TstlConstants.log(Level.SEVERE, "Failed to write poolwidemap file!", e);
			return;
		}
		finally
		{
			if(writer == null)
				return;
		}
		
		Integer[] integerPoolIds = poolwideMap.keySet().toArray(new Integer[poolwideMap.size()]);
		for (int i = 0; i < integerPoolIds.length; i++) 
		{
			writer.println(integerPoolIds[i] + TstlConstants.SPLIT_SYNTAX_POOLENTRY_ID_AND_CLASSNAME +poolwideMap.get(integerPoolIds[i]));
		}	
		writer.flush();
		writer.close();	
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
		return TstlConstants.IDENTIFIER_TSTLVARIABLE + this.getVarName().substring(TstlConstants.PREFIX_JAVA_VARIABLES.length()) +TstlConstants.SPLIT_SYNTAX_POOLENTRY_ID_AND_CLASSNAME+i+ TstlConstants.IDENTIFIER_TSTLVARIABLE;
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
