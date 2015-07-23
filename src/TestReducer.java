import java.util.ArrayList;


public abstract class TestReducer 
{
	private SUTInterface sut;
	private int[] originalTestIds;	
	private Tester tester;
	private ArrayList<Integer> reducedTest;
	private boolean shouldAppendFailingTest;
	public TestReducer(SUTInterface sut, int[] actTraceArray, Tester tester2)
	{
		super();
		setUp(sut, actTraceArray, tester2);
	}
	public TestReducer(SUTInterface sut, ArrayList<Integer> actTrace, Tester tester)
	{
		super();
		int[] actTraceArray = new int[actTrace.size()];
		for (int i = 0; i < actTraceArray.length; i++) 
		{
			actTraceArray[i] = actTrace.get(i);
		}
		setUp(sut,actTraceArray,tester);
	}
	private void setUp(SUTInterface sut, int[] actTraceArray, Tester tester) 
	{
		this.sut = sut;
		this.originalTestIds = actTraceArray;
		this.tester = tester;	
		this.shouldAppendFailingTest = tester.shouldAppendFailingTest();
	}
	public int[] getReducedTestIds()
	{
		if(reducedTest == null)
			reduceTest();
		int[] ids = new int[reducedTest.size()];
		for (int i = 0; i < ids.length; i++) 
		{
			ids[i] = reducedTest.get(i);
		}
		return ids;
	}
	
	public abstract void reduceTest();


	protected boolean runTest(ArrayList<Integer> actionIds)
	{		
		boolean testFailed = false;
		int oldSize = actionIds.size();
		ArrayList<Integer> newTest = new ArrayList<Integer>();
		sut.reset();
		for (int i = 0; i < actionIds.size(); i++) 
		{
			Action action = TstlConstants.getActionById(sut, actionIds.get(i));
			if(action.enabled())
			{
				boolean success = tester.executeAct(tester.getIgnoreCheckValue() < 1, action, false);
				newTest.add(actionIds.get(i));
				if(!success)
				{
					testFailed = true;
					break;
				}
			}
		}
		if(testFailed)
			reducedTest = newTest;		
		if(newTest.size() != oldSize)
			return testFailed;
		else
			return false;
	}
	protected boolean runTest(int[] actionIds)
	{		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0; i < actionIds.length; i++)
		{
			arrList.add(actionIds[i]);
		}
		return runTest(arrList);
	}

	public boolean getShouldAppendFailingTest()
	{
		return shouldAppendFailingTest;
	}

	public void setShouldAppendFailingTest(boolean shouldAppendFailingTest)
	{
		this.shouldAppendFailingTest = shouldAppendFailingTest;
	}
	public SUTInterface getSut() 
	{
		return sut;
	}
	
	public int[] getOriginalTestIds() 
	{
		return originalTestIds;
	}
	
	public Tester getTester() 
	{
		return tester;
	}
	public ArrayList<Integer> getReducedTest()
	{
		return reducedTest;
	}
	public void setReducedTest(ArrayList<Integer> reducedTest)
	{
		this.reducedTest = reducedTest;
	}
	
}