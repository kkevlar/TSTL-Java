import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;


public class Temp {

	public static void printMyMap(HashMap<Repeatable, int[]> map) 
	{
		System.out.println("Map:");
		Repeatable[] reps = map.keySet().toArray(new Repeatable[map.size()]);
		for (int i = 0; i < reps.length; i++)
		{
			Temp.printMapElement(reps[i] + " > " + Arrays.toString(map.get(reps[i])));
		}
	}
	private static void printMapElement(String s)
	{
		System.out.println("Map- " + s);
	}
	

}
