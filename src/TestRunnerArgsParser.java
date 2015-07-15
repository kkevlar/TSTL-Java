import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TestRunnerArgsParser extends BasicParser
{
	private static final Logger log = Logger.getLogger(TestRunnerArgsParser.class.getName());
	private String[] args = null;
	private Options options;
	private Tester tester;
	public TestRunnerArgsParser(String[] args, Tester tester)
	{
		this.args = args;
		options = makeOptions();
		this.tester = tester;
	}
	public static Options makeOptions()
	{
		Options stat = new Options();
		stat.addOption("p", "path", true, "[REQUIRED] Path to working directory. (should be provided by command line script)");
		stat.addOption("m", "timeout", true, "[OPTIONAL] Timeout in milliseconds. Default is one minute (60000).");
		stat.addOption("d", "printdelay", true, "[OPTIONAL] Delay (in millisecons) between entire tests printed. Default is 10 seconds (10000).");
		stat.addOption("i", "ignorecheck", true, "[OPTIONAL] Should the tester ignore properties from tstl? 0=never 1=when_not_reducing 2=always. Defualt is never (0).");
		stat.addOption("c", "tests", true, "[OPTIONAL] Tests per reset. Defualt is 1000.");
		stat.addOption("a", "noappend", false, "[OPTIONAL] The final (failing) test will not be appended to each subtest when reducing if enabled. Default is not including this.");
		return stat;
	}

	public void parse() 
	{
		CommandLine cmd = null;
		try {
			cmd = this.parse(options, args);
			if(!cmd.hasOption("p"))
			{
				log.log(Level.SEVERE, "No path to working directory! Are you running with the instal script?");
				System.exit(-1);
			}
			System.out.println("setpath " + cmd.getOptionValue("p"));
			TstlConstants.setPath(TstlConstants.PATHKEY_WORKINGDIR,cmd.getOptionValue("p"));	
			if(cmd.hasOption("m"))
				tester.setTimeout(Long.parseLong(cmd.getOptionValue("m")));
			if(cmd.hasOption("d"))
				tester.setTestPrintDelay(Long.parseLong(cmd.getOptionValue("d")));
			if(cmd.hasOption("i"))
				tester.setIgnoreCheckValue(Integer.parseInt(cmd.getOptionValue("i")));
			if(cmd.hasOption("c"))
				tester.setTestsPerCycle(Integer.parseInt(cmd.getOptionValue("c")));		
			if(cmd.hasOption("a"))
				tester.setShouldAppendFailingTest(false);
		} catch (ParseException e) 
		{
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			System.exit(-1);
		}

	}
	@Override
	protected void processOption(final String arg, final ListIterator iterator) throws ParseException 
	{
		boolean hasOption = options.hasOption(arg);

		if (hasOption)
		{
			System.out.println("setting");
			super.processOption(arg, iterator);
		}

	}

}
