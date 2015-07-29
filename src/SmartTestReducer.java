import java.util.ArrayList;

public class SmartTestReducer extends TestReducer
{

	private TstlLogger logger;

	public SmartTestReducer(SUTInterface sut, int[] actTraceArray, Tester tester2) 
	{
		super(sut, actTraceArray, tester2);
	}

	public SmartTestReducer(SUTInterface sut, ArrayList<Integer> actTrace, Tester tester) 
	{
		super(sut, actTrace, tester);
	}

	@Override
	public void reduceTest() 
	{		
		logger = new TstlLogger("smartTestReduce");
		removeReInitializations(this.getOriginalTestIds());
		logger.close();
		
	}

	private void removeReInitializations(int[] testToReduce)
	{
		boolean shouldRunAgain = false;
		long lastPrintTime = 0;
		for(int x = 0; x < testToReduce.length; x++)
		{
			int[] newTestIds = new int[testToReduce.length];
			int initId = this.getSut().getActions()[x].initId();
			if(initId == -1)
				newTestIds = testToReduce;
			else
			{
				for (int y = 0; y <  testToReduce.length; y++) 
				{
					newTestIds[y] = testToReduce[y];
					if(x == y)
					{
						logger.append("x==y");
						for(int z = 0; z < testToReduce.length; z++)
						{
							int trialId = this.getSut().getActions()[z].initId();
							if(trialId == initId && y != z)
								newTestIds[y] = testToReduce[z];
						}
					}
				}
			}
			boolean testFailed = this.runTest(newTestIds);
			
			if(testFailed)
			{
				
				if(System.currentTimeMillis() - lastPrintTime > 5000)
				{
					logger.append("A TEST FAILED");
					for (int i = 0; i < getReducedTest().size(); i++) 
					{
						String name = getSut().getActions()[getReducedTest().get(i)].name();
						logger.append("--"+name.trim());
					}
					lastPrintTime = System.currentTimeMillis();
				}
				
				BinaryTestReducer reducer = new BinaryTestReducer(getSut(), this.getReducedTest(), getTester());
				int[] binReducedTest = reducer.getReducedTestIds();

				if(binReducedTest != null && (this.getReducedTest() == null || this.getReducedTest().size() > binReducedTest.length))
				{
					int[] newArray = new int[binReducedTest.length];
					for (int i = 0; i < newArray.length; i++)
					{
						newArray[i] = binReducedTest[i];					
					}
					this.setReducedTest(newArray);
					logger.append("RESET REDUCED TEST");

					for (int i = 0; i < binReducedTest.length; i++) 
					{
						String name = getSut().getActions()[binReducedTest[i]].name();
						logger.append("--"+name.trim());
					}
					shouldRunAgain = true;
					break;
				}
			}
		}
		if(shouldRunAgain)		
			this.removeReInitializations(this.getReducedTestIds());
	
	}
}
