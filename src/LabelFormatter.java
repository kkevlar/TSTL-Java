import java.util.Arrays;
import java.util.HashMap;


public class LabelFormatter 
{
	private HashMap<String,String> contents;
	private String splitter;
	public LabelFormatter()
	{
		contents = new HashMap<String, String>();
		splitter = ":";
	}
	public LabelFormatter(String splitter) 
	{
		this();
		this.setSplitter(splitter);
	}
	public void addToStorage(String key, String value)
	{
		contents.put(((contents.size()+1)+TstlConstants.LABEL_FORMATTER_SPLIT + key), value);
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
		Arrays.sort(keys);
		String ret = "";
		for (int i = 0; i < keys.length; i++)
		{
			String key = keys[i];
			String value = contents.get(key);
			ret += (LabelFormatter.padRight(key.split(TstlConstants.LABEL_FORMATTER_SPLIT)[1], maxKeyLength) + splitter + value);
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
	public String getSplitter() 
	{
		return splitter;
	}
	public void setSplitter(String splitter) 
	{
		this.splitter = splitter;
	}
	
}
