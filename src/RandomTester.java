


public class RandomTester 
{

	private static final int MAX_TESTS = 200;
	private static final long TIMEOUT = 3*60*1000;
	private static final long TEST_PRINT_DELAY = 30*1000;
	public static void main(String[] args) 
	{		
		new RandomTester().go();
	}

	private OutputWindow window;
	private SUT sut;
	private long[] actTrace;

	private void go() 
	{
		window = new OutputWindow(this.getClass().getName());
		sut = new SUT();
		println(String.format("%-65s " + "enabled:","Actions:"));
		println();
		for(int i = 0; i < sut.getActions().length; i++)
		{
			boolean enabled = sut.getActions()[i].enabled();
			String name = sut.getActions()[i].name().trim();
			println(String.format("%-65s " + enabled,name));
		}
		println("Initializing test...");
		long startTime = System.currentTimeMillis();
		int testCount = 0;
		int maxTests = MAX_TESTS;
		long timeout = TIMEOUT;
		long loopCount = 1;
		long printTime = 0;
		int actionCount = sut.getActions().length;
		while(timeInBounds(startTime, timeout))
		{
			sut.reset();
			actTrace = new long[maxTests];
			testCount = 0;
			boolean print = System.currentTimeMillis() - printTime > TEST_PRINT_DELAY;
			if(print)
			{
				println(">>Test Number " + loopCount);
				printTime = System.currentTimeMillis();
			}
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
					println(sut.getActions()[testNum].name().trim());
				String info = sut.getActions()[testNum].getAllInfo();
				boolean success = executeAct(sut.getActions()[testNum], info);
				if(!success)
					testFailed();
				else if (print && testCount +1==MAX_TESTS )
					println(info);
				testCount++;
			}
			loopCount++;
		}
		println("-Tested for " + ((System.currentTimeMillis()-startTime+0.0)/(1000+0)) + " seconds.");
		println("-Ran " + loopCount + " tests of " + maxTests +" actions.");
		println("-Final test only got to " + testCount + " actions.");
	}


	private void testFailed()
	{
		//TODO unimplemented

	}


	public boolean executeAct(Action action, String info)
	{
		try
		{
			action.act();
			String check = sut.check();
			if(check!= null)
			{
				throw new TstlException("Check failed! \"" + check + "\" failed to evaluate true!");						
			}
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			println("EXCEPTION!! Message: " + ex.getMessage());
			println("Heres the info: ");
			hasError(info);
			return false;
		}
	}
	public boolean executeAct(Action action)
	{
		return this.executeAct(action, action.getAllInfo());
	}


	private void hasError(String info) 
	{
		println(info);
		System.exit(-1);//temp
	}

	private void println() 
	{
		println("");
	}

	private void println(String string) 
	{
		window.println(string);
		System.out.println(string);		
	}

	private boolean timeInBounds(long startTime, long timeout) 
	{		
		return System.currentTimeMillis() - startTime < timeout;
	}
}
