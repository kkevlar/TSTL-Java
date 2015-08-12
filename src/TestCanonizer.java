import java.util.ArrayList;


public class TestCanonizer extends TestManipulator {

	public TestCanonizer(SUTInterface sut, int[] actTraceArray, Tester tester2) 
	{
		super(sut, actTraceArray, tester2);
	}

	public TestCanonizer(SUTInterface sut, ArrayList<Integer> actTrace,Tester tester)
	{
		super(sut, actTrace, tester);

	}

	@Override
	public void manipulateTest() 
	{
		// TODO Auto-generated method stub

	}

}
