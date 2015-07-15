import java.io.File;
import java.io.PrintWriter;
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

public class TstlParserArgParser extends BasicParser
{
	private static final Logger log = Logger.getLogger(TstlParserArgParser.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public TstlParserArgParser(String[] args)
	{

		this.args = args;
		options.addOption("h", "help", false, "[OPTIONAL] Displays help.");
		options.addOption("p", "path", true, "[REQUIRED] Path to working directory. (should be provided by command line script)");
		options.addOption("t", "tstl", true, "[OPTIONAL] Path to tstl file. Should work for java.io.File construciton.");
		options.addOption("j", "classpath", true, "[OPTIONAL] Jars or directories to add to the classpath at compiletime and runtime. Separated by '~' '.' or ','.");
	}
	@Override
	protected void processOption(final String arg, final ListIterator iterator) throws ParseException 
	{
		boolean hasOption = options.hasOption(arg);

		if (hasOption)
		{
			super.processOption(arg, iterator);
		}

	}


	public void parse() 
	{

		CommandLine cmd = null;
		try {
			cmd = this.parse(options, args);

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
			writeToClasspathStore(cmd);

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}
		writeHomeFile(TstlConstants.FILE_WASHELP, false +"");

	}
	private void writeToClasspathStore(CommandLine cmd) 
	{
		if(cmd.hasOption("j"))
		{
			String cClasspath = cmd.getOptionValue("j");
			cClasspath = ":" + cClasspath.replace(",", "~").replace("~", ":");
			writeHomeFile(TstlConstants.FILE_CUSTOM_CLASSPATH, cClasspath);
		}
	}
	private void writeHomeFile(String name, String text)
	{
		String path = TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), name);
		try
		{	
			File file = new File(path);
			file.createNewFile();

			PrintWriter writer = new PrintWriter(file);
			writer.println(text);
			writer.flush();
			writer.close();
		}
		catch (Exception ex)
		{
			log.log(Level.WARNING, "Writing the "+name+ " file failed. Path: \"" + path + "\"");
		}
	}

	private void help() 
	{
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();
		Options helpOptions = new Options();

		Collection<Option> coll = options.getOptions();
		Option[] thisOptions = coll.toArray(new Option[coll.size()]);
		for (int i = 0; i < thisOptions.length; i++) 
		{
			helpOptions.addOption(thisOptions[i]);
		}

		Options runOptions = TestRunnerArgsParser.makeOptions();
		Collection<Option> runColl = runOptions.getOptions();
		Option[] runOptionArr = runColl.toArray(new Option[runColl.size()]);
		for (int i = 0; i < runOptionArr.length; i++) 
		{
			Option o = runOptionArr[i];
			if(!o.getOpt().equals("p"))
				helpOptions.addOption(o);
		}

		formater.printHelp("Main", helpOptions);
		writeHomeFile(TstlConstants.FILE_WASHELP, true +"");
		System.exit(0);
	}
}
