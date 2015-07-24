import java.util.ArrayList;

public class SmartTestReducer extends TestReducer
{
	private long timeout;
	private ArrayList<FamilyDictionaryEntry> familyDictionary;
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
		
		//make family Dictionary
		familyDictionary = new ArrayList<FamilyDictionaryEntry>();
		for (int x = 0; x < this.getSut().getActions().length; x++) 
		{
			boolean set = false;
			for (int y = 0; y < familyDictionary.size(); y++) 
			{
				if(getSut().getActions()[x].actionFamilyId() == familyDictionary.get(y).getFamilyId())
				{
					familyDictionary.get(y).getActionIndices().add(x);
					set = true;
					break;
				}
			}
			if(!set)
			{
				FamilyDictionaryEntry entry = new FamilyDictionaryEntry(getSut().getActions()[x].actionFamilyId());
				entry.getActionIndices().add(x);
				familyDictionary.add(entry);
			}
		}
		
		
		
		logger.close();
	}
	public long getTimeout() 
	{
		return timeout;
	}
	public void setTimeout(long timeout) 
	{
		this.timeout = timeout;
	}
	public class 
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
