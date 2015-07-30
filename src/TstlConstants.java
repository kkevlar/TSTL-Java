import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TstlConstants 
{
	public static final String CLASS_NAME_SUT = "SUT";
	public static final String COMMENT_AUTO_GEN_CODE = "//This is auto-generated code.  Changes will be overwritten.";
	public static final String COMMENT_CORE_FUNCTIONALITY_IMPORT = " //import for SUT.java core functionality";
	public static final String COMMENT_TSTL_SOURCE_IMPORT = " //imported from .tstl source file";
	public static final String CONSTRUCT_ACTION_ARRAY_INSTANCE_VARIABLE = "actions = new Action[";
	public static final String DECLARATION_ACT_METHOD_ACTION_INTERFACE = "public void act();";	
	public static final String DECLARATION_ACTION_ACT_METHOD = "public void act()";	
	public static final String DECLARATION_ACTION_ARRAY_INSTANCE_VARIABLE = "private Action[] actions;";	
	public static final String DECLARATION_ACTION_CLASS = "action = new Action() {";		
	public static final String DECLARATION_ACTION_ENABLED_METHOD = "public boolean enabled()";
	public static final String DECLARATION_ACTION_INTERFACE = "public interface Action";
	public static final String DECLARATION_ACTION_LOCAL_VARIABLE = "Action action;";
	public static final String DECLARATION_ACTION_NAME_METHOD = "public String name()";	
	public static final String DECLARATION_ACTIONS_INIT_METHOD = "private void actionsInit()";
	public static final String DECLARATION_CLEAR_POOL_METHOD = "public void clearPool() {";	
	public static final String DECLARATION_ENABLED_METHOD_ACTION_INTERFACE = "public boolean enabled();";	
	public static final String DECLARATION_NAME_METHOD_ACTION_INTERFACE = "public String name();";
	public static final String DECLARATION_SUT_GETACTIONS_METHOD = "public Action[] getActions()";
	public static final String DECLARATION_SUT_RESET_METHOD = "public void reset()";
	public static final String DECLARATION_ACTION_INITID_METHOD = "initId";
	public static final String FILE_CC_CFG = "cc.cfg";
	public static final String FILE_CUSTOM_CLASSPATH = "cp.cfg";	
	private static final String FILE_LOGGER_LOG = "log.log";	
	public static final String FILE_WANTS_CC = "wantscc.yes";
	public static final String FILE_WASHELP = "washelp.yes";
	public static final String FILENAME_ARGSSTORE = "args.args";	
	public static final String IDENTIFIER_CC_SOURCE = "source:";
	public static final String IDENTIFIER_EXPLICIT_GUARD = "->";	
	public static final String IDENTIFIER_IMPORT = "@import";			
	public static final String IDENTIFIER_INITIALIZATION = ":=";
	public static final String IDENTIFIER_NUMRANGE_LEFT = "[";	
	public static final String IDENTIFIER_NUMRANGE_MID = "..";	
	public static final String IDENTIFIER_NUMRANGE_RIGHT = "]";	
	public static final String IDENTIFIER_POOL = "pool:";
	public static final String IDENTIFIER_PROPERTY = "property:";
	public static final String IDENTIFIER_TSTLVARIABLE = "%";	
	public static final String IMPORT_ARRAY_LIST = "java.util.ArrayList";	
	public static final String IMPORT_LIST = "java.util.List";
	public static final String JAR_COMMONS_CLI = "commons-cli.jar";
	public static final String JAR_EMMA = "emma.jar";
	private static PrintWriter logFileWriter;
	private static boolean logFileWriterCreationFailed;	
	private static Logger logger;
	private static final Level LOGGER_LEVEL = Level.WARNING;
	public static final String MESSAGE_MALFORMED_POOL_DECLARATION = "Malformed pool declaration: ";
	public static final String MESSAGE_NO_TSTL = "Please provide a path to a valid .tstl file in the command line arguments.";
	public static final String MESSAGE_ONLY_ONE_EXPLICIT_GUARD = "Each action can only have one explicit guard.";
	public static final String MESSAGE_UNDEFINED_TSTL_VARIABLE = "Tstl Variable undefined in pool. ";
	public static final String MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS = "Variable identifiers must surround variables: ";
	private static final String PATHKEY_DIR_GENBIN = "genbin";
	private static final String PATHKEY_DIR_GENSRC = "gensrc";
	public static final String PATHKEY_TESTER_OUTPUT_LOG = "tester-output.log";
	public static final String PATHKEY_TESTER_REDUCE_LOG = "test-reduced.log";
	public static final String PATHKEY_TSTLFILE = "tstlfile";
	public static final String PATHKEY_WORKINGDIR = "workingdir";
	private static HashMap<String, String> paths;
	public static final String PREFIX_JAVA_VARIABLES = "var_";
	public static final String SUFFIX_VAR_USED = "_used";
	public static final boolean TESTER_CONFIG_DEFAULT_APPEND_FAILING_TEST = true;
	public static final int TESTER_CONFIG_DEFAULT_IGNORE_CHECK_VALUE = 0;
	public static final int TESTER_CONFIG_DEFAULT_TEST_PRINT_DELAY = 10000;
	public static final int TESTER_CONFIG_DEFAULT_TESTS_PER_CYCLE = 1000;
	public static final int TESTER_CONFIG_DEFAULT_TIMEOUT = 60000;
	public static final String TSTL_JAVA = "TSTL-Java";
	public static final String VISIBILITY_LEVEL_POOL_VAR = "private";
	public static final long SMART_REDUCER_DEFAULT_TIMEOUT = 10000;
	public static final String DECLARATION_ACTION_FAMILY_ID_METHOD = "familyId";

	public static void closeLogger()
	{
		if(logFileWriter != null)
			logFileWriter.close();
		logFileWriter = null;
	}

	public static String excapeString(String s)
	{

		if(s.contains("\""))
		{
			while(true)
			{
				boolean restart = false;
				for(int i = 0; i < s.length(); i++)
				{
					String rep = null;
					if(s.charAt(i) == '"' && !(s.charAt(i-1) == '\\'))				
					{
						rep = "\\" + s.charAt(i)+"";
						s = s.replace(s.charAt(i)+"", rep);
						restart = true;
						break;
					}
				}
				if(restart)
					continue;
				break;
			}
		}

		return s;
	}


	public static String fileInDir(File d, String s)
	{
		return fileInDir(d.getAbsolutePath(),s);
	}

	public static String fileInDir(String d, String s)
	{
		if(d.endsWith("/") && s.startsWith("/"))
			return d + s.substring(1);
		else if(d.endsWith("/") || s.startsWith("/"))
			return (d + s);
		else
			return d + "/" + s;
	}
	
	public static File getGeneratedClassesFolder() 
	{
		String compDir = TstlConstants.getPath(PATHKEY_DIR_GENBIN);
		File compDirFile = new File(compDir);
		compDirFile.mkdirs();
		return compDirFile;
	}
	private static Logger getLogger()
	{
		if(logger == null)
			makeLogger();
		return logger;
	}
	public static String getParserOutputSourceDir()
	{
		File f = new File(TstlConstants.getPath(PATHKEY_DIR_GENSRC));
		f.mkdirs();
		return f.getAbsolutePath() + "/";
	}

	public static String getPath(String pathKey)
	{
		//System.out.println("getpath. key " + pathKey + " map : " + paths);
		if(paths == null)
			paths = new HashMap<String,String>();
		if(paths.containsKey(pathKey))
		{
			return paths.get(pathKey);
		}
		else if (pathKey.equals(TstlConstants.PATHKEY_TSTLFILE))
		{
			File[] list;

			File workingDir = new File(TstlConstants.getPath((TstlConstants.PATHKEY_WORKINGDIR)));
			list = workingDir.listFiles();

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
				if((!file.getName().contains("~")) && extension != null && extension.equals("tstl"))
				{
					return file.getAbsolutePath();
				}
			}
			return TstlConstants.getPath("tstl.tstl");
		}
		else
		{
			File workingDir = new File(TstlConstants.getPath((TstlConstants.PATHKEY_WORKINGDIR)));
			String newPath = workingDir.getAbsolutePath() + "/" + pathKey;
			return newPath;
		}
	}
	public static Repeatable getRepeatableFromVariable(String var, boolean mustBePool, PoolEntry[] entirePoolEntries, String actionLine) 
	{
		Repeatable rep;
		rep = PoolEntry.getPoolEntryByVarName(entirePoolEntries,TstlConstants.PREFIX_JAVA_VARIABLES +var);
		if(rep == null && !mustBePool)
			rep = NumRange.getNumRange(var);
		if(rep == null)
			throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:" + TstlConstants.IDENTIFIER_TSTLVARIABLE + var + TstlConstants.IDENTIFIER_TSTLVARIABLE + " Line:" + actionLine);

		return rep;
	}
	public static String getTstlHomeDir()
	{
		String home = System.getProperty("user.home");
		if(isOnWindows())
		{
			return 	getTstlWinHomeDir(home);
		}
		return getTstlShellHomeDir(home);
	}
	private static String getTstlShellHomeDir(String home) 
	{
		return fileInDir(home,"/.tstljava");
	}

	private static String getTstlWinHomeDir(String home) 
	{
		return fileInDir(home,"/AppData/Roaming/tstljava/");
	}

	public static boolean isOnWindows() 
	{
		String os = System.getProperty("os.name","generic").toLowerCase(Locale.ENGLISH);
		if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) 
		{
			return false;
		} 
		else if (os.indexOf("win") >= 0) 
		{
			return true;
		} 
		else
		{
			return false;
		}
	}

	public static void log(Level level, String msg)
	{
		log(level,msg,null);
	}
	public static void log(Level level, String msg, Throwable caught)
	{
		if(caught != null)
			getLogger().log(level, msg, caught);
		else
			getLogger().log(level, msg);
		if(!logFileWriterCreationFailed && logFileWriter == null)
		{
			File loggerFile = new File(fileInDir(TstlConstants.getTstlHomeDir(),FILE_LOGGER_LOG));
			ArrayList<String> lines = new ArrayList<String>();
			if(loggerFile.exists())
			{
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(loggerFile));
				} catch (FileNotFoundException e) {
					getLogger().log(Level.WARNING, "Failed to read logger log in homedir.", e);
				}
				while(true)
				{
					String line = null;
					try {
						line = reader.readLine();
					} catch (IOException e) {
						getLogger().log(Level.WARNING, "Failed to read logger log in homedir.", e);
					}
					if(line == null)
						break;
					lines.add(line);
				}
				try {
					reader.close();
				} catch (IOException e) {
					getLogger().log(Level.WARNING, "Failed to read logger log in homedir.", e);
				}
			}
			try {
				logFileWriter = new PrintWriter(loggerFile);
			} catch (FileNotFoundException e) {
				getLogger().log(Level.WARNING, "Cannot make logger log in homedir.", e);
				logFileWriterCreationFailed = true;
			}
			for(int i = 0; (!(lines.isEmpty()))&&i<lines.size(); i++)
			{
				logFileWriter.println(lines.get(i));
			}
			logFileWriter.println("--");
			logFileWriter.flush();
		}
		if(logFileWriter != null)
		{
			logFileWriter.println(level.getName()+ ": " + msg);
			logFileWriter.flush();
		}
	}
	public static void log(String msg)
	{
		log(Level.INFO,msg);
	}
	private static void makeLogger() 
	{
		logger = Logger.getLogger(TstlConstants.class.getName());
		logger.setLevel(LOGGER_LEVEL);
	}

	/*
	private static File getThisJarDir() throws URISyntaxException
	{
		File f =  new File(TstlParser.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
		if(f == null)
			return new File("");
		return f;
	}
	 */
	public static void outputDependencies() 
	{
		CodeCopier cc = new CodeCopier();		
		try {
			cc.copyCode();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static LineParsePacket parseVarLine(String varLine, PoolEntry[] entirePoolEntries)
	{
		String[] pieces = varLine.split(TstlConstants.IDENTIFIER_TSTLVARIABLE);
		if(pieces.length % 2 != 1)
			throw new MalformedTstlException(TstlConstants.MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS + varLine);
		String[] javaCodePieces = new String[(pieces.length+1)/2];
		Repeatable[] reps = new Repeatable[(pieces.length-1)/2];
		for (int i = 0; i < pieces.length; i++)
		{
			if(i%2==0)
			{
				int javaIndex = i/2;
				javaCodePieces[javaIndex] = pieces[i];
			}
			else
			{
				Repeatable entry = TstlConstants.getRepeatableFromVariable((pieces[i]).trim(), false, entirePoolEntries, varLine);
				if (entry == null)
					throw new MalformedTstlException(TstlConstants.MESSAGE_UNDEFINED_TSTL_VARIABLE + "Variable:" + TstlConstants.IDENTIFIER_TSTLVARIABLE + pieces[i] + TstlConstants.IDENTIFIER_TSTLVARIABLE + " Line:" + varLine);
				else
					reps[(i-1)/2] = entry;
			}
		}
		return new LineParsePacket(javaCodePieces, reps);
	}
	public static void setPath(String pathkey, String path) 
	{
		if(paths == null)
			paths = new HashMap<String,String>();
		paths.put(pathkey,path);
	}
	public static void writeHomeFile(String name, String text)
	{
		String path = fileInDir(getTstlHomeDir(), name);
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
			log(Level.WARNING, "Writing the "+name+ " file failed. Path: \"" + path + "\"");
		}
	}


}