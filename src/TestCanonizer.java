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
		int largestValue = -1;
		int idOfLargestValue = -1;
		int indexOfActionToBeReplaced = -1;
		for(int x = 0; x < getOriginalTestIds().length; x++)
		{
			Action action = getSut().getActions()[getOriginalTestIds()[x]];
			for (int y = 0; y < action.repVals().length; y++) 
			{
				if(action.repVals()[y] > largestValue)
				{
					largestValue = action.repVals()[y];
					idOfLargestValue = action.repIds()[y];
					indexOfActionToBeReplaced = x;
				}
			}
		}
		/*
		boolean[][] valuesUsed = new boolean[largestId][largestValue];
		for(int x = 0; x < getOriginalTestIds().length; x++)
		{
			Action action = getSut().getActions()[getOriginalTestIds()[x]];
			int min = Math.min(action.repIds().length,action.repVals().length);
			for (int y = 0; y < min; y++)
			{
				int repId = action.repIds()[y];
				int repVal = action.repVals()[y];
				valuesUsed[repId][repVal] = true;
			}
		}
		*/
		int replacementValue = 0;
		Action actionToBeReplaced = getSut().getActions()[indexOfActionToBeReplaced];
			
		
	}
}
