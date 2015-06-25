
public class RandomTester 
{

	private static final long MAX_TESTS = 100;
	private static final long TIMEOUT = 30*1000;

	public static void main(String[] args) 
	{		
		new RandomTester().go();
	}

	private void go() 
	{
		SUTInterface sut = new SUT();
		System.out.println(String.format("%-65s " + "enabled:","Actions:"));
		System.out.println();
		for(int i = 0; i < sut.getActions().length; i++)
		{
			boolean enabled = sut.getActions()[i].enabled();
			String name = sut.getActions()[i].name().trim();
			System.out.println(String.format("%-65s " + enabled,name));
		}
		System.out.println("Initializing test...");
		long startTime = System.currentTimeMillis();
		long testCount = 0;
		long maxTests = MAX_TESTS;
		long timeout = TIMEOUT;
		long loopCount = 1;
		
		int actionCount = sut.getActions().length;
		while(timeInBounds(startTime, timeout))
		{
			sut.reset();
			testCount = 0;
			int randNum = (int) (Math.random()*1000000);
			boolean print = randNum == 2;
			if(print)
			System.out.println(">>Test Number " + loopCount);
			while(testCount<maxTests&&timeInBounds(startTime,timeout))
			{
				boolean enabled = false;
				int testNum = -1;
				while(!enabled && timeInBounds(startTime,timeout))
				{
					testNum = (int) (Math.random() * actionCount);
					enabled = sut.getActions()[testNum].enabled();
				}
				if(print)
				System.out.println(sut.getActions()[testNum].name().trim());				
				sut.getActions()[testNum].act();				
				testCount++;
			}
			loopCount++;
		}
		System.out.println("-Tested for " + ((System.currentTimeMillis()-startTime+0.0)/(1000+0)) + " seconds.");
		System.out.println("-Ran " + loopCount + " tests of " + maxTests +" actions.");
		System.out.println("-Final test only got to " + testCount + " actions.");
	}
	
	private boolean timeInBounds(long startTime, long timeout) 
	{		
		return System.currentTimeMillis() - startTime < timeout;
	}
}
