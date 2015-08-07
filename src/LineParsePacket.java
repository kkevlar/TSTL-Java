
public class LineParsePacket 
{
	private String[] javaCodePieces;
	private Repeatable[] repeatables;
	private boolean[] treatAsUnused;
	
	public LineParsePacket(String[] javaCodePieces, Repeatable[] repeatables, boolean[] treatAsUnused) {
		super();
		this.javaCodePieces = javaCodePieces;
		this.repeatables = repeatables;
		this.treatAsUnused = treatAsUnused;
	}

	public boolean[] getTreatAsUnused() 
	{
		return treatAsUnused;
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
