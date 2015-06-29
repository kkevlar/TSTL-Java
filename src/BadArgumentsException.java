
public class BadArgumentsException extends RuntimeException 
{
	private String message;
	public BadArgumentsException(String message)
	{
		this.message = message; 
	}
	@Override
	public String getMessage()
	{
		return "BadArgunmentsException: " + message;	
	}
}
