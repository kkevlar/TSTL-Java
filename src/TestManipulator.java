import java.util.ArrayList;


public abstract class TestManipulator 
{
	private SUTInterface sut;
	private int[] originalTestIds;	
	private Tester tester;
	private ArrayList<Integer> reducedTest;
	private boolean shouldAppendFailingTest;
	public TestManipulator(SUTInterface sut, int[] actTraceArray, Tester tester2)
	{
		super();
		setUp(sut, actTraceArray, tester2);
	}
	public TestManipulator(SUTInterface sut, ArrayList<Integer> actTrace, Tester tester)
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
		ArrayList<Integer> newTest = new ArrayList<Integer>();
		sut.reset();
		for (int i = 0; i < actionIds.size(); i++) 
		{
			Action action = sut.getActions()[actionIds.get(i)];
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
		return testFailed;

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
	protected ArrayList<Integer> getReducedTest()
	{
		return reducedTest;
	}
	public void setReducedTest(ArrayList<Integer> reducedTest)
	{
		this.reducedTest = reducedTest;
	}
	public void setReducedTest(int[] reducedTestIds) 
	{
		ArrayList<Integer> reducedTestArrList = new ArrayList<Integer>();
		for (int i = 0; i < reducedTestIds.length; i++) 
		{
			reducedTestArrList.add(reducedTestIds[i]);
		}
		setReducedTest(reducedTestArrList);
	}
	
}
