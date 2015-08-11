import java.util.HashMap;

public abstract class Repeatable 
{
	protected static HashMap<Integer,String> poolwideMap;
	private static int constructCount;
	private int id;
	public Repeatable()
	{
		setId(constructCount);
		constructCount++;
		if(poolwideMap == null)
			poolwideMap = new HashMap<Integer,String>();
		
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	public abstract int getListSize();
	public abstract String getAsJava(int i);
	public abstract String getIsUsableExpression(int i);
	public abstract String getCanOverwriteExpression(int i);
	public abstract boolean equalsRepeatable(Repeatable rep);
	public abstract String getAsFormattedTstl(int i);
}
