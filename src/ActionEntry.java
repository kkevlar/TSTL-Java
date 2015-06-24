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
	private Repeatable[] subsetPoolEntries;
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
		this.subsetPoolEntries = (Repeatable[]) entries.toArray(new Repeatable[entries.size()]);
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

	protected Repeatable[] getPoolEntries()
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
		String endingCharacters = ";";
		int poolStartIndex= 0;
		if(this.hasInit())
		{
			PoolEntry poolEntry = (PoolEntry) this.getPoolEntries()[0];
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
				mainLine += this.getPoolEntries()[index].getAsJava(poolValues[index]);
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
