import java.util.ArrayList;


public class ArrayListSUT
{
	private ArrayList<Integer> list;
	public ArrayListSUT()
	{
		list = new ArrayList<Integer>();
	}
	public void add(int i)
	{
		list.add(i);
	}

	public boolean remove(int i)
	{
		return list.remove(new Integer(i));
	}

	public boolean guard_add()
	{
		return true;
	}

	public boolean guard_remove()
	{
		return true;
	}

	public int getSize()
	{
		return list.size();
	}
}
