
public class BadArgumentsException extends RuntimeException 
{
	private String message;
	public BadArgumentsException(String message)
	{
		this.message = message;
	}
	public BadArgumentsException(String argType, String problem)
	{
		this.message = "Argument \"" + argType + "\" is " + problem + "."; 
	}
	public String getMessage()
	{
		return "BadArgunmentsException: " + message;	
	}
}
