
public class RandomTester extends Tester
{

	@Override
	protected void runTests(long timeout, SUTInterface sut) 
	{
		long startTime = System.currentTimeMillis();
		long testCount = 0;
		long loopCount = 0;
		long lastPrintTime = 0;
		while(System.currentTimeMillis() - startTime < timeout)
		{
			sut.reset();
			clearActTrace();
			testCount = 0;
			boolean print = System.currentTimeMillis() - lastPrintTime > getTestPrintDelay();
			if(print)
			{
				println(">>Test Number " + loopCount);
				lastPrintTime = System.currentTimeMillis();
			}
			while(testCount<getTestsPerCycle() && System.currentTimeMillis() - startTime < timeout)
			{
				boolean enabled = false;
				int testNum = -1;
				while(!enabled && System.currentTimeMillis() - startTime < timeout)
				{
					testNum = (int) (Math.random() * sut.getActions().length);
					enabled = sut.getActions()[testNum].enabled();
				}
				if(print)
					println(sut.getActions()[testNum].name().trim());
				String info = sut.getActions()[testNum].getAllInfo();
				addToActTrace(sut.getActions()[testNum].id());
				boolean success = executeAct(this.getIgnoreCheckValue() < 2, sut.getActions()[testNum], true);
				if(!success)
					testFailed();
				else if (print && testCount +1==getTestsPerCycle())
					println(info);
				testCount++;
			}
			loopCount++;
		}
		println("-Tested for " + ((System.currentTimeMillis()-startTime+0.0)/(1000+0)) + " seconds.");
		println("-Ran " + loopCount + " tests of " + getTestsPerCycle() +" actions.");
		println("-Final test only got to " + testCount + " actions.");
		
	}

	
	
	
}
