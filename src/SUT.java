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
actions = new Action[98];
Action action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   1 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   1 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   1 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("1",1+"");
return formatter.getAllFormatted();
}
};
actions[0] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   1 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   1 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   1 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("1",1+"");
return formatter.getAllFormatted();
}
};
actions[1] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   1 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   1 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   1 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("1",1+"");
return formatter.getAllFormatted();
}
};
actions[2] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   2 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   2 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   2 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("2",2+"");
return formatter.getAllFormatted();
}
};
actions[3] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   2 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   2 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   2 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("2",2+"");
return formatter.getAllFormatted();
}
};
actions[4] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   2 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   2 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   2 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("2",2+"");
return formatter.getAllFormatted();
}
};
actions[5] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   3 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   3 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   3 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("3",3+"");
return formatter.getAllFormatted();
}
};
actions[6] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   3 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   3 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   3 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("3",3+"");
return formatter.getAllFormatted();
}
};
actions[7] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   3 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   3 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   3 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("3",3+"");
return formatter.getAllFormatted();
}
};
actions[8] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   4 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   4 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   4 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("4",4+"");
return formatter.getAllFormatted();
}
};
actions[9] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   4 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   4 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   4 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("4",4+"");
return formatter.getAllFormatted();
}
};
actions[10] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   4 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   4 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   4 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("4",4+"");
return formatter.getAllFormatted();
}
};
actions[11] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   5 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   5 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   5 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("5",5+"");
return formatter.getAllFormatted();
}
};
actions[12] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   5 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   5 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   5 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("5",5+"");
return formatter.getAllFormatted();
}
};
actions[13] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   5 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   5 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   5 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("5",5+"");
return formatter.getAllFormatted();
}
};
actions[14] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   6 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   6 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   6 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("6",6+"");
return formatter.getAllFormatted();
}
};
actions[15] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   6 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   6 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   6 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("6",6+"");
return formatter.getAllFormatted();
}
};
actions[16] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   6 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   6 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   6 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("6",6+"");
return formatter.getAllFormatted();
}
};
actions[17] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   7 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   7 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   7 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("7",7+"");
return formatter.getAllFormatted();
}
};
actions[18] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   7 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   7 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   7 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("7",7+"");
return formatter.getAllFormatted();
}
};
actions[19] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   7 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   7 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   7 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("7",7+"");
return formatter.getAllFormatted();
}
};
actions[20] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   8 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   8 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   8 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("8",8+"");
return formatter.getAllFormatted();
}
};
actions[21] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   8 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   8 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   8 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("8",8+"");
return formatter.getAllFormatted();
}
};
actions[22] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   8 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   8 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   8 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("8",8+"");
return formatter.getAllFormatted();
}
};
actions[23] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   9 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   9 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   9 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("9",9+"");
return formatter.getAllFormatted();
}
};
actions[24] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   9 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   9 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   9 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("9",9+"");
return formatter.getAllFormatted();
}
};
actions[25] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   9 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   9 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   9 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("9",9+"");
return formatter.getAllFormatted();
}
};
actions[26] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   10 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   10 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   10 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("10",10+"");
return formatter.getAllFormatted();
}
};
actions[27] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   10 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   10 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   10 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("10",10+"");
return formatter.getAllFormatted();
}
};
actions[28] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   10 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   10 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   10 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("10",10+"");
return formatter.getAllFormatted();
}
};
actions[29] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   11 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   11 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   11 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("11",11+"");
return formatter.getAllFormatted();
}
};
actions[30] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   11 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   11 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   11 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("11",11+"");
return formatter.getAllFormatted();
}
};
actions[31] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   11 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   11 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   11 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("11",11+"");
return formatter.getAllFormatted();
}
};
actions[32] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   12 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   12 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   12 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("12",12+"");
return formatter.getAllFormatted();
}
};
actions[33] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   12 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   12 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   12 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("12",12+"");
return formatter.getAllFormatted();
}
};
actions[34] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   12 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   12 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   12 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("12",12+"");
return formatter.getAllFormatted();
}
};
actions[35] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   13 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   13 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   13 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("13",13+"");
return formatter.getAllFormatted();
}
};
actions[36] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   13 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   13 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   13 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("13",13+"");
return formatter.getAllFormatted();
}
};
actions[37] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   13 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   13 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   13 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("13",13+"");
return formatter.getAllFormatted();
}
};
actions[38] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   14 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   14 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   14 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("14",14+"");
return formatter.getAllFormatted();
}
};
actions[39] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   14 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   14 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   14 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("14",14+"");
return formatter.getAllFormatted();
}
};
actions[40] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   14 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   14 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   14 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("14",14+"");
return formatter.getAllFormatted();
}
};
actions[41] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   15 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   15 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   15 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("15",15+"");
return formatter.getAllFormatted();
}
};
actions[42] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   15 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   15 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   15 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("15",15+"");
return formatter.getAllFormatted();
}
};
actions[43] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   15 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   15 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   15 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("15",15+"");
return formatter.getAllFormatted();
}
};
actions[44] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   16 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   16 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   16 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("16",16+"");
return formatter.getAllFormatted();
}
};
actions[45] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   16 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   16 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   16 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("16",16+"");
return formatter.getAllFormatted();
}
};
actions[46] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   16 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   16 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   16 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("16",16+"");
return formatter.getAllFormatted();
}
};
actions[47] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   17 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   17 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   17 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("17",17+"");
return formatter.getAllFormatted();
}
};
actions[48] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   17 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   17 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   17 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("17",17+"");
return formatter.getAllFormatted();
}
};
actions[49] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   17 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   17 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   17 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("17",17+"");
return formatter.getAllFormatted();
}
};
actions[50] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   18 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   18 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   18 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("18",18+"");
return formatter.getAllFormatted();
}
};
actions[51] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   18 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   18 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   18 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("18",18+"");
return formatter.getAllFormatted();
}
};
actions[52] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   18 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   18 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   18 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("18",18+"");
return formatter.getAllFormatted();
}
};
actions[53] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   19 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   19 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   19 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("19",19+"");
return formatter.getAllFormatted();
}
};
actions[54] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   19 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   19 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   19 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("19",19+"");
return formatter.getAllFormatted();
}
};
actions[55] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   19 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   19 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   19 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("19",19+"");
return formatter.getAllFormatted();
}
};
actions[56] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   20 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   20 );
var_INT_used[0] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   20 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("20",20+"");
return formatter.getAllFormatted();
}
};
actions[57] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   20 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   20 );
var_INT_used[1] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   20 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("20",20+"");
return formatter.getAllFormatted();
}
};
actions[58] = action;
action = new Action() {
public String name()
{
return "var_INT.set(2,   20 )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(2,   20 );
var_INT_used[2] = false;

} //end act() 
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   20 );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("20",20+"");
return formatter.getAllFormatted();
}
};
actions[59] = action;
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
actions[60] = action;
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
actions[61] = action;
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
actions[62] = action;
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
actions[63] = action;
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
actions[64] = action;
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
actions[65] = action;
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
actions[66] = action;
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
actions[67] = action;
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
actions[68] = action;
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
actions[69] = action;
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
actions[70] = action;
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
actions[71] = action;
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
actions[72] = action;
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
actions[73] = action;
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
actions[74] = action;
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
actions[75] = action;
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
actions[76] = action;
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
actions[77] = action;
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
actions[78] = action;
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
actions[79] = action;
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
actions[80] = action;
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
actions[81] = action;
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
actions[82] = action;
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
actions[83] = action;
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
actions[84] = action;
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
actions[85] = action;
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
actions[86] = action;
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
actions[87] = action;
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
actions[88] = action;
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
actions[89] = action;
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
actions[90] = action;
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
actions[91] = action;
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
actions[92] = action;
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
actions[93] = action;
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
actions[94] = action;
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
actions[95] = action;
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
actions[96] = action;
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
actions[97] = action;
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
