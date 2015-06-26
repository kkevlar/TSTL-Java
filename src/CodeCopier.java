import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CodeCopier
{
	public void copyCode(String className) throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		InputStream stream = this.getClass().getResourceAsStream(className);
		if(stream == null)
		 stream = this.getClass().getResourceAsStream("src/" + className);
		if(stream == null)
			 stream = this.getClass().getResourceAsStream("/src/" + className);
		if(stream == null)
			 stream = this.getClass().getResourceAsStream("src\\" + className);
		if(stream == null)
			 stream = this.getClass().getResourceAsStream("\\src\\" + className);
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
		String[] strings = (String[]) lines.toArray(new String[lines.size()]);
		File outFile = new File(TstlConstants.getParserOutputDir().getAbsolutePath() + className);
		outFile.createNewFile();
		PrintWriter writer = new PrintWriter(outFile);
		for (int i = 0; i < strings.length; i++) 
		{
			writer.println(strings[i]);
		}
		writer.flush();
		writer.close();
	}
}
