import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestRunner 
{

	public static void main(String[] args) throws IOException
	{
		String[] newArgs;
		if(args == null || args.length == 0)
		{
			File argsFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(),(TstlConstants.FILENAME_ARGSSTORE)));
			BufferedReader reader = new BufferedReader(new FileReader(argsFile));
			String line = reader.readLine();
			reader.close();
			newArgs = line.split(" ");
		}
		else
			newArgs = args;
		//System.out.println("split: " + Arrays.toString(newArgs));
		Tester tester = new RandomTester();
		TestRunnerArgsParser parser = new TestRunnerArgsParser(newArgs,tester);
		parser.parse();
		//System.out.println("dir: " + TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR));
		tester.go();
		TstlConstants.closeLogger();
	}

}
