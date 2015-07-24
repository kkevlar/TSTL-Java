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
		int[][] families = new int[getOriginalTestIds().length][];
		for (int x = 0; x < families.length; x++) 
		{
			Action action = TstlConstants.getActionById(getSut(), this.getOriginalTestIds()[x]);
			int famId = action.actionFamilyId();
			for (int y = 0; y < getSut().getActions().length; y++) 
			{
								
			}
		}
		
		ArrayList<ArrayList<Integer>> familyDictionary = new ArrayList<ArrayList<Integer>>();
		for (int x = 0; x < this.getSut().getActions().length; x++) 
		{
			for (int y = 0; y < familyDictionary.size(); y++) 
			{
				if(getSut().getActions()[x].actionFamilyId() == familyDictionary.get(y))
			}
		}
	}
	private class FamilyDictionaryEntry
	{
		private int familyId;
		private int[] actionIds;
	}

}
