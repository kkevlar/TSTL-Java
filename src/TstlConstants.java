
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
	
	public static final String VISIBILITY_LEVEL_POOL_VAR = "private";	
}
