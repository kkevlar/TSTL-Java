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

	@Override
	public void manipulateTest() 
	{
		int replaceValue = -1; //repValue of all the actions in the original test
		int targetId = -1; //the id of the above repvalue
		int indexOfActionToBeReplaced = -1; //sut.getActions() index of the action which has the above large repValue
		for(int x = 0; x < getOriginalTestIds().length; x++)
		{
			Action action = getSut().getActions()[getOriginalTestIds()[x]];
			for (int y = 0; y < action.repVals().length; y++) 
			{
				if(action.repVals()[y] > replaceValue)
				{
					replaceValue = action.repVals()[y];
					targetId = action.repIds()[y];
					indexOfActionToBeReplaced = x;
				}
			}
		}

		boolean[] valuesInUse = new boolean[replaceValue]; //stores whether repVal of index is in use for the targetId
		boolean[] actionNeedsReplacement = new boolean[getOriginalTestIds().length]; //stores whether action whose index is conained in the originalTestIds needs to be replaced
		for(int x = 0 ; x < getOriginalTestIds().length; x++)
		{
			Action currAction = getSut().getActions()[getOriginalTestIds()[x]];
			for (int y = 0; y < currAction.repIds().length; y++) 
			{
				int currId = currAction.repIds()[y];
				int currVal = currAction.repVals()[y];
				if(currId == targetId)
				{
					if(currVal == replaceValue)
						actionNeedsReplacement[x] = true;
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
		int[] replacedActionIndices = new int[getOriginalTestIds().length];
		for (int x = 0; x < replacedActionIndices.length; x++)
		{
			replacedActionIndices[x] = -1;
		}
		for (int s = 0; s < getSut().getActions().length; s++) 
		{
			Action currSutAction = getSut().getActions()[s];
			for(int x = 0; x < getOriginalTestIds().length; x++)
			{
				Action currOrigAction = getSut().getActions()[getOriginalTestIds()[x]];
				if(actionNeedsReplacement[x] == true && currOrigAction.familyId() == currSutAction.familyId())
				{
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
							else
							{
								if(sutVal != origVal)
								{
									isOk = false;
									break;
								}
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
		}
		for (int x = 0; x < replacedActionIndices.length; x++) 
		{
			if(replacedActionIndices[x] == -1)
			{
				replacedActionIndices[x] = getOriginalTestIds()[x];
			}
		}
		this.setReducedTest(replacedActionIndices);		
	}
}
