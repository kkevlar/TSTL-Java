import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestRunner 
{

	public static void main(String[] args) throws IOException
	{
		File argsFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(),(TstlConstants.FILENAME_ARGSSTORE)));
		BufferedReader reader = new BufferedReader(new FileReader(argsFile));
		String line = reader.readLine();
		reader.close();
		String[] newArgs = line.split(" ");
		//System.out.println("split: " + Arrays.toString(newArgs));
		Tester tester = new RandomTester();
		TestRunnerArgsParser parser = new TestRunnerArgsParser(newArgs,tester);
		parser.parse();
		//System.out.println("dir: " + TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR));
		tester.go();
	}

}
