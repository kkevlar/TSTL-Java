import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CodeCopier
{
	private void copyCode(String className) throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		InputStream stream = this.getClass().getResourceAsStream("res/" + className + ".nocompile");
		if(stream == null)
		{
			stream = this.getClass().getResourceAsStream("res/" + className);
		}
		if(stream == null)
		{
			System.out.println("null");
			System.exit(-1);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while(true)
		{
			String line = reader.readLine();
			if(line != null)
				lines.add(line);
			else
				break;
		}
		reader.close();
		String[] strings = lines.toArray(new String[lines.size()]);
		String[] split = className.replace(".", "~").split("~");
		String newClassName = "";
		for (int i = 0; i < split.length; i++) 
		{
			newClassName += split[i] + ".";
		}
		newClassName = newClassName.substring(0, newClassName.length() -1);
		File outFile = new File(TstlConstants.getParserOutputSourceDir()+ newClassName);
		outFile.createNewFile();
		PrintWriter writer = new PrintWriter(outFile);
		for (int i = 0; i < strings.length; i++) 
		{
			writer.println(strings[i]);
		}
		writer.flush();
		writer.close();
	}

	public void copyCode() throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		InputStream stream = this.getClass().getResourceAsStream("res/" + "names");
		if(stream == null)
		{
			System.out.println("null");
			System.exit(-1);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while(true)
		{
			String line = reader.readLine();
			if(line != null)
				lines.add(line);
			else
				break;
		}
		reader.close();

		for (int i = 0; i < lines.size(); i++) 
		{
			if(!lines.get(i).equals("SUT.java"))
				this.copyCode(lines.get(i));
		}		
	}
}
