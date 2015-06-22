import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class TstlReaderMain implements Runnable
{
	private static final String ARGLABEL_INPUT_FILEPATH = "infile";
	private static final String ARGLABEL_OUTPUT_FILEPATH = "outfile";
	private static final String ARGLABEL_TESTCOUNT = "count";
	private HashMap<String, String> args;
	private String[] tstl;
	private FlushWriter writer;
	private int lineCount;
	private String className;

	public TstlReaderMain(HashMap<String, String> arguments)
	{		
		this.args = arguments;

	}

	public static void main(String[] args)
	{
		HashMap<String,String> arguments = new HashMap<String,String>();
		for(int i = 0; i < args.length; i++)
		{
			String[] pieces = args[i].replace(":", "~").replace(",", "~").split("~");
			if(pieces.length == 2)
				arguments.put(pieces[0], pieces[1]);
		}
		new Thread(new TstlReaderMain(arguments)).start();
	}

	@Override
	public void run()
	{
		readTstl();
		createOutWriter();
		lineCount = 0;
		//imports
		while(true)
		{
			if(tstl[lineCount].startsWith("import:"))
			{
				writer.println("import " + tstl[lineCount].replace(":", "~").split("~"));
				lineCount++;
			}
			else
				break;
		}

		//classdeclaration
		className = new File(this.getArg(TstlReaderMain.ARGLABEL_INPUT_FILEPATH)).getName().replace(".", "~").split("~")[0];
		writer.println("public class " + className);
		writer.println("{");

		constructMainMethod();
		
		

	}
	private void constructMainMethod() 
	{
		//main method
		writer.println("public static void main (String[] args)");
		writer.println("{");
		writer.println(className + " x = new " + className + "();");

		int testCount;
		try
		{
			testCount = Integer.parseInt(getArg(TstlReaderMain.ARGLABEL_TESTCOUNT));
		}
		catch(Exception ex)
		{
			throw new BadArgumentsException(TstlReaderMain.ARGLABEL_TESTCOUNT,"not an integer");
		}
		for(int i = 0; i < testCount; i++)
		{
			writer.println("try{");
			writer.println("x.body" + i + "();");
			writer.println("}catch(TstlException ex){");
			writer.println("System.out.println(\"Test " + i + " failed\");");
			writer.println("System.out.println(ex.getMessage());");
			writer.println("}");
		}
		writer.println("}"); //mainmethod close brace

	}

	private void createOutWriter() 
	{
		String outPath = getOutPath();
		try {
			writer = new FlushWriter(new File(outPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String getOutPath()
	{
		String outPath = getArg(ARGLABEL_OUTPUT_FILEPATH,false);
		if(outPath == null)
			outPath = getArg(ARGLABEL_INPUT_FILEPATH).replace(".tstl", ".java");
		return outPath;
	}

	private void readTstl()
	{
		String filePath = getArg(ARGLABEL_INPUT_FILEPATH);
		if(!filePath.endsWith(".tstl"))
		{
			throw new BadArgumentsException(ARGLABEL_INPUT_FILEPATH,"missing proper extension");
		}
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> lines = new ArrayList<String>();
		boolean hadNull = false;
		while(true)
		{
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line == null)
			{
				if(!hadNull)
				{
					hadNull = true;
					continue;
				}
				else
					break;
			}
			lines.add(line);
		}
		tstl = new String[lines.size()];
		for(int i = 0; i < lines.size(); i++)
		{
			tstl[i] = lines.get(i);
		}
	}
	private String getArg(String argName, boolean exception)
	{
		if(args.containsKey(argName))
			return args.get(argName);
		else if(!exception)
			return null;
		else
			throw new BadArgumentsException(argName,"missing");
	}
	private String getArg(String argName)
	{
		return this.getArg(argName,true);
	}

}
