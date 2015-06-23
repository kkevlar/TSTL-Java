import java.util.ArrayList;
//this is human-written code that the generator might generate

public class ArrayListTestTyped 
{

	public static void main(String[] args)
	{
		ArrayListTestTyped test = new ArrayListTestTyped();
		try 
		{
			test.body1();
		} 
		catch (TstlException e)
		{
			System.out.println("Test 1 failed.");
			System.out.println(e.getMessage());
		}
		try 
		{
			test.body2();
		} 
		catch (TstlException e)
		{
			System.out.println("Test 2 failed.");
			System.out.println(e.getMessage());
		}
		try 
		{
			test.body3();
		} 
		catch (TstlException e)
		{
			System.out.println("Test 3 failed.");
			System.out.println(e.getMessage());
		}

	}

	private void body1() throws TstlException 
	{
		int pool_LISTSIZE;
		int pool_ADDVAL;
		int pool_REMVAL;
		int pool_COUNT;
		ArrayList<Integer> pool_ARRLIST;
		pool_LISTSIZE = 37;
		pool_ARRLIST = new ArrayList<Integer>();
		for(pool_COUNT = 0; pool_COUNT < pool_LISTSIZE; pool_COUNT++)
		{
			pool_ADDVAL = (int) (Math.random()*123);
			m_ADD(pool_ARRLIST,pool_ADDVAL);
		}
		pool_REMVAL = 124;
		m_REMOVE(pool_ARRLIST, pool_REMVAL);		
	}
	private void body2() throws TstlException 
	{
		int pool_LISTSIZE;
		int pool_ADDVAL;
		int pool_REMVAL;
		int pool_COUNT;
		ArrayList<Integer> pool_ARRLIST;
		pool_LISTSIZE = 98;
		pool_ARRLIST = new ArrayList<Integer>();
		for(pool_COUNT = 0; pool_COUNT < pool_LISTSIZE; pool_COUNT++)
		{
			pool_ADDVAL = (int) (Math.random()*123);
			m_ADD(pool_ARRLIST,pool_ADDVAL);
		}
		pool_REMVAL = -77;
		m_REMOVE(pool_ARRLIST, pool_REMVAL);		
	}
	private void body3() throws TstlException 
	{
		int pool_LISTSIZE;
		int pool_ADDVAL;
		int pool_REMVAL;
		int pool_COUNT;
		ArrayList<Integer> pool_ARRLIST;
		pool_LISTSIZE = 5;
		pool_ARRLIST = new ArrayList<Integer>();
		for(pool_COUNT = 0; pool_COUNT < pool_LISTSIZE; pool_COUNT++)
		{
			pool_ADDVAL = (int) (Math.random()*123);
			m_ADD(pool_ARRLIST,pool_ADDVAL);
		}
		pool_REMVAL = 55;
		m_REMOVE(pool_ARRLIST, pool_REMVAL);		
	}

	private void m_ADD(ArrayList<Integer> m_OBJECT, int m_VAL) throws TstlException 
	{
		int size = m_OBJECT.size();
		m_OBJECT.add(m_VAL);
		if(!(size==m_OBJECT.size()+1))
			throw new TstlException("size==m_OBJECT.size()+1 evaluated false in %ADD%");
	}
	private void m_REMOVE(ArrayList<Integer> m_OBJECT, int m_VAL) throws TstlException 
	{
		int size = m_OBJECT.size();
		m_OBJECT.remove(m_VAL);
		if(!(size==m_OBJECT.size()-1))
			throw new TstlException("size==m_OBJECT.size()-1 evaluated false in %REMOVE%");
	}
	
	private class TstlException extends Exception
	{
		private String message;

		public TstlException(String string)
		{
			this.message = string;
		}
		public String getMessage()
		{
			return message;
		}
	}

}
