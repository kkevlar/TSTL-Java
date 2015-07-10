import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
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
