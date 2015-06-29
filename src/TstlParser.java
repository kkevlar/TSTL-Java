import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class TstlParser implements Runnable
{
	private ArrayList<String> tstl;
	private FlushWriter writer;
	private String[] args;
	private PoolEntry[] poolEntries;
	private long actionsPrinted;

	public static void main(String[] args) throws URISyntaxException
	{
		new Thread(new TstlParser(args)).start();		
	}
	public TstlParser(String[] args)
	{		
		this.args = args;
	}
	@Override
	public void run()
	{


		TstlConstants.outputDependencies();


		readTstl();

		createOutWriter();

		readImports();

		//Makes Class Declaration using the filename from the input
		generateClassDeclaration();

		generatePoolEntries();

		generateInstanceVariables();

		generateConstructor();

		generateClearPool();

		generateActionsInit();

		generateGetActions();

		generateReset();

		finishingTouches();

		compileGeneratedClasses();
	}

	private void readTstl()
	{
		String filePath = getInputFileFilepath();
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
			lines.add(line.replace(";", ""));
		}
		tstl = new ArrayList<String>();
		for(int i = 0; i < lines.size(); i++)
		{
			tstl.add(lines.get(i));
		}
	}
	private void createOutWriter() 
	{
		String outPath = getOutputFileFilepath();
		try {
			writer = new FlushWriter(new File(outPath));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		writer.println(TstlConstants.COMMENT_AUTO_GEN_CODE);
	}
	private void readImports() 
	{
		for (int i = 0; i < tstl.size(); i++)
		{
			String line = tstl.get(i);
			if(line.startsWith(TstlConstants.IDENTIFIER_IMPORT))
			{
				String importObject = line.substring(TstlConstants.IDENTIFIER_IMPORT.length());
				if(!(importObject.trim().equals(TstlConstants.IMPORT_ARRAY_LIST) || importObject.trim().equals(TstlConstants.IMPORT_LIST)))
				{
					writer.println("import " + importObject + ";");
				}
				tstl.remove(i);
				i--;
			}
		}
		writer.println("import " + TstlConstants.IMPORT_LIST + ";");
		writer.println("import " + TstlConstants.IMPORT_ARRAY_LIST + ";");
	}
	private void generateClassDeclaration()
	{
		String className = TstlConstants.CLASS_NAME_SUT;
		writer.println("public class " + className + " implements SUTInterface");
		writer.println("{");
	}
	private void generatePoolEntries()
	{
		ArrayList<PoolEntry> poolEntries = new ArrayList<PoolEntry>();
		for (int x = 0; x < tstl.size(); x++)
		{
			String line = tstl.get(x);
			if(line.startsWith(TstlConstants.IDENTIFIER_POOL))
			{
				String restLine = line.substring(TstlConstants.IDENTIFIER_POOL.length());
				String[] restLineSplit = restLine.split(" ");
				String className = null;
				String varName = null;
				int arrSize = 1;
				for (int y = 0; y < restLineSplit.length; y++) 
				{
					String piece = restLineSplit[y];
					boolean hasParentheses = piece.contains(TstlConstants.IDENTIFIER_TSTLVARIABLE);
					boolean canParseInt = false;
					int parsed = -1;
					try
					{
						parsed = Integer.parseInt(piece);
						canParseInt = true;
					}
					catch(RuntimeException ex){}

					if(canParseInt)
						arrSize = parsed;					
					else if(hasParentheses)
					{
						varName = removePercents(piece);
					}
					else
					{
						if(piece != null)
							className = piece;
					}
				}	
				if(className == null || varName == null || arrSize < 1)
					throw new MalformedTstlException(TstlConstants.MESSAGE_MALFORMED_POOL_DECLARATION + "\"" + line + "\"");
				PoolEntry entry = new PoolEntry(className, varName, arrSize);
				poolEntries.add(entry);
				tstl.remove(x);
				x--;
			}
		}

		this.poolEntries = new PoolEntry[poolEntries.size()];
		for (int i = 0; i < this.poolEntries.length; i++) 
		{
			this.poolEntries[i] = poolEntries.get(i);
		}
	}
	private void generateInstanceVariables()
	{
		for(int i =0; i< this.poolEntries.length; i++)
		{
			PoolEntry entry = poolEntries[i];
			writer.println(entry.getInstanceVariableDeclaration(TstlConstants.VISIBILITY_LEVEL_POOL_VAR));
		}
		writer.println(TstlConstants.DECLARATION_ACTION_ARRAY_INSTANCE_VARIABLE);
	}
	private void generateConstructor()
	{
		writer.println("public " + TstlConstants.CLASS_NAME_SUT + "()"+ "\n"
				+"{"+ "\n"
				+"clearPool();"+ "\n"
				+"actionsInit();"+ "\n"
				+"}"+ "\n");

	}
	private void generateClearPool() 
	{
		writer.println(TstlConstants.DECLARATION_CLEAR_POOL_METHOD);
		for (int i = 0; i < poolEntries.length; i++) 
		{
			PoolEntry entry = poolEntries[i];
			writer.println(entry.getClearLines());
		}
		writer.println("}");

	}

	private void generateActionsInit() 
	{
		writer.println(TstlConstants.DECLARATION_ACTIONS_INIT_METHOD + " {");

		ArrayList<String> actionLines = new ArrayList<String>();
		int totalCount = 0;
		for(int i = 0; i < tstl.size(); i++)
		{
			if(!tstl.get(i).equals(""))
			{
				ActionEntry entry = makeActionEntry(tstl.get(i));
				actionLines.add(tstl.get(i));
				totalCount += entry.getActionCount();
			}
		}	
		writer.println(TstlConstants.CONSTRUCT_ACTION_ARRAY_INSTANCE_VARIABLE + totalCount + "];");
		writer.println(TstlConstants.DECLARATION_ACTION_LOCAL_VARIABLE);
		for(int i = 0; i < actionLines.size(); i++)
		{			
			this.printAllActions(this.makeActionEntry(actionLines.get(i)));
		}
		writer.println("}//close actionInit()");
	}
	private ActionEntry makeActionEntry(String tstlLine) 
	{
		String[] parts = ActionEntry.splitActionLine(tstlLine);
		ActionEntry entry = new ActionEntry(parts[0],parts[1],this.poolEntries);
		return entry;
	}

	private void printAllActions(ActionEntry entry) 
	{
		int[] ints = new int[entry.getRepeatables().length];
		for (int i = 0; i < ints.length; i++) 
		{
			ints[i] = -1;
		}
		this.printAllActions(entry,ints);		
	}
	private void printAllActions(ActionEntry entry, int[] ints)
	{
		int[] newInts = new int[ints.length];
		int negativeIndex = -1;
		for (int i = 0; i < newInts.length; i++) 
		{
			newInts[i] = ints[i];
			if(newInts[i] == -1)
			{
				negativeIndex = i;
			}
		}
		if(negativeIndex == -1)
		{
			printAction(entry, newInts);
			return;
		}
		for(int i = 0; i < entry.getRepeatables()[negativeIndex].getListSize(); i++)
		{
			newInts[negativeIndex] = i;
			this.printAllActions(entry, newInts);
		}	

	}

	private void printAction(ActionEntry entry, int[] poolValues)
	{
		writer.println(entry.createActionClass(poolValues));	
		writer.println("actions[" + actionsPrinted + "] = action;");
		actionsPrinted++;
	}

	private void generateGetActions() 
	{
		String ret = TstlConstants.DECLARATION_SUT_GETACTIONS_METHOD + "\n";
		ret +="{\n";
		ret +="return actions;\n";
		ret +="}//close reset()\n";
		writer.print(ret);
	}

	private void generateReset()
	{
		String ret = TstlConstants.DECLARATION_SUT_RESET_METHOD + "\n";
		ret +="{\n";
		ret +="clearPool();\n";
		ret +="}//close reset()\n";
		writer.print(ret);
	}

	private void finishingTouches()
	{
		writer.println("}//class close brace"); 
		writer.close();
		System.out.println("finished");	
	}	

	private void compileGeneratedClasses() 
	{
		TstlConstants.getGeneratedClassesFolder();
		/*
		boolean success = false;
		try
		{
			compileCode("javac");
			success = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(success)
			return;
		new File(TstlConstants.getAppDataDir()).mkdirs();
		String filePath = TstlConstants.getAppDataDir() + "/javac.whereis";
		String javacPath = null;
		try
		{
			File whereIs = new File(filePath);
			if(whereIs.exists())
			{
				Scanner scan = new Scanner(whereIs);
				javacPath = scan.nextLine();
				scan.close();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(javacPath != null && javacPath.equals(""))
			javacPath = null;
		if(javacPath == null)
		{
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Please point to your jdk/bin/javac file.");
			chooser.showOpenDialog(null);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File f = chooser.getSelectedFile();
			javacPath = f.getAbsolutePath();
			try
			{
				File whereIs = new File(filePath);
				whereIs.createNewFile();
				PrintWriter writer = new PrintWriter(whereIs);
				writer.println(javacPath);
				writer.flush();
				writer.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		try 
		{
			compileCode(javacPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		

	}
	
	private void compileCode(String javacPath) throws IOException
	{
		javacPath = "\""+ javacPath + "\"";
		Runtime run = Runtime.getRuntime();
		String srcDir = TstlConstants.getParserOutputSourceDir();
		String srcMainClass = srcDir + TstlConstants.GEN_CLASS_MAIN;
		String compDir = new File(srcDir).getParentFile().getAbsolutePath() + "/genbin";
		//System.out.println(srcDir);
		srcDir = srcDir.substring(0, srcDir.length()-1);
		//System.out.println(srcDir);
		File compDirFile = new File(compDir);
		compDirFile.mkdirs();
		String compDirArg = "\"" +compDir.replace("/", "\\") + "\"";
		String srcDirArg = "\"" +srcDir.replace("/", "\\") + "\"";
		String srcMainClassArg = "\"" +srcMainClass.replace("/", "\\") + "\"";
		//compDirArg = "\"C:\\Users\\Kevin\\Documents\\Eclipse Luna\\workspaceJ\\TSTL-Java\\genbin\"";
		//String srcDirArg = "\"C:\\Users\\Kevin\\Documents\\Eclipse Luna\\workspaceJ\\TSTL-Java\\gensrc\"";
		//String srcMainClassArg  = "\"C:\\Users\\Kevin\\Documents\\Eclipse Luna\\workspaceJ\\TSTL-Java\\gensrc\\RandomTester.java\"";
		//System.out.println(compDirArg);
		//System.out.println(srcMainClassArg);
		//System.out.println(srcDirArg);
		String exec =  javacPath +  " -d "+compDirArg+" -sourcepath "+srcDirArg+" "+srcMainClassArg;
		//System.out.println(exec);
		//File runDir = new File("C:\\Users\\Kevin\\Documents\\Eclipse Luna\\workspaceJ\\TSTL-Java\\");
			Process p = run.exec(new String[]{exec}, null, null);
		//ProcessBuilder pb = new ProcessBuilder("javac" +  " -d out "+ "-sourcepath output \\output\\SUT.java");
		//pb.directory(new File("C:\\Users\\Kevin\\Documents\\Eclipse Luna\\workspaceJ\\TSTL-Java\\"));
		String classPath = compDir + "/" + TstlConstants.GEN_CLASS_MAIN.replace(".java", "");
		//exec = "java "  + classPath.replace("/", "\\");
		exec = "java RandomTester";
		exec = "cmd /C \"" + "cd " + "\"" + compDir.replace("/", "\\") + "\"" + " && " + exec + "\"";
		System.out.println(exec);
		run.exec(exec);
	}

	private String getOutputFileFilepath() 
	{
		return TstlConstants.getParserOutputSourceDir()+ TstlConstants.CLASS_NAME_SUT+".java";
	}	

	private String getInputFileFilepath()
	{
		if(args.length > 0)
			return args[0];
		else
		{
			File[] list;
			try {
				list = TstlConstants.getThisJarDir().listFiles();
			} 
			catch (URISyntaxException e) 
			{
				throw new BadArgumentsException(TstlConstants.MESSAGE_NO_TSTL);
			}
			for (int i = 0; i < list.length; i++) 
			{
				File file = list[i];
				String extension = null;
				try
				{
					String[] pieces = file.getName().replace(".", "~").split("~");
					extension = pieces[pieces.length -1];
				}
				catch(RuntimeException ex) {}
				if(extension != null && extension.equals("tstl"))
				{
					return file.getAbsolutePath();

				}
			}
		}
		throw new BadArgumentsException(TstlConstants.MESSAGE_NO_TSTL);
	}

	private String removePercents(String line, String variablePrefix)
	{
		//used to replace TSTL variables in a line with ones that would compile in java]
		//ie "int %INT% = 5" becomes "int var_INT = 5"
		line = " " + line + " ";

		String[] percentBlocks = line.split(TstlConstants.IDENTIFIER_TSTLVARIABLE);
		if(percentBlocks.length % 2 == 0)
			throw new MalformedTstlException(TstlConstants.MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS + line);
		for(int i = 1; i < percentBlocks.length; i+= 2)
		{
			String block = percentBlocks[i];

			percentBlocks[i] = variablePrefix + block;
		}
		String newLine = "";
		for(int i = 0; i < percentBlocks.length; i++)
		{
			newLine += percentBlocks[i];
		}
		return newLine;
	}
	private String removePercents(String line)
	{
		return removePercents(line,TstlConstants.PREFIX_JAVA_VARIABLES);
	}


	/* obsolete in this version- kept around because its parsing may be useful in later versions
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
			//handles random number generation from TSTL ie [1..25] is random # 1-25
			//in the future an AI could decide the most valid test pool value from 1-25
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

	private String removePercents(String line, String variablePrefix, int lineCount)
	{
		//used to replace TSTL variables in a line with ones that would compile in java]
		//ie "int %INT% = 5" becomes "int p_INT = 5"
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
	 */

}
