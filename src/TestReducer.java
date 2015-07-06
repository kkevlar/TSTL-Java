
public class TestReducer 
{
	private SUTInterface sut;
	private int[] originalTestIds;	
	private RandomTester tester;
	private int[] reducedTest;
	public TestReducer(SUTInterface sut, int[] originalTestIds, RandomTester tester)
	{
		super();
		this.sut = sut;
		this.originalTestIds = originalTestIds;
		this.tester = tester;
	}
	public int[] reduceTest()
	{
		//need to implement
		return this.reducedTest;
	}
	
	public boolean reduceBinarily(int numPieces)
	{
		//need to implement
		return false;
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
