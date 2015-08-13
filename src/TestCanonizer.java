import java.util.ArrayList;


public class TestCanonizer extends TestManipulator 
{

	public TestCanonizer(SUTInterface sut, int[] actTraceArray, Tester tester2) 
	{
		super(sut, actTraceArray, tester2);
	}

	public TestCanonizer(SUTInterface sut, ArrayList<Integer> actTrace,Tester tester)
	{
		super(sut, actTrace, tester);

	}
	public int[] decreaseRepValues(int[] testToManipulate) 
	{
		int replaceValue = -1; //repValue of all the actions in the original test
		int targetId = -1; //the id of the above repvalue
		int indexOfActionToBeReplaced = -1; //sut.getActions() index of the action which has the above large repValue
		for(int x = 0; x < testToManipulate.length; x++)
		{
			Action action = getSut().getActions()[testToManipulate[x]];
			if(action.repVals()[0] > replaceValue)
			{
				replaceValue = action.repVals()[0];
				targetId = action.repIds()[0];
				indexOfActionToBeReplaced = x;
			}
		}
		Action targetAction = getSut().getActions()[testToManipulate[indexOfActionToBeReplaced]];
		
		boolean[] valuesInUse = new boolean[replaceValue]; //stores whether repVal of index is in use for the targetId
		boolean[] actionNeedsReplacement = new boolean[testToManipulate.length]; //stores whether action whose index is conained in the originalTestIds needs to be replaced
		for(int x = 0 ; x < testToManipulate.length; x++)
		{
			Action currAction = getSut().getActions()[testToManipulate[x]];
			for (int y = 0; y < currAction.repIds().length; y++) 
			{
				int currId = currAction.repIds()[y];
				int currVal = currAction.repVals()[y];
				if(currId == targetId)
				{
					if(currVal == replaceValue)
					{
						actionNeedsReplacement[x] = true;
						
					}
					else if(currVal < valuesInUse.length)
						valuesInUse[currVal] = true;
				}

			}
		}
		int targetValue = -1; //all occurrences of replaceValue when id is targetId will be replaced to this
		for (int i = 0; i < valuesInUse.length; i++) 
		{
			if(!valuesInUse[i])
			{
				targetValue = i;
				break;
			}
		}
		if(targetValue == -1 || targetValue >= replaceValue)
		{
			
			
			return null;
		}
		int[] replacedActionIndices = new int[testToManipulate.length];
		for (int x = 0; x < replacedActionIndices.length; x++)
		{
			replacedActionIndices[x] = -1;
		}
		for (int s = 0; s < getSut().getActions().length; s++) 
		{
			Action currSutAction = getSut().getActions()[s];
			for(int x = 0; x < testToManipulate.length; x++)
			{
				Action currOrigAction = getSut().getActions()[testToManipulate[x]];
				if(actionNeedsReplacement[x] != true || currOrigAction.familyId() != currSutAction.familyId())
					continue;
				int ySize = currSutAction.repIds().length; /*how many iterations the "y" loop will go. currSutAction.(repIds/repVals).length 
					and origAction.(repIds/repVals).length should all be equivalent */
				boolean isOk = true;
				for (int y = 0; y < ySize; y++) 
				{
					int sutId = currSutAction.repIds()[y];
					int sutVal = currSutAction.repVals()[y];
					int origId = currOrigAction.repIds()[y];
					int origVal = currOrigAction.repVals()[y];
					if(sutId != origId)
					{
						TstlConstants.log("TestCanonizer is flawed!");
					}
					if(sutId == targetId)
					{
						if(sutVal != targetValue || origVal != replaceValue)
						{
							isOk = false;
							break;
						}
					}
					else
					{
						if(sutVal != origVal)
						{
							isOk = false;
							break;
						}
					}

				}
				if(isOk)
				{
					replacedActionIndices[x] = s;
					actionNeedsReplacement[x] = false;
					
				}
			}
		}
		for (int x = 0; x < replacedActionIndices.length; x++) 
		{
			if(replacedActionIndices[x] == -1)
			{
				replacedActionIndices[x] = testToManipulate[x];
			}
		}
		return replacedActionIndices;
	}

	@Override
	public void manipulateTest()
	{
		int[] canonizedTest = this.decreaseRepValues(getOriginalTestIds());
		int[] prevCanonizedTest = canonizedTest;
		while(canonizedTest != null)
		{
			prevCanonizedTest = canonizedTest;
			canonizedTest = this.decreaseRepValues(prevCanonizedTest);
		}
		canonizedTest = this.moveInitializations(prevCanonizedTest);
		while(canonizedTest != null)
		{
			prevCanonizedTest = canonizedTest;
			canonizedTest = this.moveInitializations(prevCanonizedTest);
		}
		this.setManipulatedTest(prevCanonizedTest);
	}

	private int[] moveInitializations(int[] prevCanonizedTest) 
	{
		for (int x = 0; x < prevCanonizedTest.length; x++) 
		{
			int[] copied = new int[prevCanonizedTest.length];
			int firstNonInitIndex = -1;
			for (int y = 0; y < copied.length; y++)
			{
				Action action = getSut().getActions()[prevCanonizedTest[y]];
				if(firstNonInitIndex == -1 && action.initId() == -1)
					firstNonInitIndex = y;
				copied[y] = prevCanonizedTest[y];
			}
			Action action = getSut().getActions()[copied[x]];
			if(x <= firstNonInitIndex || action.initId() == -1 || firstNonInitIndex == -1)
				continue;
			int temp = copied[firstNonInitIndex];
			copied[firstNonInitIndex] = copied[x];
			copied[x] = temp;
			boolean testFailed = runTest(copied);
			if(testFailed)
				return copied;
		}
		return null;
	}
}
