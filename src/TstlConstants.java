import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;


public class TstlConstants 
{
	public static final String CLASS_NAME_SUT = "SUT";

	public static final String COMMENT_AUTO_GEN_CODE = "//This is auto-generated code.  Changes will be overwritten.";	

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
			return parFile.getAbsolutePath() + "/gensrc/";
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void copyCode(CodeCopier cc) throws IOException 
	{
		cc.copyCode("FlushWriter.java");	
		cc.copyCode("Action.java");		
		cc.copyCode("SUTInterface.java");		
		cc.copyCode("LabelFormatter.java");		
		cc.copyCode("RandomTester.java");		
		cc.copyCode("OutputWindow.java");
	}
}