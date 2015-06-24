
public class NumRange implements Repeatable 
{

	private int low;
	private int hi;

	public static NumRange getNumRange(String s)
	{
		String[] pieces = s.replace(TstlConstants.IDENTIFIER_NUMRANGE_LEFT, "").replace(TstlConstants.IDENTIFIER_NUMRANGE_RIGHT, "").replace(TstlConstants.IDENTIFIER_NUMRANGE_MID,"~").split("~");
		if(pieces.length < 2 || pieces.length > 2)
			return null;
		int low = -1;
		int hi = -1;
		try
		{
			low = Integer.parseInt(pieces[0]);
			hi = Integer.parseInt(pieces[1]);
		}
		catch(RuntimeException ex)
		{
			return null;
		}
		return new NumRange(low,hi);
	}
	private NumRange(int low, int hi) 
	{
		super();
		this.low = low;
		this.hi = hi;
	}

	@Override
	public int getListSize() 
	{
		return hi-low+1;
	}

	@Override
	public String getAsJava(int i)
	{
		return low+i+"";
	}
	@Override
	public String getIsUsableExpression(int i) 
	{
		return true+"";
	}
	@Override
	public String getCanOverwriteExpression(int i)
	{
		return true+"";
	}

}
