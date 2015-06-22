import java.util.ArrayList;
public class ArrayListTestGen
{
public static void main (String[] args)
{
ArrayListTestGen x = new ArrayListTestGen();
try{
x.body0();
}catch(TstlException ex){
System.out.println("Test 0 failed");
System.out.println(ex.getMessage());
}
}
private void p_ADD( int p_VAL, ArrayList<Integer> p_OBJECT)  throws TstlException {
 int size = p_OBJECT.size(); 
 p_OBJECT.add(p_VAL); 
 if (!(size==p_OBJECT.size()-1) )
 throw new TstlException();
}
private void p_REMOVE( int p_VAL, ArrayList<Integer> p_OBJECT)  throws TstlException {
 int size = p_OBJECT.size(); 
 p_OBJECT.remove(p_VAL); 
 if (!(size==p_OBJECT.size()+1) )
 throw new TstlException();
}
private void body0() throws TstlException {
 int p_LISTSIZE  ;
 int p_ADDVAL ;
 int p_REMVAL ;
 int p_COUNT ;
 ArrayList<Integer> p_ARRLIST ;
 p_LISTSIZE = 49; 
 p_ARRLIST = new ArrayList<Integer>(); 
 for(p_COUNT = 0; p_COUNT < p_LISTSIZE; p_COUNT++) 
 { 
 	p_ADDVAL = (int) (Math.random()*123); 
 	p_ADD(p_ADDVAL,p_ARRLIST); 
 } 
 p_REMVAL = 231; 
 p_REMOVE(p_REMVAL, p_ARRLIST); 
}
}
