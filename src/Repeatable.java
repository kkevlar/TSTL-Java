
public interface Repeatable 
{
	public int getListSize();
	public String getAsJava(int i);
	public String getIsUsableExpression(int i);
	public String getCanOverwriteExpression(int i);
	public boolean equalsRepeatable(Repeatable rep);
}
