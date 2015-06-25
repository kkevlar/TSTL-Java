import java.util.HashMap;


public class LabelFormatter 
{
	private HashMap<String,String> contents;
	public LabelFormatter()
	{
		contents = new HashMap<String, String>();
	}
	public void addToStorage(String key, String value)
	{
		contents.put(key, value);
	}
	public String getAllFormatted()
	{
		String[] keys = contents.keySet().toArray(new String[contents.size()]);
		int maxKeyLength = 0;
		int maxValueLength = 0;
		for (int i = 0; i < keys.length; i++)
		{
			String key = keys[i];
			String value = contents.get(key);
			if(key.length()>maxKeyLength)
				maxKeyLength = key.length();
			if(value.length()>maxValueLength)
				maxValueLength = value.length();
		}
		String ret = "";
		for (int i = 0; i < keys.length; i++)
		{
			String key = keys[i];
			String value = contents.get(key);
			ret += LabelFormatter.padRight(key, maxKeyLength) + ": " + LabelFormatter.padRight(value, maxValueLength);
			if(i != keys.length -1)
				ret += "\n";
		}
		return ret;
	}
	public void clear()
	{
		contents.clear();
	}
	private static String padRight(String s, int n)
	{
	     return String.format("%-" + n + "s", s);  
	}
}
