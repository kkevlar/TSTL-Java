
public abstract class Repeatable 
{
	private static int constructCount;
	private int id;
	public Repeatable()
	{
		setId(constructCount);
		constructCount++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract int getListSize();
	public abstract String getAsJava(int i);
	public abstract String getIsUsableExpression(int i);
	public abstract String getCanOverwriteExpression(int i);
	public abstract boolean equalsRepeatable(Repeatable rep);
}
