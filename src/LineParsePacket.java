
public class LineParsePacket 
{
	private String[] javaCodePieces;
	private Repeatable[] repeatables;
	public LineParsePacket(String[] javaCodePieces, Repeatable[] repeatables) 
	{
		super();
		this.javaCodePieces = javaCodePieces;
		this.repeatables = repeatables;
	}
	public String[] getJavaCodePieces() 
	{
		return javaCodePieces;
	}
	
	public Repeatable[] getRepeatables() 
	{
		return repeatables;
	}
	
}
