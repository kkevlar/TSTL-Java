import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;


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

	public static final String DIR_GENBIN = "genbin";	
	public static final String DIR_GENSRC = "gensrc";

	public static final String GEN_CLASS_MAIN = "RandomTester.java";	

	public static final String IDENTIFIER_EXPLICIT_GUARD = "->";
	public static final String IDENTIFIER_IMPORT = "@import";
	public static final String IDENTIFIER_INITIALIZATION = ":=";	
	public static final String IDENTIFIER_NUMRANGE_LEFT = "[";
	public static final String IDENTIFIER_NUMRANGE_MID = "..";	
	public static final String IDENTIFIER_NUMRANGE_RIGHT = "]";			
	public static final String IDENTIFIER_POOL = "pool:";
	public static final String IDENTIFIER_TSTLVARIABLE = "%";	

	public static final String IMPORT_ARRAY_LIST = "java.util.ArrayList";	
	public static final String IMPORT_LIST = "java.util.List";	

	public static final String MESSAGE_MALFORMED_POOL_DECLARATION = "Malformed pool declaration: ";
	public static final String MESSAGE_NO_TSTL = "Please provide a path to a valid .tstl file in the command line arguments.";
	public static final String MESSAGE_ONLY_ONE_EXPLICIT_GUARD = "Each action can only have one explicit guard.";	
	public static final String MESSAGE_UNDEFINED_TSTL_VARIABLE = "Tstl Variable undefined in pool. ";	
	public static final String MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS = "Variable identifiers must surround variables: ";

	public static final String PREFIX_JAVA_VARIABLES = "var_";

	public static final String SUFFIX_VAR_USED = "_used";

	public static final String TSTL_JAVA = "TSTL-Java";

	public static final String VISIBILITY_LEVEL_POOL_VAR = "private";

	public static final String IDENTIFIER_PROPERTY = "property:";

	private static void copyCode(CodeCopier cc) throws IOException 
	{
		cc.copyCode("FlushWriter.java");
		cc.copyCode("Action.java");
		cc.copyCode("SUTInterface.java");
		cc.copyCode("LabelFormatter.java");
		cc.copyCode("RandomTester.java");
		cc.copyCode("OutputWindow.java");
		cc.copyCode("TstlConstants.java");
		cc.copyCode("TestReducer.java");
	}
	public static String getAppDataDir()
	{
		String os = System.getProperty("os.name","generic").toLowerCase(Locale.ENGLISH);
		String home = System.getProperty("user.home");
		if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) {
			return home + "/Library/Application Support/"+ TSTL_JAVA +"/" ;
		} else if (os.indexOf("win") >= 0) {
			return home + "/AppData/Roaming/"+ TSTL_JAVA +"/" ;
		} else if (os.indexOf("nux") >= 0) {
			return home + "/."+ TSTL_JAVA +"/"  ;
		} else {
			return home + "/"+ TSTL_JAVA +"/"  ;
		}
	}
	public static String getParserOutputSourceDir()
	{
		File f = new File(getParserOutputSourceDirPath());
		f.mkdirs();

		return f.getAbsolutePath() + "/";
	}
	private static String getParserOutputSourceDirPath()
	{
		File parFile = null;
		try {
			parFile = getThisJarDir();
			return parFile.getAbsolutePath() + "/"+DIR_GENSRC+"/";
		} catch (URISyntaxException e)
		{

		}
		return "/output/";
	}
	public static File getThisJarDir() throws URISyntaxException
	{
		File f =  new File(TstlParser.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
		if(f == null)
			return new File("");
		return f;
	}
	public static void outputDependencies() 
	{
		CodeCopier cc = new CodeCopier();		
		try {
			copyCode(cc);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static File getGeneratedClassesFolder() 
	{
		String srcDir = TstlConstants.getParserOutputSourceDir();
		String compDir = new File(srcDir).getParentFile().getAbsolutePath() + "/"+TstlConstants.DIR_GENBIN;
		File compDirFile = new File(compDir);
		compDirFile.mkdirs();
		return compDirFile;
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
	public static Action getActionById(SUTInterface sut, int id)
	{
		Action action = sut.getActions()[id];
		if(action.id() == id)
			return action;
		for (int i = 0; i < sut.getActions().length; i++)
		{
			action = sut.getActions()[i];
			if(action.id() == i)
				return action;
		}
		return null;
	}


}