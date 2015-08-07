
public class RandomTester extends Tester
{
	@Override
	protected void runTests(SUTInterface sut) 
	{
		long startTime = System.currentTimeMillis();
		long testCount = 0;
		long loopCount = 0;
		long lastPrintTime = 0;
		while(System.currentTimeMillis() - startTime < getTimeout())
		{
			sut.reset();
			clearActTrace();
			testCount = 0;
			boolean print = System.currentTimeMillis() - lastPrintTime > getTestPrintDelay() && this.getTestPrintDelay() > -1;
			if(print)
			{
				println(">>Test Number " + loopCount);
				lastPrintTime = System.currentTimeMillis();
			}
			while(testCount<getTestsPerCycle() && System.currentTimeMillis() - startTime <getTimeout())
			{
				boolean enabled = false;
				int testNum = -1;
				while(!enabled && System.currentTimeMillis() - startTime < getTimeout())
				{
					testNum = (int) (Math.random() * sut.getActions().length);
					enabled = sut.getActions()[testNum].enabled();
				}
				if(testNum == -1)
					continue;
				if(print)
					println(sut.getActions()[testNum].tstlStyleOutput().trim());
				addToActTrace(testNum);
				boolean success = executeAct(this.getIgnoreCheckValue() < 2, sut.getActions()[testNum], true);
				if(!success)
				{
					testFailed();
					return;
				}
				
				testCount++;
			}
			loopCount++;
		}
		println("-Tested for " + ((System.currentTimeMillis()-startTime+0.0)/(1000+0)) + " seconds.");
		println("-Ran " + loopCount + " tests of " + getTestsPerCycle() +" actions.");
		println("-Final test only got to " + testCount + " actions.");
		
	}

	
	
	
}
