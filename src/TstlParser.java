import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class TstlParser implements Runnable
{

	private static final String SUT_CLASS_NAME = "SUT";
	private String[] tstl;
	private FlushWriter writer;

	private String[] args;

	public TstlParser(String[] args)
	{		
		this.args = args;
	}

	public static void main(String[] args)
	{
		new Thread(new TstlParser(args)).start();
	}

	@Override
	public void run()
	{
		readTstl();

		createOutWriter();

		readImports();

		//Makes Class Declaration using the filename from the input
		generateClassDeclaration();

		generateClearPool();

		//TODO more method generation
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
		tstl = new String[lines.size()];
		for(int i = 0; i < lines.size(); i++)
		{
			tstl[i] = lines.get(i);
		}
	}

	private void createOutWriter() 
	{
		String outPath = getOutFilepath();
		try {
			writer = new FlushWriter(new File(outPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void readImports() 
	{
		// TODO unfinished

	}

	private void generateClassDeclaration()
	{
		String className = TstlParser.SUT_CLASS_NAME;
		writer.println("public class " + className);
		writer.println("{");
	}

	private void generateClearPool() 
	{
		// TODO Auto-generated method stub

	}

	private void generateGetActions() {
		// TODO Auto-generated method stub

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
		// TODO unfinished
		return null;
	}	

	private String getInFilepath() 
	{
		// TODO unfinished
		return null;
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
