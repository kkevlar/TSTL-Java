
public class TstlException extends Exception {

	private String message;

	public TstlException(String string) 
	{
		message = string;
	}

	public String getMessage() 
	{
		return message;
	}
}
