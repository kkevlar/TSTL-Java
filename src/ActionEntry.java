
public abstract class ActionEntry
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
	
	public String getEplicitGuardUnparsed()
	{
		return explicitGuardUnparsed;
	}
	public ActionEntry(String explicitGuardUnparsed)
	{
		this.explicitGuardUnparsed = explicitGuardUnparsed;
	}
	
	protected abstract String[] getJavaPieces();
	protected abstract PoolEntry[] getPoolEntries();
	protected abstract String[] getGuardExpressions();
	protected abstract String[] getUsedActions();
	
	public int[] getMaxForEachPoolEntry()
	{
		int length = this.getPoolEntries().length;
		int[] maxes = new int[length];
		for (int i = 0; i < maxes.length; i++)
		{
			maxes[i] = this.getPoolEntries()[i].getListSize();
		}
		return maxes;
	}
	//precondition: poolValues.length == this.getPoolEntries().length
	public String makeGetNameMethod(int[] poolValues)
	{
		return null; //TODO unifnished
	}
	//precondition: poolValues.length == this.getPoolEntries().length
	public String makeEnabledMethod(int[] poolValues)
	{
		return null; //TODO unifnished
	}
	//precondition: poolValues.length == this.getPoolEntries().length
	public String makeActMethod(int[] poolValues)
	{
		return null; //TODO unifnished
	}
	
	
}
