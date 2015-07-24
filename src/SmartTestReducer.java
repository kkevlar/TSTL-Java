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
		
		ArrayList<FamilyDictionaryEntry> familyDictionary = new ArrayList<FamilyDictionaryEntry>();
		for (int x = 0; x < this.getSut().getActions().length; x++) 
		{
			for (int y = 0; y < familyDictionary.size(); y++) 
			{
				if(getSut().getActions()[x].actionFamilyId() == familyDictionary.get(y))
			}
		}
	}
	public class FamilyDictionaryEntry
	{
		private int familyId;
		private int[] actionIndices;
		public FamilyDictionaryEntry(int familyId, int[] actionIndices)
		{
			super();
			this.familyId = familyId;
			this.actionIndices = actionIndices;
		}
		public int getFamilyId() {
			return familyId;
		}
		public void setFamilyId(int familyId) {
			this.familyId = familyId;
		}
		public int[] getActionIndices() {
			return actionIndices;
		}
		public void setActionIndices(int[] actionIndices) {
			this.actionIndices = actionIndices;
		}
		
	}
}
