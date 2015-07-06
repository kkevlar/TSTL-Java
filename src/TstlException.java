
public class TstlException extends Exception {

	private String message;

	public TstlException(String string) 
	{
		message = string;
	}

	@Override
	public String getMessage() 
	{
		return message;
	}
}
