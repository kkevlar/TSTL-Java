//This is auto-generated code.  Changes will be overwritten.
import java.util.List;
import java.util.ArrayList;
public class SUT implements SUTInterface
{
private List<ArrayList<Integer>> var_ARRAYLIST;
private boolean[] var_ARRAYLIST_used;
private List<Integer> var_INT;
private boolean[] var_INT_used;
private Action[] actions;
@Override
public String check()
{
String fail = null;
if(!( var_INT.get(0) == null || var_INT.get(0) == 1))
fail =" var_INT.get(0) == null || var_INT.get(0) == 1";
if(!( var_INT.get(1) == null || var_INT.get(1) == 1))
fail =" var_INT.get(1) == null || var_INT.get(1) == 1";
if(!( var_INT.get(2) == null || var_INT.get(2) == 1))
fail =" var_INT.get(2) == null || var_INT.get(2) == 1";

return fail;
}

public SUT()
{
clearPool();
actionsInit();
}

public void clearPool() {
var_ARRAYLIST = new ArrayList<ArrayList<Integer>>();
for (int i = 0; i < 1; i++)
var_ARRAYLIST.add(null);
var_ARRAYLIST_used = new boolean[1];
var_INT = new ArrayList<Integer>();
for (int i = 0; i < 3; i++)
var_INT.add(null);
var_INT_used = new boolean[3];
}
private void actionsInit() {
actions = new Action[22];
Action action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(0,   1 )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
true;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(0,   1 );
var_INT_used[0] = false;

} //end act() 
@Override
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
@Override
public String name()
{
return "var_INT.set(1,   1 )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
true;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(1,   1 );
var_INT_used[1] = false;

} //end act() 
@Override
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
@Override
public String name()
{
return "var_INT.set(2,   1 )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
true;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(2,   1 );
var_INT_used[2] = false;

} //end act() 
@Override
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
@Override
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>() )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true);
return enabled;
} //end enabled()
@Override
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>() );
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_ARRAYLIST.set(0,   new ArrayList<Integer>() );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[3] = action;
action = new Action() {
@Override
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(0)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(0)) );
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[4] = action;
action = new Action() {
@Override
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(1)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(1)) );
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[5] = action;
action = new Action() {
@Override
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(2)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(2)) );
var_INT_used[2] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[6] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).add(var_INT.get(0)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).add(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).add(var_INT.get(0)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[7] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).add(var_INT.get(1)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).add(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).add(var_INT.get(1)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[8] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).add(var_INT.get(2)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).add(var_INT.get(2)) ;
var_INT_used[2] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).add(var_INT.get(2)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[9] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).remove(var_INT.get(0)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).remove(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).remove(var_INT.get(0)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[10] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).remove(var_INT.get(1)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).remove(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).remove(var_INT.get(1)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[11] = action;
action = new Action() {
@Override
public String name()
{
return " var_ARRAYLIST.get(0).remove(var_INT.get(2)) ";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = var_ARRAYLIST.get(0) != null &&
var_INT.get(2) != null;
return enabled;
} //end enabled()
@Override
public void act() 
{
 var_ARRAYLIST.get(0).remove(var_INT.get(2)) ;
var_INT_used[2] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name"," var_ARRAYLIST.get(0).remove(var_INT.get(2)) ;");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[12] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(0)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[0] = true;
var_INT_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[13] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(0)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[0] = true;
var_INT_used[1] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[14] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(0)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[0] = true;
var_INT_used[2] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
return formatter.getAllFormatted();
}
};
actions[15] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(1)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[1] = true;
var_INT_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[16] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(1)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[1] = true;
var_INT_used[1] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[17] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(1)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[1] = true;
var_INT_used[2] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
return formatter.getAllFormatted();
}
};
actions[18] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(2)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(2) != null
&& (var_INT.get(2) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[2] = true;
var_INT_used[0] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(0)",var_INT.get(0)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[19] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(2)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(2) != null
&& (var_INT.get(2) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[2] = true;
var_INT_used[1] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(1)",var_INT.get(1)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[20] = action;
action = new Action() {
@Override
public String name()
{
return "var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(2)) )";
} //end name()
@Override
public boolean enabled()
{
boolean enabled = (var_INT.get(2) == null ||var_INT_used[2]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(2) != null
&& (var_INT.get(2) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
@Override
public void act() 
{
var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[2] = true;
var_INT_used[2] = false;

} //end act() 
@Override
public String getAllInfo()
{

LabelFormatter formatter = new LabelFormatter();
formatter.addToStorage("MainLine/Name","var_INT.set(2,   var_ARRAYLIST.get(0).get(var_INT.get(2)) );");
formatter.addToStorage("enabled()",enabled()+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
formatter.addToStorage("var_ARRAYLIST.get(0)",var_ARRAYLIST.get(0)+"");
formatter.addToStorage("var_INT.get(2)",var_INT.get(2)+"");
return formatter.getAllFormatted();
}
};
actions[21] = action;
}//close actionInit()
@Override
public Action[] getActions()
{
return actions;
}//close reset()
@Override
public void reset()
{
clearPool();
}//close reset()
}//class close brace
