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
		readTstl();

		createOutWriter();

		readImports();

		//Makes Class Declaration using the filename from the input
		generateClassDeclaration();

		generatePoolEntries();

		generateInstanceVariables();

		generateClearPool();

		//TODO more method generation??
		generateActionsNullArray();
		
		generateFillActionsArray();
		
		generateGetActions();

		generateReset();

		finishingTouches();
	}

	
	private void readTstl()
	{
		String filePath = getInFilepath();
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
		tstl = new ArrayList<String>();
		for(int i = 0; i < lines.size(); i++)
		{
			tstl.add(lines.get(i));
		}
	}
	private void createOutWriter() 
	{
		String outPath = getOutFilepath();
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
				writer.println("import " + importObject);
				tstl.remove(i);
				i--;
			}
		}
		//TODO import arrraylist, test for tstl imports of List and ArrayList and disregard them
		writer.println("import java.util.List;");
	}
	private void generateClassDeclaration()
	{
		String className = TstlConstants.CLASS_NAME_SUT;
		writer.println("public class " + className);
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
					boolean hasParentheses = piece.contains("%");
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
					throw new MalformedTstlException(TstlConstants.MESSAGE_MALFORMED_POOL_DECLARATION + line + "\"");
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
	
	private void generateActionsNullArray() 
	{
		int actionCount = 0;
		//init actions
		for(int x = 0; x < this.poolEntries.length; x++)
		{
			PoolEntry entry = this.poolEntries[x];
			actionCount += entry.getListSize();
		}
		
		
		
	}
	
	private void generateFillActionsArray() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void generateGetActions() 
	{
		//TODO unfinished
	}

	private void generateReset() {
		// TODO Auto-generated method stub

	}

	private void finishingTouches()
	{
		writer.println("}"); //class close brace
		writer.close();
		System.out.println("finished");	
	}	

	private int randFrom(int low, int hi)
	{
		return (int) ((Math.random() * (hi - low)) - low);
	}

	private String getOutFilepath() 
	{
		File inFile = new File(this.getInFilepath());
		File parFile = inFile.getParentFile();
		return parFile.getAbsolutePath() + "/" + TstlConstants.CLASS_NAME_SUT+".java";
	}	

	private String getInFilepath()
	{
		if(args.length > 0)
			return args[0];
		else
		{
			File[] list;
			try {
				list = getThisJarDir().listFiles();
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

	private static File getThisJarDir() throws URISyntaxException
	{
		return new File(TstlParser.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
	}
	private String removePercents(String line, String variablePrefix)
	{
		//used to replace TSTL variables in a line with ones that would compile in java]
		//ie "int %INT% = 5" becomes "int var_INT = 5"
		line = " " + line + " ";

		String[] percentBlocks = line.split("%");
		if(percentBlocks.length % 2 == 0)
			throw new MalformedTstlException("Percent signs must surround variables.  There is an odd number of percent signs at line " + line + ".");
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
		return removePercents(line,TstlConstants.PREFIX_REMOVE_PERCENTS_DEFAULT_VAR);
	}


	/* obsolete in this version- kept around because its parsing my be useful in later versions
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
