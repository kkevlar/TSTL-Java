import java.util.ArrayList;


public class BinaryTestReducer extends TestReducer
{
	
	public BinaryTestReducer(SUTInterface sut, ArrayList<Integer> actTrace, Tester tester)
	{
		super(sut, actTrace, tester);
	}
	public BinaryTestReducer(SUTInterface sut, int[] actTraceArray, Tester tester2) 
	{
		super(sut, actTraceArray, tester2);
	}
	@Override
	public void reduceTest()
	{ 
		if(getReducedTest() == null)
		{
			ArrayList<Integer> tempTest = new ArrayList<Integer>();
			for (int i = 0; i < getOriginalTestIds().length; i++) 
			{
				tempTest.add(getOriginalTestIds()[i]);
			}
			setReducedTest(tempTest);
		}
		boolean fullyReduced = false;
		while(!fullyReduced)
		{
			int pieceCount = 1;			
			boolean reduced = false;
			while(!reduced)
			{
				pieceCount *= 2;
				if(pieceCount > getReducedTest().size())
					pieceCount = getReducedTest().size();
				reduced = reduceUsingPieces(pieceCount, getReducedTest());
				if(pieceCount == getReducedTest().size() && !reduced)
				{
					fullyReduced = true;
					break;
				}
			}		
		}
	}

	private boolean reduceUsingPieces(int numPieces, ArrayList<Integer> test)
	{
		ArrayList<Integer> newTest;
		int lastId = test.get(test.size() -1);
		int actionCount = test.size();
		boolean reduced = false;
		
		for (int x = 0; x < numPieces; x++) 
		{
			newTest = new ArrayList<Integer>();
			int cutOut = (int) ((x+0.0)*((actionCount+0.0)/(numPieces+0.0)));
			int cutIn = (int) (((x+1)+0.0)*((actionCount+0.0)/(numPieces+0.0))) -1;
			for (int y = 0; y < actionCount; y++)
			{
				if(y < cutOut || y > cutIn)
					newTest.add(test.get(y));		
			}
			if(x != numPieces-1 && getShouldAppendFailingTest())
				newTest.add(lastId);
			reduced = runTest(newTest);
			if(reduced)
				break;
		}
		return reduced;
	}
}