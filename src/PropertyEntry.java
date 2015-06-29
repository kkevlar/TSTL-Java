import java.util.ArrayList;


public class PropertyEntry 
{
	private static ArrayList<PropertyEntry> entrys;
	//constructor will take args
	public PropertyEntry()
	{
		if(entrys == null)
			entrys = new ArrayList<PropertyEntry>();
		entrys.add(this);
		this.parseMe();
	}
	//method will take constructor's args
	private void parseMe() 
	{
		//TODO write parse method
	}
}
