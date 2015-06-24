
public class SimpleActionEntry extends ActionEntry 
{
	private String actionLine;
	private PoolEntry[] entirePoolEntries;	
	
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
		//TODO unfinished
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
