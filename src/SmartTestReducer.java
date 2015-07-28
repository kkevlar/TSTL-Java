import java.util.ArrayList;

public class SmartTestReducer extends TestReducer
{

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
		TstlLogger logger = new TstlLogger("newSmartTestReduce");

		long startTime = System.currentTimeMillis();
		int[] reducedTestIds = this.getOriginalTestIds();
		long lastPrintTime = 0;
		while (System.currentTimeMillis() - startTime < getTimeout())
		{
			int[] newTestIds = new int[reducedTestIds.length];
			for (int x = 0; x <  reducedTestIds.length; x++) 
			{
				int testIndex = reducedTestIds[x];
				Action originalAction = getSut().getActions()[testIndex];
				int familyId = originalAction.actionFamilyId();
				int siblingCount = families[familyId].length;
				int randNum = (int) (Math.random() * siblingCount);
				newTestIds[x] = families[familyId][randNum];
			}

			boolean testFailed = this.runTest(newTestIds);
			
			/*start output (can delete)
			if(testFailed)
			{
				System.out.println("Test failed. Heres main line of each step.");
				for (int i = 0; i < newTestIds.length; i++) 
				{
					String name = getSut().getActions()[newTestIds[i]].name();
					System.out.println(name.trim());
				}
			}
			end output */
			//logger.append("testFailed",testFailed+"");
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
				
				if(binReducedTest != null && (reducedTestIds == null || reducedTestIds.length > binReducedTest.length))
				{
					int[] newArray = new int[binReducedTest.length];
					for (int i = 0; i < newArray.length; i++)
					{
						newArray[i] = binReducedTest[i];					
					}
					reducedTestIds = newArray;
					logger.append("RESET REDUCED TEST");

					for (int i = 0; i < binReducedTest.length; i++) 
					{
						String name = getSut().getActions()[binReducedTest[i]].name();
						logger.append("--"+name.trim());
					}
				}
			}
		}
		logger.append(reducedTestIds.length + "");
		if(reducedTestIds != null && reducedTestIds.length < getOriginalTestIds().length)
			setReducedTest(reducedTestIds);
		logger.close();
	}
}
