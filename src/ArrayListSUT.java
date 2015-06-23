import java.util.ArrayList;


public class ArrayListSUT
{
	private ArrayList<Integer> list;
	public void add(int i)
	{
		list.add(i);
	} 
	public boolean remove(int i)
	{
		return list.remove(new Integer(i));
	}
	
}
