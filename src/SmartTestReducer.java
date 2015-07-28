import java.util.ArrayList;

public class SmartTestReducer extends TestReducer
{
	private int[][] families;
	private long smartTestReduceTimeout;

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

		long startTime = System.currentTimeMillis();
		int[] reducedTestIds = this.getOriginalTestIds();
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
		families = new int[maxFamilyId+1][];
		for (int x = 0; x < familyDictionary.size(); x++)
		{
			FamilyDictionaryEntry famEntry = familyDictionary.get(x); 
			int famId = famEntry.getFamilyId();
			families[famId] = famEntry.getIndeciesAsArray();			
		}
	}
	public long getTimeout() 
	{
		return smartTestReduceTimeout;		
	}
	public void setTimeout(long timeout) 
	{
		this.smartTestReduceTimeout = timeout;
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
