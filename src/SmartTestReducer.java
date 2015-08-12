import java.util.ArrayList;

public class SmartTestReducer extends TestManipulator
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
		for(int x = 0; x < testToReduce.length; x++)
		{
			boolean didReplace = false;
			int replacedInitActionIndex = -1;
			int removedInitActionIndex = -1;
			int[] newTestIds = new int[testToReduce.length];
			int initId = this.getSut().getActions()[testToReduce[x]].initId();
			if(initId == -1)
				newTestIds = testToReduce;
			else
			{
				for (int y = 0; y <  testToReduce.length; y++) 
				{
					newTestIds[y] = testToReduce[y];
					if(x == y && !didReplace)
					{
						logger.append("x==y");
						for(int z = 0; z < testToReduce.length && !didReplace; z++)
						{
							int trialId = this.getSut().getActions()[testToReduce[z]].initId();
							if(trialId == initId && y != z)
							{
								newTestIds[y] = testToReduce[z];
								replacedInitActionIndex = testToReduce[z];
								removedInitActionIndex = testToReduce[y];
								outputTheReplace(testToReduce, y, z);
								logger.append("initId", initId+"");
								logger.append("trialId", trialId + "");
								didReplace = true;
							}
						}
					}
				}
			}
			if(!didReplace)
				continue;
			boolean testFailed = runTest(newTestIds, removedInitActionIndex, replacedInitActionIndex);
			
			if(testFailed)
			{				
				if(didReplace)
				{
					logger.append("A TEST FAILED");
					for (int i = 0; i < getReducedTest().size(); i++) 
					{
						String name = getSut().getActions()[getReducedTest().get(i)].name();
						logger.append("--"+name.trim());
					}
				}
				BinaryTestReducer reducer = new BinaryTestReducer(getSut(), this.getReducedTest(), getTester());
				int[] binReducedTest = reducer.getReducedTestIds();

				if(binReducedTest != null && (this.getReducedTest() == null || newTestIds.length > binReducedTest.length))
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
					break;
				}
			}
			else if(didReplace)
			{
				logger.append("Problably should hava failed...");
					for (int i = 0; i < newTestIds.length; i++) 
					{
						String name = getSut().getActions()[newTestIds[i]].name();
						logger.append("--"+name.trim());
					}
			}
		}
		if(this.getReducedTest() == null)
			this.setReducedTest(this.getOriginalTestIds());
	}

	private void removeReInitializations(ArrayList<Integer> reducedTest)
	{
		int[] actionIndicies = new int[reducedTest.size()];
		for (int i = 0; i < actionIndicies.length; i++) 
		{
			actionIndicies[i] = reducedTest.get(i);
		}
		removeReInitializations(actionIndicies);		
	}

	protected boolean runTest(int[] actionIds, int removedInitActionIndex, int replacedInitActionIndex)
	{		
		boolean testFailed = false;
		getSut().reset();
		ArrayList<Integer> smallerTest = new ArrayList<Integer>();
		int shouldIgnore = getSut().getActions()[removedInitActionIndex].initId();
		for (int i = 0; i < actionIds.length; i++) 
		{
			Action action = getSut().getActions()[actionIds[i]];
			int changeId = -1;
			if(!action.enabled() && action.initId() != shouldIgnore)
			{
				String oldname = action.name();
				changeId = findRelatedEnabledActionId(removedInitActionIndex, replacedInitActionIndex, actionIds[i]);
				if(changeId == -1)
					return false;
				action = getSut().getActions()[changeId];
				logger.append("findRelatedEnabledAction replaced \"" + oldname + "\" with \"" + action.name() + "\".");
				if(action == null || (!(action.enabled())))
					return false;
			}
			if(action.enabled())
			{
				boolean success = getTester().executeAct(getTester().getIgnoreCheckValue() < 1, action, false);
				if(changeId == -1)
					changeId = actionIds[i];
				smallerTest.add(changeId);
				if(!success)
				{
					testFailed = true;
					break;
				}
			}
		}
		if(testFailed)
			setReducedTest(smallerTest);		
		return testFailed;

	}
	private int findRelatedEnabledActionId(int removedInitActionIndex, int replacedInitActionIndex, int disabledActionIndex)
	{
		Action removedInitAction = getSut().getActions()[removedInitActionIndex];
		Action replacedInitAction = getSut().getActions()[replacedInitActionIndex];
		Action disabledAction = getSut().getActions()[disabledActionIndex];
		ArrayList<Integer> repValsIndeciesToChange = new ArrayList<Integer>();
		int[] disabledActionRepIds = disabledAction.repIds();
		for (int i = 0; i < disabledActionRepIds.length; i++) 
		{
			if(disabledActionRepIds[i] == removedInitAction.initId())
			{
				repValsIndeciesToChange.add(i);
				break;
			}
		}
		int repValShouldChangeTo = replacedInitAction.repVals()[0];
		int[] comarableRepIds = new int[disabledAction.repVals().length];
		for (int i = 0; i < comarableRepIds.length; i++)
		{
			if(!(repValsIndeciesToChange.contains(new Integer(i))))
				comarableRepIds[i] = disabledAction.repVals()[i];
			else
				comarableRepIds[i] = repValShouldChangeTo;
		}
		int changeId = -1;
		for (int x = 0; x < getSut().getActions().length; x++)
		{
			boolean sameFamily = getSut().getActions()[x].familyId() == disabledAction.familyId();
			if(sameFamily && getSut().getActions()[x].repVals().length == comarableRepIds.length)
			{
				boolean exactlyCompare = true;
				for (int y = 0; y < getSut().getActions()[x].repVals().length; y++)
				{
					if(getSut().getActions()[x].repVals()[y] != comarableRepIds[y])
					{
						exactlyCompare = false;
						break;
					}
				}
				if(exactlyCompare)
				{
					changeId = x;
					break;
				}
			}
		}
		return changeId;
	}

	private void outputTheReplace(int[] testToReduce, int y, int z) 
	{
		String lineOrig = getSut().getActions()[testToReduce[y]].name();
		String lineRepl = getSut().getActions()[testToReduce[z]].name();
		logger.append("Replacing \"" + lineOrig + "\" with \"" + lineRepl + "\"");
	}
}
