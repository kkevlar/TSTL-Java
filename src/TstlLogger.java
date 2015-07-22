import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public class TstlLogger 
{
	private static String lastFileName;
	private static PrintWriter saveWriter;
	private String defaultLogFile;
	public TstlLogger()
	{
		this("log");
	}
	public TstlLogger(String def)
	{
		this.setDefaultLogFile(def);
	}
	public void append(String text, boolean b)
	{
		append("",text,b,getDefaultLogFile());
	}
	private String getDefaultLogFile() 
	{
		return defaultLogFile;
	}
	public void append(String text)
	{
		append("",text);
	}
	public void append(String prefix, String text)
	{
		append(prefix,text,true,getDefaultLogFile());
	}
	public void append(String text, boolean newLine, String fileName)
	{
		append("",text,newLine,fileName);
	}
	public void append(String prefix, String text, boolean newLine, String fileName)
	{
		PrintWriter writer = null;
		if(saveWriter != null)
		{
			if(lastFileName.equals(fileName))
				writer = saveWriter;
			else
			{
				saveWriter.close();
				saveWriter = null;
			}
		}
		if(writer == null)
		{
			String logFilePath = TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), fileName + ".log");
			ArrayList<String> lines = new ArrayList<String>();
			File logFile = new File(logFilePath);
			if(logFile.exists())
			{
				Scanner scan = null;
				try {
					scan = new Scanner(logFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(scan != null && scan.hasNextLine())
					lines.add(scan.nextLine());
			}
			try {
				logFile.createNewFile();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				writer = new PrintWriter(logFile);
			} catch (FileNotFoundException e)
			{
				TstlConstants.getLogger().log(Level.WARNING, "Cannot write to log file!",e);
			}
			if(lines.size() > 0)
			{	
				for(int i = 0; i < lines.size(); i++)
				{
					writer.println(lines.get(i));
				}
				writer.println("--");
				writer.flush();
			}
			saveWriter = writer;
			lastFileName = fileName;
		}
		append(prefix,text,newLine,writer);
	}
	public void close()
	{
		if(saveWriter != null)
		{
		saveWriter.close();
		saveWriter = null;
	}
	}
	public void append(String prefix, String text, boolean newLine, PrintWriter writer) 
	{
		if((!(prefix == null || prefix.equals(""))) && !(prefix.endsWith(": ")))
			prefix = prefix + ": ";
		String writeLine = prefix + text;
		if(newLine)
			writeLine += "\n";
		writer.print(writeLine);
		writer.flush();
	}
	public void setDefaultLogFile(String defaultLogFile) 
	{
		this.defaultLogFile = defaultLogFile;
	}
	
}
