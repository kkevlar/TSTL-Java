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
	private String className;
	private int bodyEndLine;

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
		if(arguments.isEmpty())
		{
			System.out.println("Please provide arguments: infile:<filepath> outfile:<filepath> count:<number>");
			System.out.println("The count is the number of tests that will be generated.");
		}
		new Thread(new TstlReaderMain(arguments)).start();
	}

	@Override
	public void run()
	{
		readTstl();
		createOutWriter();
		int lineCount = 0;
		//imports
		while(true)
		{
			if(tstl[lineCount].startsWith("import"))
			{
				writer.println(tstl[lineCount]);
				lineCount++;
			}
			else
				break;
		}

		//classdeclaration
		className = new File(this.getArg(TstlReaderMain.ARGLABEL_INPUT_FILEPATH)).getName().replace(".", "~").split("~")[0];
		writer.println("public class " + className);
		writer.println("{");

		//main method
		constructMainMethod();

		//need to make helper methods
		while(true)
		{
			if(tstl[lineCount].equalsIgnoreCase("body:"))
				break;
			String methodName = "p_" + tstl[lineCount].split("\\(")[0];
			String methodDeclaration = "private void " + methodName + "(" + removePercents(tstl[lineCount].split("\\(")[1], "p_",lineCount )+ " throws TstlException {";
			writer.println(methodDeclaration);
			lineCount++;
			while(true)
			{
				if(!tstl[lineCount].startsWith("END"))
				{
					String noPercent = removePercents(tstl[lineCount], "p_",lineCount);
					writer.println(noPercent);
				}
				else
					break;
				lineCount++;
			}
			writer.println("}");
			lineCount++;
		}


		//body methods
		for(int i = 0; i < getTestCount(); i++)
		{
			this.constructBodyMethod(i, lineCount);
		}
		
		writer.println("}"); //class close brace
		writer.close();
		System.out.println("finished");



	}
	private String removePercents(String line, String variablePrefix, int lineCount)
	{
		line = " " + line + " ";
		boolean asserted = false;
		String[] percentBlocks = line.split("%");
		if(percentBlocks.length % 2 == 0)
			throw new MalformedTstlException("Percent signs must surround variables.  There is an odd number of percent signs at line " + lineCount + ".");
		for(int i = 1; i < percentBlocks.length; i+= 2)
		{
			String block = percentBlocks[i];
			if(block.equals("assert"))
			{
				percentBlocks[i] = "if (!";
				asserted = true;
			}
			else
				percentBlocks[i] = variablePrefix + block;

		}
		String newLine = "";
		for(int i = 0; i < percentBlocks.length; i++)
		{
			newLine += percentBlocks[i];
		}
		if(asserted)
			newLine = newLine + ")\n throw new TstlException();";
		newLine.substring(1, newLine.length() - 2);
		return newLine;
	}
	private void constructBodyMethod(int num, int tstlLineAfterImport)
	{
		writer.println("private void body" + num + "() throws TstlException {");
		//pool creation
		int lastPool = -1;
		for(int i =0 ; i < tstl.length; i++)
		{
			String s = tstl[i];
			if(s.startsWith("pool:"))
			{				

				s= s.substring(5);
				s = removePercents(s, "p_", i) + ";";
				writer.println(s);
				lastPool = i;
			}
		}
		//defining start and end lines
		int bodyStartLine = lastPool+1;
		bodyEndLine = -1;
		for(int i =0 ; i < tstl.length; i++)
		{
			String s = tstl[i];

			if(s.startsWith("ENDBODY"))
				bodyEndLine = i;
		}
		//writing method body
		for(int x = bodyStartLine; x < bodyEndLine; x++)
		{

			String line = tstl[x];

			line = line.replace("%[", "~");
			line = line.replace("]%", "~");
			String[] pieces = line.split("~");
			ArrayList<Integer> numPiecesNums = new ArrayList<Integer>();
			for(int y = 0; y < pieces.length; y++)
			{
				String piece = pieces[y].replace("..", "~");
				if(piece.contains("~"))
				{
					String[] numPieces = piece.split("~");
					int low = Integer.parseInt(numPieces[0]);
					int hi = Integer.parseInt(numPieces[1]);
					numPiecesNums.add(this.randFrom(low, hi));
				}
			}
			String newLine = "";
			boolean copyMode = true;

			for(int y = 0; y < line.length(); y++)
			{

				int numPieceIndex = 0;
				char c = line.charAt(y);

				boolean isBreakChar = c=='~';
				//if there is no random number generation, copyMode will always be true, while isBreakChar will always be false: the next expression will always evaluate true
				if(copyMode)
				{
					if(isBreakChar)
					{
						copyMode = false;
						newLine = newLine + numPiecesNums.get(numPieceIndex);
						numPieceIndex++;
						//System.out.println(line + "   " + c + "  =copymode");
					}
					else
					{
						newLine = newLine + c;
						//System.out.println(line + "   " + c + "  !=");
					}
				}
				else
				{
					if(isBreakChar)
					{
						copyMode = true;
						//System.out.println(line + "   " + c + "  =else");
					}

				}
			}
			newLine = removePercents(newLine, "p_", x);
			writer.println(newLine);
		}		
		writer.println("}"); //body method end brace		
	}
	private int randFrom(int low, int hi)
	{
		return (int) ((Math.random() * (hi - low)) - low);
	}
	private void constructMainMethod() 
	{

		writer.println("public static void main (String[] args)");
		writer.println("{");
		writer.println(className + " x = new " + className + "();");

		int testCount = getTestCount();
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
	private int getTestCount()
	{
		try
		{
			return Integer.parseInt(getArg(TstlReaderMain.ARGLABEL_TESTCOUNT));
		}
		catch(Exception ex)
		{
			throw new BadArgumentsException(TstlReaderMain.ARGLABEL_TESTCOUNT,"not an integer");
		}
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
