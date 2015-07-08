import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Tester 
{
	private SUTInterface sut;
	private ArrayList<Integer> actTrace;
	private int ignoreCheckValue = TstlConstants.TESTER_CONFIG_DEFAULT_IGNORE_CHECK_VALUE;
	private long testPrintDelay = TstlConstants.TESTER_CONFIG_DEFAULT_TEST_PRINT_DELAY;
	private int testsPerCycle = TstlConstants.TESTER_CONFIG_DEFAULT_TESTS_PER_CYCLE;
	private long timeout = TstlConstants.TESTER_CONFIG_DEFAULT_TIMEOUT ;
	private boolean shouldAppendFailingTest = TstlConstants.TESTER_CONFIG_DEFAULT_APPEND_FAILING_TEST;

	public void go() 
	{
		readConfiguration();
		sut = new SUT();
		runTests(sut);
	}

	private void readConfiguration() 
	{
		File configFile = null;
		try {
			configFile = new File(TstlConstants.getThisJarDir() + "/" + TstlConstants.FILE_TESTER_CONFIG);
		} catch (URISyntaxException e1) {
			configFile = new File(TstlConstants.FILE_TESTER_CONFIG);
		}
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
			String val = map.get(TstlConstants.LABEL_CONFIG_IGNORE_CHECK_VALUE);
			if(val != null)
				ignoreCheckValue = Integer.parseInt(val);
			val = map.get(TstlConstants.LABEL_CONFIG_TEST_PRINT_DELAY);
			if(val != null)
				testPrintDelay = Long.parseLong(val);
			val = map.get(TstlConstants.LABEL_CONFIG_TESTS_PER_CYCLE);
			if(val != null)
				testsPerCycle = Integer.parseInt(val);
			val = map.get(TstlConstants.LABEL_CONFIG_TIMEOUT);
			if(val != null)
				timeout = Long.parseLong(val);
			val = map.get(TstlConstants.LABEL_CONFIG_APPDEND_FAILING_TEST);
			if(val != null)
				this.shouldAppendFailingTest = Boolean.parseBoolean(val);
		}
		else
		{
			HashMap<String,String> map = new HashMap<String,String>();
			map.put(TstlConstants.LABEL_CONFIG_IGNORE_CHECK_VALUE, ignoreCheckValue+"");
			map.put(TstlConstants.LABEL_CONFIG_TEST_PRINT_DELAY, testPrintDelay+"");
			map.put(TstlConstants.LABEL_CONFIG_TESTS_PER_CYCLE, testsPerCycle+"");
			map.put(TstlConstants.LABEL_CONFIG_TIMEOUT, timeout+"");
			String[] names = map.keySet().toArray(new String[map.size()]);
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(configFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < names.length; i++)
			{
				String name;
				String value;
				name = names[i];
				value = map.get(names[i]);
				writer.println(name + ":" + value);
			}
			writer.flush();
			writer.close();			
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
		reducer.setShouldAppendFailingTest(shouldAppendFailingTest );
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
