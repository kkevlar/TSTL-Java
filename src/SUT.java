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
public SUT()
{
clearPool();
actionsInit();
}

public void clearPool() {
var_ARRAYLIST = new ArrayList<ArrayList<Integer>>();
for (int i = 0; i < 2; i++)
var_ARRAYLIST.add(null);
var_ARRAYLIST_used = new boolean[2];
var_INT = new ArrayList<Integer>();
for (int i = 0; i < 2; i++)
var_INT.add(null);
var_INT_used = new boolean[2];
}
private void actionsInit() {
actions = new Action[32];
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
};
actions[1] = action;
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
};
actions[2] = action;
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
};
actions[3] = action;
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
};
actions[4] = action;
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
};
actions[5] = action;
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
};
actions[6] = action;
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
};
actions[7] = action;
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
};
actions[8] = action;
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
};
actions[9] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true);
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>() );
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[10] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(1,   new ArrayList<Integer>() )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true);
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(1,   new ArrayList<Integer>() );
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[11] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(0)) );
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[12] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(1,   new ArrayList<Integer>(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(1,   new ArrayList<Integer>(var_INT.get(0)) );
var_INT_used[0] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[13] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(0,   new ArrayList<Integer>(var_INT.get(1)) );
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[14] = action;
action = new Action() {
public String name()
{
return "var_ARRAYLIST.set(1,   new ArrayList<Integer>(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
var_ARRAYLIST.set(1,   new ArrayList<Integer>(var_INT.get(1)) );
var_INT_used[1] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[15] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(0).add(var_INT.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(0).add(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[16] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(1).add(var_INT.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(1).add(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[17] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(0).add(var_INT.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(0).add(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[18] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(1).add(var_INT.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(1).add(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[19] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(0).remove(var_INT.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(0).remove(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[20] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(1).remove(var_INT.get(0)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(0) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(1).remove(var_INT.get(0)) ;
var_INT_used[0] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[21] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(0).remove(var_INT.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(0) == null ||var_ARRAYLIST_used[0]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(0).remove(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[0] = false;

} //end act() 
};
actions[22] = action;
action = new Action() {
public String name()
{
return " var_ARRAYLIST.get(1).remove(var_INT.get(1)) ";
} //end name()
public boolean enabled()
{
boolean enabled = (var_ARRAYLIST.get(1) == null ||var_ARRAYLIST_used[1]== true) &&
var_INT.get(1) != null;
return enabled;
} //end enabled()
public void act() 
{
 var_ARRAYLIST.get(1).remove(var_INT.get(1)) ;
var_INT_used[1] = true;
var_ARRAYLIST_used[1] = false;

} //end act() 
};
actions[23] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[0] = true;
var_INT_used[0] = false;

} //end act() 
};
actions[24] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(0)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[0] = true;
var_INT_used[1] = false;

} //end act() 
};
actions[25] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(1).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(1) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(1).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(1).get(var_INT.get(0)) );
var_ARRAYLIST_used[1] = true;
var_INT_used[0] = true;
var_INT_used[0] = false;

} //end act() 
};
actions[26] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(1).get(var_INT.get(0)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(1) != null &&
var_INT.get(0) != null
&& (var_INT.get(0) < var_ARRAYLIST.get(1).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(1).get(var_INT.get(0)) );
var_ARRAYLIST_used[1] = true;
var_INT_used[0] = true;
var_INT_used[1] = false;

} //end act() 
};
actions[27] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[1] = true;
var_INT_used[0] = false;

} //end act() 
};
actions[28] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(0) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(0).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(0).get(var_INT.get(1)) );
var_ARRAYLIST_used[0] = true;
var_INT_used[1] = true;
var_INT_used[1] = false;

} //end act() 
};
actions[29] = action;
action = new Action() {
public String name()
{
return "var_INT.set(0,   var_ARRAYLIST.get(1).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(0) == null ||var_INT_used[0]== true) &&
var_ARRAYLIST.get(1) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(1).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(0,   var_ARRAYLIST.get(1).get(var_INT.get(1)) );
var_ARRAYLIST_used[1] = true;
var_INT_used[1] = true;
var_INT_used[0] = false;

} //end act() 
};
actions[30] = action;
action = new Action() {
public String name()
{
return "var_INT.set(1,   var_ARRAYLIST.get(1).get(var_INT.get(1)) )";
} //end name()
public boolean enabled()
{
boolean enabled = (var_INT.get(1) == null ||var_INT_used[1]== true) &&
var_ARRAYLIST.get(1) != null &&
var_INT.get(1) != null
&& (var_INT.get(1) < var_ARRAYLIST.get(1).size() );
return enabled;
} //end enabled()
public void act() 
{
var_INT.set(1,   var_ARRAYLIST.get(1).get(var_INT.get(1)) );
var_ARRAYLIST_used[1] = true;
var_INT_used[1] = true;
var_INT_used[1] = false;

} //end act() 
};
actions[31] = action;
}//close actionInit()
public Action[] getActions()
{
return actions;
}//close reset()
public void reset()
{
clearPool();
}//close reset()
}
