
public class RandomTester 
{

	public static void main(String[] args) 
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
	}
}
