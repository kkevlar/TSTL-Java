import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TstlParserArgParser 
{
	private static final Logger log = Logger.getLogger(TstlParserArgParser.class.getName());
	private String[] args = null;
	private Options options = new Options();
	
	public TstlParserArgParser(String[] args)
	{

		this.args = args;
		options.addOption("h", "help", false, "[OPTIONAL] Displays help.");
		options.addOption("p", "path", true, "[REQUIRED] Path to working directory. (should be provided by command line script)");
		options.addOption("t", "tstl", false, "[OPTIONAL] Path to tstl file. Should work for java.io.File construciton.");
		
		
	}

	public void parse() 
	{
		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("h"))
			{
				help();
			} 
			if(!cmd.hasOption("p"))
			{
				log.log(Level.SEVERE, "No path to working directory! Are you running with the instal script?");
				help();
			}
			TstlConstants.setPath(TstlConstants.PATHKEY_WORKINGDIR,cmd.getOptionValue("p"));			

			if (cmd.hasOption("t")) 
			{
				TstlConstants.setPath(TstlConstants.PATHKEY_TSTLFILE,cmd.getOptionValue("t"));
			} 
			

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}
	}

	private void help() 
	{
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();

		formater.printHelp("Main", options);
		System.exit(0);
	}
}
