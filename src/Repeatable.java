import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;

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
	public static void writePoolwideMapToFile()
	{
		File mapFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), TstlConstants.FILE_POOLWIDE_MAP));			
		PrintWriter writer = null;
		try 
		{
			mapFile.createNewFile();
			writer = new PrintWriter(mapFile);
		} 
		catch (IOException e) 
		{
			TstlConstants.log(Level.SEVERE, "Failed to write poolwidemap file!", e);
			return;
		}
		finally
		{
			if(writer == null)
				return;
		}
		
		Integer[] integerPoolIds = poolwideMap.keySet().toArray(new Integer[poolwideMap.size()]);
		for (int i = 0; i < integerPoolIds.length; i++) 
		{
			writer.println(integerPoolIds[i] + TstlConstants.SPLIT_SYNTAX_POOLENTRY_ID_AND_CLASSNAME +poolwideMap.get(integerPoolIds[i]));
		}	
		writer.flush();
		writer.close();	
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
