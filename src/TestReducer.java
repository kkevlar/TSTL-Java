
public class TestReducer 
{
	private SUTInterface sut;
	private int[] originalTestIds;	
	private RandomTester tester;
	private int[] reducedTest;
	private enum TestResult {NOFAIL, FAIL, IMPOSSIBLE};
	private class TestResultBundle
	{
		private TestResult result;
		private int id;
		public TestResultBundle(TestResult result, int id) {
			super();
			this.result = result;
			this.id = id;
		}
		public TestResult getResult() {
			return result;
		}
		
		
	}
	public TestReducer(SUTInterface sut, int[] originalTestIds, RandomTester tester)
	{
		super();
		this.sut = sut;
		this.originalTestIds = originalTestIds;
		this.tester = tester;
	}
	public int[] reduceTest()
	{
		reduceTest(originalTestIds);
		return this.reducedTest;
	}
	private void reduceTest(int[] testIds)
	{
		TestResultBundle bundle = this.executeTest(testIds);
		if(bundle.getResult() != TestResult.FAIL)
		{
			System.out.println("nofail");
			return;
		}
		else if ((reducedTest == null || testIds.length < reducedTest.length) && testIds.length > 0)
		{
			reducedTest = testIds;
			System.out.println("fail and set");
		}
		else
		{
			System.out.println("fail noset");
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
	private TestResultBundle executeTest(int[] testIds)
	{
		sut.reset();
		for (int i = 0; i < testIds.length; i++)
		{
			Action action = this.getActionById(testIds[i]);
			boolean enabled = action.enabled();
			if(!enabled)
				return new TestResultBundle(TestResult.IMPOSSIBLE,testIds[i]);
			boolean success = tester.executeAct(action,false);
			if(!success)
				return new TestResultBundle(TestResult.FAIL, testIds[i]);
		}
		return new TestResultBundle(TestResult.NOFAIL,-1);
	}
	private boolean isTestOk(int[] actionIds)
	{
		if(actionIds[actionIds.length - 1] != originalTestIds[originalTestIds.length - 1])
			return false;
		sut.reset();
		for (int i = 0; i < actionIds.length -1; i++) 
		{
			Action action = getActionById(actionIds[i]);
			if(!(action.enabled()))
				return false;
			action.act();
		}
		if(this.getActionById(actionIds[actionIds.length-1]).enabled())
			return true;
		else
			return false;
	}	

	private Action getActionById(int l)
	{
		Action action = sut.getActions()[l];
		if(action.id() == l)
			return action;
		for (int i = 0; i < sut.getActions().length; i++)
		{
			action = sut.getActions()[i];
			if(action.id() == l)
				return action;
		}
		return null;
	}
}
