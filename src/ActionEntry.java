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
	private PoolEntry[] subsetPoolEntries;
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
		ArrayList<PoolEntry> entries = new ArrayList<PoolEntry>();

		if(hasInit)
		{
			PoolEntry initVar = null;
			String[] pieces = newActionLine.split(":=");
			newActionLine = pieces[1];
			String name = TstlConstants.PREFIX_REMOVE_PERCENTS_DEFAULT_VAR + pieces[0].replace("%", " ").trim();
			initVar = PoolEntry.getPoolEntryByVarName(this.entirePoolEntries,name);
			if(initVar == null)
				throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:%" + name + "% Line:" + actionLine);
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
				PoolEntry entry = PoolEntry.getPoolEntryByVarName(this.entirePoolEntries, (TstlConstants.PREFIX_REMOVE_PERCENTS_DEFAULT_VAR + pieces[i]).trim());
				if (entry == null)
					throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:%" + pieces[i] + "% Line:" + actionLine);
				else
					entries.add(entry);
			}
		}
		this.subsetPoolEntries = (PoolEntry[]) entries.toArray(new PoolEntry[entries.size()]);
	}
	protected String[] getJavaPieces() 
	{
		return this.javaCodePieces;
	}

	protected PoolEntry[] getPoolEntries()
	{
		return this.subsetPoolEntries;
	}

	protected boolean hasInit()
	{
		return this.getPoolEntries().length == this.getJavaPieces().length;
	}

	@Override
	public String toString() {
		return "ActionEntry [explicitGuardUnparsed=" + explicitGuardUnparsed
				+ ", actionLine=" + actionLine + ", entirePoolEntries="
				+ Arrays.toString(entirePoolEntries) + ", subsetPoolEntries="
				+ Arrays.toString(subsetPoolEntries) + ", javaCodePieces="
				+ Arrays.toString(javaCodePieces) + "]";
	}
	public String makeGetNameMethod(int[] poolValues)
	{
		return this.getActMainLine(poolValues);
	}
	public String makeEnabledMethod(int[] poolValues)
	{
		return null; //TODO unifnished
	}
	public String makeActMethod(int[] poolValues)
	{
		String ret = "public void act() \n";
		ret += "{\n";
		ret += this.getActMainLine(poolValues) + "\n";
		ret += this.getActUsageLines(poolValues) + "\n";
		ret += "} //end act";
		return ret;
	}
	public String getActMainLine(int[] poolValues)
	{
		String mainLine = "";
		String endingCharacters = "";
		int poolStartIndex= 0;
		if(this.hasInit())
		{
			mainLine += this.getPoolEntries()[0].getVarName() + ".set(" + poolValues[0] + ", ";
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
				mainLine += this.getPoolEntries()[index].getAsVariable(poolValues[index]);
			}
		}
		mainLine += endingCharacters;
		return mainLine;
	}
	public String getActUsageLines(int[] poolValues)
	{
		return null;//TODO unfinished
	}


}
