import java.io.File;
import java.util.ArrayList;

public abstract class Tester 
{
	private SUTInterface sut;
	private ArrayList<Integer> actTrace;
	private int ignoreCheckValue = TstlConstants.TESTER_CONFIG_DEFAULT_IGNORE_CHECK_VALUE;
	private long testPrintDelay = TstlConstants.TESTER_CONFIG_DEFAULT_TEST_PRINT_DELAY;
	private int testsPerCycle = TstlConstants.TESTER_CONFIG_DEFAULT_TESTS_PER_CYCLE;
	private long timeout = TstlConstants.TESTER_CONFIG_DEFAULT_TIMEOUT ;
	private boolean shouldAppendFailingTest = TstlConstants.TESTER_CONFIG_DEFAULT_APPEND_FAILING_TEST;
	private FlushWriter logWriter;
	private FlushWriter reduceWriter;

	public void go() 
	{
		try
		{
			File logFile = new File(TstlConstants.getPath(TstlConstants.PATHKEY_TESTER_OUTPUT_LOG));
			logFile.createNewFile();
			logWriter = new FlushWriter(logFile);
		}
		catch(Exception ex)
		{

		}
		sut = new SUT();
		runTests(sut);
		if(reduceWriter != null)
			logWriter.close();
		if(reduceWriter != null)
			reduceWriter.close();
	}
	
	protected abstract void runTests(SUTInterface sut);

	protected void testFailed()
	{
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rprintln("test failed. Reducing....");
		TestReducer reducer = new BinaryTestReducer(sut, actTrace, this);
		int[] actionIds = reducer.getReducedTestIds();
		rprintln("Test reduced. Heres main line of each step.");
		for (int i = 0; i < actionIds.length; i++) 
		{
			String name = sut.getActions()[actionIds[i]].name();
			rprintln(name.trim());
		}
		//smart test reducer currently is unused.
	}
	
	private void rprintln(String string)
	{
		println(string);
		if(reduceWriter == null)
		{
			try
			{
				File reduceFile = new File(TstlConstants.getPath(TstlConstants.PATHKEY_TESTER_REDUCE_LOG)); 
				reduceFile.createNewFile();
				reduceWriter = new FlushWriter(reduceFile);
			}
			catch(Exception ex)
			{

			}
		}
		if(reduceWriter != null)
			reduceWriter.println(string);
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
		logWriter.println(string);
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
	public boolean shouldAppendFailingTest() {
		return shouldAppendFailingTest;
	}
	public void setShouldAppendFailingTest(boolean shouldAppendFailingTest) {
		this.shouldAppendFailingTest = shouldAppendFailingTest;
	}
	
}
