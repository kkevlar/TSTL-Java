import java.util.ArrayList;

public abstract class Tester 
{
	private SUTInterface sut;
	private ArrayList<Integer> actTrace;
	private int ignoreCheckValue = 0;
	private long testPrintDelay = 10000;
	private int testsPerCycle = 200;
	private long timeout = 60000 ;
	
	public void go() 
	{
		sut = new SUT();
		runTests(this.timeout,sut);
	}
	
	protected abstract void runTests(long timeout, SUTInterface sut);

	protected void testFailed()
	{
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test failed. Reducing....");
		TestReducer reducer = new TestReducer(sut, actTrace, this);
		int[] actionIds = reducer.getReducedTestIds();
		System.out.println("Test reduced. Heres all info.");
		for (int i = 0; i < actionIds.length; i++) 
		{
			String name = sut.getActions()[actionIds[i]].name();
			System.out.println(name.trim());
		}
		System.exit(-1);
	}


	protected boolean executeAct(boolean doCheck, Action action, boolean print)
	{
		try
		{
			action.act();
			
			String check = sut.check();
			if(check != null)
			{
				throw new TstlException("Check failed! \"" + check + "\" failed to evaluate true!");
			}
			return true;
		}
		catch(Exception ex)
		{
			if(print)
			{
				ex.printStackTrace();
				println("EXCEPTION!! Message: " + ex.getMessage());
			}
			return false;
		}
	}

	protected void clearActTrace() 
	{
		actTrace = new ArrayList<Integer>();		
	}

	protected void println(String string) 
	{
		System.out.println(string);		
	}
	public int getIgnoreCheckValue() 
	{
		return ignoreCheckValue;
	}
	public void setIgnoreCheckValue(int ignoreCheckValue) 
	{
		this.ignoreCheckValue = ignoreCheckValue;
	}

	public long getTestPrintDelay() {
		return testPrintDelay;
	}

	public void setTestPrintDelay(long testPrintDelay) {
		this.testPrintDelay = testPrintDelay;
	}

	public int getTestsPerCycle() {
		return testsPerCycle;
	}

	public void setTestsPerCycle(int testsPerCycle) {
		this.testsPerCycle = testsPerCycle;
	}
	protected void addToActTrace(int id)
	{
		actTrace.add(id);
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
}
