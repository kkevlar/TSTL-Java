import java.util.ArrayList;

public class SmartTestReducer extends TestReducer
{
	private long timeout;
	private int[][] families;
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
		TstlLogger logger = new TstlLogger("smartTestReduce");
		
		makeFamilyDictionary();
		
		//note: right now timeout cannot kill running tests
		
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < getTimeout())
		{
			int[] newTestIds = new int[getOriginalTestIds().length];
			for (int x = 0; x < getOriginalTestIds().length; x++) 
			{
				int testIndex = getOriginalTestIds()[x];
				Action originalAction = getSut().getActions()[testIndex];
				int familyId = originalAction.actionFamilyId();
				int siblingCount = families[familyId].length;
				int randNum = (int) (Math.random() * siblingCount);
				newTestIds[x] = families[familyId][randNum];
			}
			boolean testFailed = this.runTest(newTestIds);
			//if test failed, then run through binarytestreducer
		}
		//need to find a way to assign reduced test to reduced test field in testreducer
		logger.close();
	}

	private void makeFamilyDictionary() 
	{
		//make family Dictionary
		ArrayList<FamilyDictionaryEntry> familyDictionary = new ArrayList<FamilyDictionaryEntry>();
		int maxFamilyId = -1;
		for (int x = 0; x < getOriginalTestIds().length; x++) 
		{
			int sutIndexFromOriginalTest = getOriginalTestIds()[x];
			boolean set = false;
			int actionFamilyId = getSut().getActions()[sutIndexFromOriginalTest].actionFamilyId();
			for (int y = 0; y < familyDictionary.size(); y++) 
			{
				if(actionFamilyId == familyDictionary.get(y).getFamilyId())
				{
					familyDictionary.get(y).getActionIndices().add(sutIndexFromOriginalTest);
					set = true;
					break;
				}
			}
			if(!set)
			{
				FamilyDictionaryEntry entry = new FamilyDictionaryEntry(actionFamilyId);
				if(actionFamilyId > maxFamilyId)
					maxFamilyId = actionFamilyId;
				entry.getActionIndices().add(sutIndexFromOriginalTest);
				familyDictionary.add(entry);
			}
		}
		families = new int[maxFamilyId][];
		for (int x = 0; x < familyDictionary.size(); x++)
		{
			FamilyDictionaryEntry famEntry =familyDictionary.get(x); 
			int famId = famEntry.getFamilyId();
			families[famId] = famEntry.getIndeciesAsArray();			
		}
	}
	public long getTimeout() 
	{
		return timeout;
	}
	public void setTimeout(long timeout) 
	{
		this.timeout = timeout;
	}
	public class FamilyDictionaryEntry
	{
		private int familyId;
		private ArrayList<Integer> actionIndices;
		public FamilyDictionaryEntry(int familyId)
		{
			super();
			this.familyId = familyId;
			this.actionIndices = new ArrayList<Integer>();
		}
		public int getFamilyId()
		{
			return familyId;
		}
		public void setFamilyId(int familyId)
		{
			this.familyId = familyId;
		}
		public ArrayList<Integer> getActionIndices() 
		{
			return actionIndices;
		}
		public int[] getIndeciesAsArray()
		{
			int[] arr = new int[getActionIndices().size()];
			for (int i = 0; i < arr.length; i++) 
			{
				arr[i] = getActionIndices().get(i);				
			}
			return arr;
		}
		@Override
		public String toString() 
		{
			return "FamilyDictionaryEntry [familyId=" + familyId + ", actionIndices=" + actionIndices + "]";
		}			
	}
}
