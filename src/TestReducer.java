import java.util.ArrayList;


public class TestReducer 
{
	private SUTInterface sut;
	private int[] originalTestIds;	
	private RandomTester tester;
	private ArrayList<Integer> reducedTest;
	public TestReducer(SUTInterface sut, int[] originalTestIds, RandomTester tester)
	{
		super();
		setUp(sut, originalTestIds, tester);
	}
	
	public TestReducer(SUTInterface sut, ArrayList<Integer> actTrace, RandomTester tester)
	{
		super();
		int[] actTraceArray = new int[actTrace.size()];
		for (int i = 0; i < actTraceArray.length; i++) 
		{
			actTraceArray[i] = actTrace.get(i);
		}
		setUp(sut,actTraceArray,tester);
	}

	private void setUp(SUTInterface sut, int[] actTraceArray, RandomTester tester) 
	{
		this.sut = sut;
		this.originalTestIds = actTraceArray;
		this.tester = tester;		
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
				if(pieceCount > reducedTest.size() && !reduced)
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
		int actionCount = test.size();
		boolean reduced = false;
		for (int x = 0; x < numPieces; x++) 
		{
			newTest = new ArrayList<Integer>();
			int cutOut = (int) ((x+0.0)*((actionCount+0.0)/(numPieces+0.0)));
			int cutIn = (int) (((x+1)+0.0)*((actionCount+0.0)/(numPieces+0.0))) -1;
			for (int y = 0; y < actionCount; y++)
			{
				if(y < cutOut && y > cutIn)
					newTest.add(y);		
			}
			reduced = runTest(newTest);
			if(reduced)
				break;
		}
		return reduced;
	}

	private boolean runTest(ArrayList<Integer> actionIds)
	{
		boolean testFailed = false;
		ArrayList<Integer> newTest = new ArrayList<Integer>();
		sut.reset();
		for (int i = 0; i < actionIds.size(); i++) 
		{
			Action action = TstlConstants.getActionById(sut, actionIds.get(i));
			if(action.enabled())
			{
				boolean success = tester.executeAct(action, false);
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

	/* old code
	private void reduceTest(int[] testIds)
	{
		TestResultBundle bundle = tester.executeTest(testIds);
		if(bundle.getResult() != TestResult.FAIL)
		{
			//System.out.println("nofail");
			return;
		}
		else if ((reducedTest == null || testIds.length < reducedTest.length) && testIds.length > 0)
		{
			reducedTest = testIds;
			//System.out.println("fail and set");
		}
		else
		{
			//System.out.println("fail noset");
		}

		for (int x = 0; x < testIds.length; x++) 
		{
			int[] newTestIds = new int[testIds.length-1];
			for (int y = 0; y < testIds.length-1; y++) 
			{
				if(y < x)
					newTestIds[y] = testIds[y];
				else
					newTestIds[y] = testIds[y+1];
			}
			reduceTest(newTestIds);
		}
	}


	private boolean isTestOk(int[] actionIds)
	{
		if(actionIds[actionIds.length - 1] != originalTestIds[originalTestIds.length - 1])
			return false;
		sut.reset();
		for (int i = 0; i < actionIds.length -1; i++) 
		{
			Action action = TstlConstants.getActionById(sut,actionIds[i]);
			if(!(action.enabled()))
				return false;
			action.act();
		}
		if(TstlConstants.getActionById(sut,actionIds[actionIds.length-1]).enabled())
			return true;
		else
			return false;
	}	
	 */


}
