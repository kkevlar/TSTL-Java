import java.util.ArrayList;
import java.util.Arrays;


public class ActionEntry
{
	public static String[] splitActionLine(String rawLine)
	{
		if(rawLine.contains(TstlConstants.IDENTIFIER_EXPLICIT_GUARD))
		{
			String[] pieces = rawLine.split(TstlConstants.IDENTIFIER_EXPLICIT_GUARD);
			if(pieces.length > 2)
				throw new MalformedTstlException(TstlConstants.MESSAGE_ONLY_ONE_EXPLICIT_GUARD + ": " + rawLine);
			return pieces;
		}
		else
		{
			return new String[]{null,rawLine};
		}
	}
	private String explicitGuardUnparsed;

	private String actionLine;
	private PoolEntry[] entirePoolEntries;	
	private Repeatable[] repeatables;
	private String[] javaCodePieces;

	public ActionEntry(String explicitGuardUnparsed, String actionLine, PoolEntry[] entirePoolEntries) 
	{
		this.explicitGuardUnparsed = explicitGuardUnparsed;
		this.actionLine = actionLine;
		this.entirePoolEntries = entirePoolEntries;
		this.parseActionLine();
	}
	private void parseActionLine()
	{
		String newActionLine = actionLine;
		boolean hasInit;
		if(newActionLine.contains(":="))
			hasInit = true;
		else
			hasInit = false;
		ArrayList<Repeatable> entries = new ArrayList<Repeatable>();

		if(hasInit)
		{
			PoolEntry initVar = null;
			String[] pieces = newActionLine.split(":=");
			newActionLine = pieces[1];
			String name =  pieces[0].replace("%", " ").trim();
			initVar = (PoolEntry) getRepeatableFromVariable(name,true);
			entries.add(initVar);
		}
		newActionLine = " " + newActionLine + " ";
		String[] pieces = newActionLine.split(TstlConstants.IDENTIFIER_TSTLVARIABLE);
		if(pieces.length % 2 != 1)
			throw new MalformedTstlException(TstlConstants.MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS + actionLine);
		javaCodePieces = new String[(pieces.length+1)/2];

		for (int i = 0; i < pieces.length; i++)
		{
			if(i%2==0)
			{
				int javaIndex = i/2;
				javaCodePieces[javaIndex] = pieces[i];
			}
			else
			{
				Repeatable entry = this.getRepeatableFromVariable((pieces[i]).trim(), false);
				if (entry == null)
					throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:%" + pieces[i] + "% Line:" + actionLine);
				else
					entries.add(entry);
			}
		}
		this.repeatables = (Repeatable[]) entries.toArray(new Repeatable[entries.size()]);
	}
	private Repeatable getRepeatableFromVariable(String var, boolean mustBePool) 
	{
		Repeatable rep;
		rep = PoolEntry.getPoolEntryByVarName(this.entirePoolEntries,TstlConstants.PREFIX_JAVA_VARIABLES +var);
		if(rep == null && !mustBePool)
			rep = NumRange.getNumRange(var);
		if(rep == null)
			throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:%" + var + "% Line:" + actionLine);

		return rep;
	}
	protected String[] getJavaPieces() 
	{
		return this.javaCodePieces;
	}
	public int getActionCount()
	{
		int count = 1;
		for (int i = 0; i < this.getRepeatables().length; i++) 
		{
			count *= this.getRepeatables()[i].getListSize();		
		}
		return count;
	}
	protected Repeatable[] getRepeatables()
	{
		return this.repeatables;
	}
	protected boolean hasInit()
	{
		return this.getRepeatables().length == this.getJavaPieces().length;
	}
	public String makeGetNameMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_NAME_METHOD + "\n";
		ret += "{\n";
		ret += "return \"" + this.getActMainLine(poolValues) + "\"\n";
		ret += "} //end name()\n";
		return ret;
	}
	public String makeEnabledMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_ENABLED_METHOD + "\n";
		ret += "{\n";
		ret += "boolean enabled = ";
		for (int i = 0; i < this.getRepeatables().length; i++)
		{
			if(i == 0)
				ret += this.getRepeatables()[i].getCanOverwriteExpression(poolValues[i]);
			else
			{
				ret += " &&\n";
				ret += this.getRepeatables()[i].getIsUsableExpression(poolValues[i]);
			}
			
		}
		ret += ";"+ "\n";
		ret += "return enabled;"+ "\n";
		ret += "} //end enabled()\n";
		return ret;
	}
	public String makeActMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_ACT_METHOD + " \n";
		ret += "{\n";
		ret += this.getActMainLine(poolValues) + "\n";
		ret += this.getActUsageLines(poolValues) + "\n";
		ret += "} //end act() \n";
		return ret;
	}
	public String getActMainLine(int[] poolValues)
	{
		String mainLine = "";
		String endingCharacters = ";";
		int poolStartIndex= 0;
		if(this.hasInit())
		{
			PoolEntry poolEntry = (PoolEntry) this.getRepeatables()[0];
			mainLine += poolEntry.getVarName() + ".set(" + poolValues[0] + ", ";
			endingCharacters = ")" + endingCharacters;
			poolStartIndex = 1;
		}
		for (int i = 0; i < (this.getJavaPieces().length*2)-1;i++) 
		{
			if(i%2==0)
				mainLine += this.getJavaPieces()[(i+1)/2];
			else
			{
				int index = (i/2)+poolStartIndex;
				mainLine += this.getRepeatables()[index].getAsJava(poolValues[index]);
			}
		}
		mainLine += endingCharacters;
		return mainLine;
	}
	public String getActUsageLines(int[] poolValues)
	{
		String ret = "";
		for(int i = 0; i < this.getRepeatables().length; i++)
		{
			if(i == 0)
			{
				PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
				ret += pEntry.getUsedVarName() + "[" + poolValues[i] + "] = false;\n";
			}
			else
			{
				if(this.getRepeatables()[i] instanceof PoolEntry)
				{
					PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
					ret += pEntry.getUsedVarName() + "[" + poolValues[i] + "] = true;\n";
				}
			}
		}
		return ret;
	}
	public String createActionClass(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_CLASS + "\n";
		ret += this.makeGetNameMethod(poolValues);
		ret += this.makeEnabledMethod(poolValues);
		ret += this.makeActMethod(poolValues);
		ret += "};";
		return ret;
	}
	@Override
	public String toString() 
	{
		return "ActionEntry [explicitGuardUnparsed=" + explicitGuardUnparsed
				+ ", actionLine=" + actionLine + ", entirePoolEntries="
				+ Arrays.toString(entirePoolEntries) + ", repeatables="
				+ Arrays.toString(repeatables) + ", javaCodePieces="
				+ Arrays.toString(javaCodePieces) + "]";
	}

}
