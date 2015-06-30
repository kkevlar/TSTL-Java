//This is auto-generated code.  Changes will be overwritten.
import  java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class SUT implements SUTInterface
{
private List<HashMap<Integer,String>> var_HMAP;
private boolean[] var_HMAP_used;
private List<Integer> var_INT;
private boolean[] var_INT_used;
private List<String> var_STRING;
private boolean[] var_STRING_used;
private List<Character> var_CHAR;
private boolean[] var_CHAR_used;
private Action[] actions;
public String check()
{
String fail = null;
if(!( var_INT.get(0) == null || var_INT.get(0) >= 0))
fail =" var_INT.get(0) == null || var_INT.get(0) >= 0";
if(!( var_INT.get(1) == null || var_INT.get(1) >= 0))
fail =" var_INT.get(1) == null || var_INT.get(1) >= 0";
if(!( var_INT.get(2) == null || var_INT.get(2) >= 0))
fail =" var_INT.get(2) == null || var_INT.get(2) >= 0";

return fail;
}

public SUT()
{
clearPool();
actionsInit();
}

public void clearPool() {
var_HMAP = new ArrayList<HashMap<Integer,String>>();
for (int i = 0; i < 1; i++)
var_HMAP.add(null);
var_HMAP_used = new boolean[1];
var_INT = new ArrayList<Integer>();
for (int i = 0; i < 3; i++)
var_INT.add(null);
var_INT_used = new boolean[3];
var_STRING = new ArrayList<String>();
for (int i = 0; i < 3; i++)
var_STRING.add(null);
var_STRING_used = new boolean[3];
var_CHAR = new ArrayList<Character>();
for (int i = 0; i < 3; i++)
var_CHAR.add(null);
var_CHAR_used = new boolean[3];
}
private void actionsInit() {
actions = new Action[167];
Action action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   48 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   48 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   48 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("48",48+"");
return formatter.getAllFormatted();
}
};
actions[0] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   48 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   48 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   48 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("48",48+"");
return formatter.getAllFormatted();
}
};
actions[1] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   48 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   48 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   48 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("48",48+"");
return formatter.getAllFormatted();
}
};
actions[2] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   49 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   49 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   49 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("49",49+"");
return formatter.getAllFormatted();
}
};
actions[3] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   49 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   49 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   49 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("49",49+"");
return formatter.getAllFormatted();
}
};
actions[4] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   49 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   49 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   49 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("49",49+"");
return formatter.getAllFormatted();
}
};
actions[5] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   50 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   50 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   50 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("50",50+"");
return formatter.getAllFormatted();
}
};
actions[6] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   50 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   50 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   50 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("50",50+"");
return formatter.getAllFormatted();
}
};
actions[7] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   50 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   50 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   50 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("50",50+"");
return formatter.getAllFormatted();
}
};
actions[8] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   51 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   51 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   51 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("51",51+"");
return formatter.getAllFormatted();
}
};
actions[9] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   51 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   51 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   51 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("51",51+"");
return formatter.getAllFormatted();
}
};
actions[10] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   51 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   51 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   51 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("51",51+"");
return formatter.getAllFormatted();
}
};
actions[11] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   52 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   52 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   52 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("52",52+"");
return formatter.getAllFormatted();
}
};
actions[12] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   52 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   52 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   52 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("52",52+"");
return formatter.getAllFormatted();
}
};
actions[13] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   52 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   52 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   52 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("52",52+"");
return formatter.getAllFormatted();
}
};
actions[14] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   53 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   53 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   53 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("53",53+"");
return formatter.getAllFormatted();
}
};
actions[15] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   53 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   53 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   53 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("53",53+"");
return formatter.getAllFormatted();
}
};
actions[16] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   53 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   53 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   53 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("53",53+"");
return formatter.getAllFormatted();
}
};
actions[17] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   54 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   54 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   54 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("54",54+"");
return formatter.getAllFormatted();
}
};
actions[18] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   54 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   54 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   54 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("54",54+"");
return formatter.getAllFormatted();
}
};
actions[19] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   54 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   54 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   54 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("54",54+"");
return formatter.getAllFormatted();
}
};
actions[20] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   55 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   55 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   55 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("55",55+"");
return formatter.getAllFormatted();
}
};
actions[21] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   55 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   55 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   55 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("55",55+"");
return formatter.getAllFormatted();
}
};
actions[22] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   55 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   55 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   55 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("55",55+"");
return formatter.getAllFormatted();
}
};
actions[23] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   56 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   56 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   56 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("56",56+"");
return formatter.getAllFormatted();
}
};
actions[24] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   56 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   56 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   56 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("56",56+"");
return formatter.getAllFormatted();
}
};
actions[25] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   56 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   56 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   56 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("56",56+"");
return formatter.getAllFormatted();
}
};
actions[26] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   57 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   57 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   57 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("57",57+"");
return formatter.getAllFormatted();
}
};
actions[27] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   57 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   57 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   57 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("57",57+"");
return formatter.getAllFormatted();
}
};
actions[28] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   57 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   57 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   57 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("57",57+"");
return formatter.getAllFormatted();
}
};
actions[29] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   58 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   58 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   58 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("58",58+"");
return formatter.getAllFormatted();
}
};
actions[30] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   58 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   58 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   58 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("58",58+"");
return formatter.getAllFormatted();
}
};
actions[31] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   58 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   58 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   58 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("58",58+"");
return formatter.getAllFormatted();
}
};
actions[32] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   59 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   59 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   59 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("59",59+"");
return formatter.getAllFormatted();
}
};
actions[33] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   59 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   59 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   59 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("59",59+"");
return formatter.getAllFormatted();
}
};
actions[34] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   59 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   59 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   59 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("59",59+"");
return formatter.getAllFormatted();
}
};
actions[35] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   60 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   60 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   60 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("60",60+"");
return formatter.getAllFormatted();
}
};
actions[36] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   60 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   60 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   60 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("60",60+"");
return formatter.getAllFormatted();
}
};
actions[37] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   60 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   60 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   60 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("60",60+"");
return formatter.getAllFormatted();
}
};
actions[38] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   61 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   61 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   61 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("61",61+"");
return formatter.getAllFormatted();
}
};
actions[39] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   61 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   61 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   61 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("61",61+"");
return formatter.getAllFormatted();
}
};
actions[40] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   61 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   61 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   61 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("61",61+"");
return formatter.getAllFormatted();
}
};
actions[41] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   62 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   62 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   62 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("62",62+"");
return formatter.getAllFormatted();
}
};
actions[42] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   62 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   62 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   62 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("62",62+"");
return formatter.getAllFormatted();
}
};
actions[43] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   62 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   62 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   62 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("62",62+"");
return formatter.getAllFormatted();
}
};
actions[44] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   63 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   63 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   63 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("63",63+"");
return formatter.getAllFormatted();
}
};
actions[45] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   63 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   63 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   63 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("63",63+"");
return formatter.getAllFormatted();
}
};
actions[46] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   63 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   63 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   63 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("63",63+"");
return formatter.getAllFormatted();
}
};
actions[47] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   64 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   64 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   64 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("64",64+"");
return formatter.getAllFormatted();
}
};
actions[48] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   64 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   64 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   64 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("64",64+"");
return formatter.getAllFormatted();
}
};
actions[49] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   64 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   64 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   64 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("64",64+"");
return formatter.getAllFormatted();
}
};
actions[50] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   65 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   65 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   65 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("65",65+"");
return formatter.getAllFormatted();
}
};
actions[51] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   65 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   65 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   65 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("65",65+"");
return formatter.getAllFormatted();
}
};
actions[52] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   65 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   65 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   65 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("65",65+"");
return formatter.getAllFormatted();
}
};
actions[53] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   66 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   66 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   66 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("66",66+"");
return formatter.getAllFormatted();
}
};
actions[54] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   66 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   66 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   66 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("66",66+"");
return formatter.getAllFormatted();
}
};
actions[55] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   66 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   66 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   66 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("66",66+"");
return formatter.getAllFormatted();
}
};
actions[56] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   67 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   67 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   67 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("67",67+"");
return formatter.getAllFormatted();
}
};
actions[57] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   67 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   67 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   67 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("67",67+"");
return formatter.getAllFormatted();
}
};
actions[58] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   67 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   67 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   67 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("67",67+"");
return formatter.getAllFormatted();
}
};
actions[59] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   68 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   68 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   68 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("68",68+"");
return formatter.getAllFormatted();
}
};
actions[60] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   68 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   68 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   68 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("68",68+"");
return formatter.getAllFormatted();
}
};
actions[61] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   68 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   68 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   68 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("68",68+"");
return formatter.getAllFormatted();
}
};
actions[62] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   69 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   69 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   69 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("69",69+"");
return formatter.getAllFormatted();
}
};
actions[63] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   69 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   69 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   69 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("69",69+"");
return formatter.getAllFormatted();
}
};
actions[64] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   69 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   69 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   69 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("69",69+"");
return formatter.getAllFormatted();
}
};
actions[65] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   70 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   70 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   70 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("70",70+"");
return formatter.getAllFormatted();
}
};
actions[66] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   70 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   70 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   70 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("70",70+"");
return formatter.getAllFormatted();
}
};
actions[67] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   70 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   70 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   70 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("70",70+"");
return formatter.getAllFormatted();
}
};
actions[68] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   71 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   71 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   71 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("71",71+"");
return formatter.getAllFormatted();
}
};
actions[69] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   71 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   71 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   71 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("71",71+"");
return formatter.getAllFormatted();
}
};
actions[70] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   71 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   71 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   71 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("71",71+"");
return formatter.getAllFormatted();
}
};
actions[71] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   72 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   72 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   72 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("72",72+"");
return formatter.getAllFormatted();
}
};
actions[72] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   72 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   72 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   72 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("72",72+"");
return formatter.getAllFormatted();
}
};
actions[73] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   72 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   72 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   72 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("72",72+"");
return formatter.getAllFormatted();
}
};
actions[74] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   73 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   73 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   73 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("73",73+"");
return formatter.getAllFormatted();
}
};
actions[75] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   73 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   73 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   73 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("73",73+"");
return formatter.getAllFormatted();
}
};
actions[76] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   73 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   73 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   73 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("73",73+"");
return formatter.getAllFormatted();
}
};
actions[77] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   74 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   74 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   74 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("74",74+"");
return formatter.getAllFormatted();
}
};
actions[78] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   74 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   74 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   74 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("74",74+"");
return formatter.getAllFormatted();
}
};
actions[79] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   74 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   74 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   74 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("74",74+"");
return formatter.getAllFormatted();
}
};
actions[80] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   75 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   75 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   75 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("75",75+"");
return formatter.getAllFormatted();
}
};
actions[81] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   75 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   75 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   75 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("75",75+"");
return formatter.getAllFormatted();
}
};
actions[82] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   75 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   75 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   75 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("75",75+"");
return formatter.getAllFormatted();
}
};
actions[83] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   76 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   76 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   76 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("76",76+"");
return formatter.getAllFormatted();
}
};
actions[84] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   76 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   76 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   76 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("76",76+"");
return formatter.getAllFormatted();
}
};
actions[85] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   76 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   76 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   76 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("76",76+"");
return formatter.getAllFormatted();
}
};
actions[86] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   77 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   77 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   77 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("77",77+"");
return formatter.getAllFormatted();
}
};
actions[87] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   77 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   77 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   77 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("77",77+"");
return formatter.getAllFormatted();
}
};
actions[88] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   77 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   77 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   77 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("77",77+"");
return formatter.getAllFormatted();
}
};
actions[89] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   78 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   78 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   78 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("78",78+"");
return formatter.getAllFormatted();
}
};
actions[90] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   78 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   78 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   78 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("78",78+"");
return formatter.getAllFormatted();
}
};
actions[91] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   78 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   78 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   78 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("78",78+"");
return formatter.getAllFormatted();
}
};
actions[92] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   79 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   79 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   79 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("79",79+"");
return formatter.getAllFormatted();
}
};
actions[93] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   79 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   79 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   79 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("79",79+"");
return formatter.getAllFormatted();
}
};
actions[94] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   79 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   79 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   79 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("79",79+"");
return formatter.getAllFormatted();
}
};
actions[95] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   80 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   80 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   80 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("80",80+"");
return formatter.getAllFormatted();
}
};
actions[96] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   80 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   80 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   80 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("80",80+"");
return formatter.getAllFormatted();
}
};
actions[97] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   80 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   80 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   80 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("80",80+"");
return formatter.getAllFormatted();
}
};
actions[98] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   81 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   81 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   81 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("81",81+"");
return formatter.getAllFormatted();
}
};
actions[99] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   81 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   81 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   81 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("81",81+"");
return formatter.getAllFormatted();
}
};
actions[100] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   81 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   81 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   81 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("81",81+"");
return formatter.getAllFormatted();
}
};
actions[101] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   82 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   82 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   82 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("82",82+"");
return formatter.getAllFormatted();
}
};
actions[102] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   82 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   82 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   82 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("82",82+"");
return formatter.getAllFormatted();
}
};
actions[103] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   82 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   82 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   82 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("82",82+"");
return formatter.getAllFormatted();
}
};
actions[104] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   83 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   83 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   83 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("83",83+"");
return formatter.getAllFormatted();
}
};
actions[105] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   83 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   83 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   83 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("83",83+"");
return formatter.getAllFormatted();
}
};
actions[106] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   83 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   83 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   83 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("83",83+"");
return formatter.getAllFormatted();
}
};
actions[107] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   84 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   84 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   84 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("84",84+"");
return formatter.getAllFormatted();
}
};
actions[108] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   84 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   84 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   84 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("84",84+"");
return formatter.getAllFormatted();
}
};
actions[109] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   84 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   84 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   84 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("84",84+"");
return formatter.getAllFormatted();
}
};
actions[110] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   85 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   85 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   85 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("85",85+"");
return formatter.getAllFormatted();
}
};
actions[111] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   85 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   85 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   85 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("85",85+"");
return formatter.getAllFormatted();
}
};
actions[112] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   85 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   85 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   85 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("85",85+"");
return formatter.getAllFormatted();
}
};
actions[113] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   86 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   86 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   86 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("86",86+"");
return formatter.getAllFormatted();
}
};
actions[114] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   86 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   86 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   86 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("86",86+"");
return formatter.getAllFormatted();
}
};
actions[115] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   86 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   86 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   86 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("86",86+"");
return formatter.getAllFormatted();
}
};
actions[116] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   87 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   87 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   87 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("87",87+"");
return formatter.getAllFormatted();
}
};
actions[117] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   87 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   87 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   87 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("87",87+"");
return formatter.getAllFormatted();
}
};
actions[118] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   87 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   87 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   87 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("87",87+"");
return formatter.getAllFormatted();
}
};
actions[119] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   88 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   88 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   88 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("88",88+"");
return formatter.getAllFormatted();
}
};
actions[120] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   88 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   88 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   88 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("88",88+"");
return formatter.getAllFormatted();
}
};
actions[121] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   88 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   88 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   88 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("88",88+"");
return formatter.getAllFormatted();
}
};
actions[122] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   89 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   89 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   89 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("89",89+"");
return formatter.getAllFormatted();
}
};
actions[123] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   89 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   89 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   89 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("89",89+"");
return formatter.getAllFormatted();
}
};
actions[124] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   89 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   89 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   89 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("89",89+"");
return formatter.getAllFormatted();
}
};
actions[125] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   90 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   90 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   90 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("90",90+"");
return formatter.getAllFormatted();
}
};
actions[126] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   90 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   90 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   90 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("90",90+"");
return formatter.getAllFormatted();
}
};
actions[127] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   90 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   90 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   90 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("90",90+"");
return formatter.getAllFormatted();
}
};
actions[128] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(0,   (char) var_INT.get(0).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(0) == null ||var_CHAR_used[0]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(0,   (char) var_INT.get(0).intValue() );
var_INT_used[0] = true;
var_CHAR_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(0,   (char) var_INT.get(0).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[129] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(1,   (char) var_INT.get(0).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(1) == null ||var_CHAR_used[1]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(1,   (char) var_INT.get(0).intValue() );
var_INT_used[0] = true;
var_CHAR_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(1,   (char) var_INT.get(0).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[130] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(2,   (char) var_INT.get(0).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(2) == null ||var_CHAR_used[2]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(2,   (char) var_INT.get(0).intValue() );
var_INT_used[0] = true;
var_CHAR_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(2,   (char) var_INT.get(0).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[131] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(0,   (char) var_INT.get(1).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(0) == null ||var_CHAR_used[0]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(0,   (char) var_INT.get(1).intValue() );
var_INT_used[1] = true;
var_CHAR_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(0,   (char) var_INT.get(1).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[132] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(1,   (char) var_INT.get(1).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(1) == null ||var_CHAR_used[1]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(1,   (char) var_INT.get(1).intValue() );
var_INT_used[1] = true;
var_CHAR_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(1,   (char) var_INT.get(1).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[133] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(2,   (char) var_INT.get(1).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(2) == null ||var_CHAR_used[2]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(2,   (char) var_INT.get(1).intValue() );
var_INT_used[1] = true;
var_CHAR_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(2,   (char) var_INT.get(1).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[134] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(0,   (char) var_INT.get(2).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(0) == null ||var_CHAR_used[0]== true) &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(0,   (char) var_INT.get(2).intValue() );
var_INT_used[2] = true;
var_CHAR_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(0,   (char) var_INT.get(2).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[135] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(1,   (char) var_INT.get(2).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(1) == null ||var_CHAR_used[1]== true) &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(1,   (char) var_INT.get(2).intValue() );
var_INT_used[2] = true;
var_CHAR_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(1,   (char) var_INT.get(2).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[136] = action;
action = new Action() {
public String name()
{
return "var_CHAR.set(2,   (char) var_INT.get(2).intValue() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_CHAR.get(2) == null ||var_CHAR_used[2]== true) &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_CHAR.set(2,   (char) var_INT.get(2).intValue() );
var_INT_used[2] = true;
var_CHAR_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_CHAR.set(2,   (char) var_INT.get(2).intValue() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[137] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   (var_CHAR.get(0)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_CHAR.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   (var_CHAR.get(0)).toString() );
var_CHAR_used[0] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   (var_CHAR.get(0)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[138] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   (var_CHAR.get(0)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_CHAR.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   (var_CHAR.get(0)).toString() );
var_CHAR_used[0] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   (var_CHAR.get(0)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[139] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   (var_CHAR.get(0)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_CHAR.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   (var_CHAR.get(0)).toString() );
var_CHAR_used[0] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   (var_CHAR.get(0)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_CHAR.get(0)",var_CHAR.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[140] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   (var_CHAR.get(1)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_CHAR.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   (var_CHAR.get(1)).toString() );
var_CHAR_used[1] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   (var_CHAR.get(1)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[141] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   (var_CHAR.get(1)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_CHAR.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   (var_CHAR.get(1)).toString() );
var_CHAR_used[1] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   (var_CHAR.get(1)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[142] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   (var_CHAR.get(1)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_CHAR.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   (var_CHAR.get(1)).toString() );
var_CHAR_used[1] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   (var_CHAR.get(1)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_CHAR.get(1)",var_CHAR.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[143] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   (var_CHAR.get(2)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_CHAR.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   (var_CHAR.get(2)).toString() );
var_CHAR_used[2] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   (var_CHAR.get(2)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[144] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   (var_CHAR.get(2)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_CHAR.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   (var_CHAR.get(2)).toString() );
var_CHAR_used[2] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   (var_CHAR.get(2)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[145] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   (var_CHAR.get(2)).toString() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_CHAR.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   (var_CHAR.get(2)).toString() );
var_CHAR_used[2] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   (var_CHAR.get(2)).toString() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_CHAR.get(2)",var_CHAR.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[146] = action;
action = new Action() {
public String name()
{
return "var_HMAP.set(0,   new HashMap<Integer,String>() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_HMAP.get(0) == null ||var_HMAP_used[0]== true);
return enabled;
} //end enabled()
public void act() 
{
var_HMAP.set(0,   new HashMap<Integer,String>() );
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_HMAP.set(0,   new HashMap<Integer,String>() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[147] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(0) != null &&
var_STRING.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(0)) ;
var_INT_used[0] = true;
var_STRING_used[0] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(0)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[148] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(1) != null &&
var_STRING.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(0)) ;
var_INT_used[1] = true;
var_STRING_used[0] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(0)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[149] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(2) != null &&
var_STRING.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(0)) ;
var_INT_used[2] = true;
var_STRING_used[0] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(0)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[150] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(0) != null &&
var_STRING.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(1)) ;
var_INT_used[0] = true;
var_STRING_used[1] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(1)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[151] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(1) != null &&
var_STRING.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(1)) ;
var_INT_used[1] = true;
var_STRING_used[1] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(1)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[152] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(2) != null &&
var_STRING.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(1)) ;
var_INT_used[2] = true;
var_STRING_used[1] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(1)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[153] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(2)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(0) != null &&
var_STRING.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(2)) ;
var_INT_used[0] = true;
var_STRING_used[2] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(0),var_STRING.get(2)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[154] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(2)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(1) != null &&
var_STRING.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(2)) ;
var_INT_used[1] = true;
var_STRING_used[2] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(1),var_STRING.get(2)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[155] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(2)) ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null &&
var_INT.get(2) != null &&
var_STRING.get(2) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(2)) ;
var_INT_used[2] = true;
var_STRING_used[2] = true;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).put(var_INT.get(2),var_STRING.get(2)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[156] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(0) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(0)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(0)) );
var_HMAP_used[0] = true;
var_INT_used[0] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[157] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(0) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(0)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(0)) );
var_HMAP_used[0] = true;
var_INT_used[0] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[158] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(0) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(0)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(0)) );
var_HMAP_used[0] = true;
var_INT_used[0] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[159] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(1) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(1)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(1)) );
var_HMAP_used[0] = true;
var_INT_used[1] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[160] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(1) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(1)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(1)) );
var_HMAP_used[0] = true;
var_INT_used[1] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[161] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(1) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(1)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(1)) );
var_HMAP_used[0] = true;
var_INT_used[1] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[162] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(2)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(0) == null ||var_STRING_used[0]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(2) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(2)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(2)) );
var_HMAP_used[0] = true;
var_INT_used[2] = true;
var_STRING_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(0,   var_HMAP.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(0)",var_STRING.get(0)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[163] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(2)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(1) == null ||var_STRING_used[1]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(2) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(2)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(2)) );
var_HMAP_used[0] = true;
var_INT_used[2] = true;
var_STRING_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(1,   var_HMAP.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(1)",var_STRING.get(1)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[164] = action;
action = new Action() {
public String name()
{
return "var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(2)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_STRING.get(2) == null ||var_STRING_used[2]== true) &&
var_HMAP.get(0) != null &&
var_INT.get(2) != null
&& (var_HMAP.get(0).containsKey(var_INT.get(2)) );
return enabled;
} //end enabled()
public void act() 
{
var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(2)) );
var_HMAP_used[0] = true;
var_INT_used[2] = true;
var_STRING_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_STRING.set(2,   var_HMAP.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_STRING.get(2)",var_STRING.get(2)+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[165] = action;
action = new Action() {
public String name()
{
return " var_HMAP.get(0).clear() ";
} //end name()
public boolean enabled()
{
boolean enabled = var_HMAP.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_HMAP.get(0).clear() ;
var_HMAP_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_HMAP.get(0).clear() ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_HMAP.get(0)",var_HMAP.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[166] = action;
}//close actionInit()
public Action[] getActions()
{
return actions;
}//close reset()
public void reset()
{
clearPool();
}//close reset()
}//class close brace
