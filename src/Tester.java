import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Tester 
{
	private static final int TESTER_CONFIG_DEFAULT_TIMEOUT = 60000;
	private static final int TESTER_CONFIG_DEFAULT_TESTS_PER_CYCLE = 1000;
	private static final int TESTER_CONFIG_DEFAULT_TEST_PRINT_DELAY = 10000;
	private static final int TESTER_CONFIG_DEFAULT_IGNORE_CHECK_VALUE = 0;
	private SUTInterface sut;
	private ArrayList<Integer> actTrace;
	private int ignoreCheckValue = TESTER_CONFIG_DEFAULT_IGNORE_CHECK_VALUE;
	private long testPrintDelay = TESTER_CONFIG_DEFAULT_TEST_PRINT_DELAY;
	private int testsPerCycle = TESTER_CONFIG_DEFAULT_TESTS_PER_CYCLE;
	private long timeout = TESTER_CONFIG_DEFAULT_TIMEOUT ;
	
	public void go() 
	{
		readConfiguration();
		sut = new SUT();
		runTests(sut);
	}
	
	private void readConfiguration() 
	{
		File configFile = new File(TstlConstants.FILE_TESTER_CONFIG);
		if(configFile.exists())
		{
			ArrayList<String> lines = new ArrayList<String>();
			Scanner scan = null;
			try {
				scan = new Scanner(configFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(scan.hasNextLine())
			{
				lines.add(scan.nextLine());
			}
			HashMap<String,String> map = new HashMap<String,String>();
			for(int i = 0; i < lines.size(); i++)
			{
				String name;
				String value;
				String line = lines.get(i);
				line = line.replace(":", "~");
				name = line.split("~")[0].trim();
				value = line.split("~")[1].trim();
				map.put(name, value);
			}
			ignoreCheckValue = Integer.parseInt(map.get(TstlConstants.LABEL_CONFIG_IGNORE_CHECK_VALUE));
			testPrintDelay = Long.parseLong(map.get(TstlConstants.LABEL_CONFIG_TEST_PRINT_DELAY));
			testsPerCycle = Integer.parseInt(map.get(TstlConstants.LABEL_CONFIG_TESTS_PER_CYCLE));
			timeout = Long.parseLong(map.get(TstlConstants.LABEL_CONFIG_TIMEOUT));
		}
	}

	protected abstract void runTests(SUTInterface sut);

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
