import java.util.ArrayList;


public class TestReducer 
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
	public void reduceTest()
	{ 
		if(reducedTest == null)
		{
			reducedTest = new ArrayList<Integer>();
			for (int i = 0; i < originalTestIds.length; i++) 
			{
				reducedTest.add(originalTestIds[i]);
			}
		}
		boolean fullyReduced = false;
		while(!fullyReduced)
		{
			int pieceCount = 1;			
			boolean reduced = false;
			while(!reduced)
			{
				pieceCount *= 2;
				if(pieceCount > reducedTest.size())
					pieceCount = reducedTest.size();
				reduced = reduceUsingPieces(pieceCount, reducedTest);
				if(pieceCount == reducedTest.size() && !reduced)
				{
					fullyReduced = true;
					break;
				}
			}		
		}
	}
	

	private boolean reduceUsingPieces(int numPieces, ArrayList<Integer> test)
	{
		ArrayList<Integer> newTest;
		int lastId = test.get(test.size() -1);
		int actionCount = test.size();
		boolean reduced = false;
		
		for (int x = 0; x < numPieces; x++) 
		{
			newTest = new ArrayList<Integer>();
			int cutOut = (int) ((x+0.0)*((actionCount+0.0)/(numPieces+0.0)));
			int cutIn = (int) (((x+1)+0.0)*((actionCount+0.0)/(numPieces+0.0))) -1;
			for (int y = 0; y < actionCount; y++)
			{
				if(y < cutOut || y > cutIn)
					newTest.add(test.get(y));		
			}
			if(x != numPieces-1 && getShouldAppendFailingTest())
				newTest.add(lastId);
			reduced = runTest(newTest);
			if(reduced)
				break;
		}
		return reduced;
	}
	private boolean runTest(ArrayList<Integer> actionIds)
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
		return testFailed;
	}

	public boolean getShouldAppendFailingTest()
	{
		return shouldAppendFailingTest;
	}

	public void setShouldAppendFailingTest(boolean shouldAppendFailingTest)
	{
		this.shouldAppendFailingTest = shouldAppendFailingTest;
	}
}