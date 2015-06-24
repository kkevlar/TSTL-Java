
public class SimpleActionEntry extends ActionEntry 
{
	private String actionLine;
	private PoolEntry[] entirePoolEntries;	
	private PoolEntry[] subsetPoolEntries;
	private String[] javaCodePieces;

	public SimpleActionEntry(String explicitGuardUnparsed, String actionLine,
			PoolEntry[] entirePoolEntries) {
		super(explicitGuardUnparsed);
		this.actionLine = actionLine;
		this.entirePoolEntries = entirePoolEntries;
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
			}
		}
 
		//TODO   unfinished
	}
	@Override
	protected String[] getJavaPieces() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PoolEntry[] getPoolEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getGuardExpressions() {
		// TODO Auto-generated method stub
		return null;
	}


}
