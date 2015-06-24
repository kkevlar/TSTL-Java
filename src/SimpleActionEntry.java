
public class SimpleActionEntry extends ActionEntry 
{
	private String actionLine;
	private PoolEntry[] entirePoolEntries;	
	private PoolEntry[] subsetPoolEntries;
	private String[] javaCodePieces;
	private boolean hasInit = false;

	public SimpleActionEntry(String explicitGuardUnparsed, String actionLine,
			PoolEntry[] entirePoolEntries) 
	{
		super(explicitGuardUnparsed);
		this.actionLine = actionLine;
		this.entirePoolEntries = entirePoolEntries;
		this.parseActionLine();
	}
	private void parseActionLine()
	{
		String newActionLine = actionLine;
		newActionLine = newActionLine.replace(TstlConstants.IDENTIFIER_INITIALIZATION, "=");
		newActionLine = " " + newActionLine + " ";
		String[] pieces = newActionLine.split(TstlConstants.IDENTIFIER_TSTLVARIABLE);
		if(pieces.length % 2 != 1)
			throw new MalformedTstlException(TstlConstants.MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS + actionLine);
		javaCodePieces = new String[(pieces.length+1)/2];
		subsetPoolEntries = new PoolEntry[javaCodePieces.length-1];

		if(newActionLine.contains("="))
			hasInit = true;
		else
			hasInit = false;
		for (int i = 0; i < pieces.length; i++)
		{
			if(i%2==0)
			{
				int javaIndex = i/2;
				javaCodePieces[javaIndex] = pieces[i];
			}
			else
			{
				int poolIndex = (i-1)/2;
				subsetPoolEntries[poolIndex] = PoolEntry.getPoolEntryByVarName(this.entirePoolEntries, (TstlConstants.PREFIX_REMOVE_PERCENTS_DEFAULT_VAR + pieces[i]).trim());
				if (subsetPoolEntries[poolIndex] == null)
					throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:%" + pieces[i] + "% Line:" + actionLine);
			}
		}
	}
	@Override
	protected String[] getJavaPieces() 
	{
		return this.javaCodePieces;
	}

	@Override
	protected PoolEntry[] getPoolEntries()
	{
		return this.subsetPoolEntries;
	}
	
	protected boolean hasInit()
	{
		return this.hasInit;
	}
	


}
