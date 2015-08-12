import java.util.ArrayList;


public class TestCanonizer extends TestManipulator {

	public TestCanonizer(SUTInterface sut, int[] actTraceArray, Tester tester2) 
	{
		super(sut, actTraceArray, tester2);
	}

	public TestCanonizer(SUTInterface sut, ArrayList<Integer> actTrace,Tester tester)
	{
		super(sut, actTrace, tester);

	}

	@Override
	public void manipulateTest() 
	{
		int largestId = 0;
		int largestValue = 0;
		int largestIdForLargestValue = -1;
		for(int x = 0; x < getOriginalTestIds().length; x++)
		{
			Action action = getSut().getActions()[getOriginalTestIds()[x]];
			for (int y = 0; y < action.repIds().length; y++) 
			{
				if(action.repIds()[y] > largestId)
					largestId = action.repIds()[y];
			}
			for (int y = 0; y < action.repVals().length; y++) 
			{
				if(action.repVals()[y] > largestValue)
				{
					largestValue = action.repVals()[y];
					largestIdForLargestValue = action.repIds()[y];
				}
			}
		}
		boolean[][] valuesUsed = new boolean[largestId][largestValue];
		for(int x = 0; x < getOriginalTestIds().length; x++)
		{
			Action action = getSut().getActions()[getOriginalTestIds()[x]];
			for (int y = 0; y < Math.min(action.repIds().length,action.repVals().length); y++)
			{
				int repId = action.repIds()[y];
				int repVal = action.repVals()[y];
				valuesUsed[repId][repVal] = true;
			}
		}
		
		int targetValue = -1;
		for(int i = 0; i < valuesUsed[largestIdForLargestValue].length -1; i++)
		{
			if(!valuesUsed[largestIdForLargestValue][i])
			{
				targetValue = i;
				break;
			}
		}
		
		for(int x = 0; x < getSut().getActions().length; x++)
		{
			Action action = getSut().getActions()[x];
			for (int y = 0; y < Math.min(action.repIds().length,action.repVals().length); y++)
			{
				int repId = action.repIds()[y];
				int repVal = action.repVals()[y];
				if(largestIdForLargestValue == repId || repVal == largestValue)
					
			}
		}
	}
}
