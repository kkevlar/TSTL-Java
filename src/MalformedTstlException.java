
public class MalformedTstlException extends RuntimeException 
{

	private String message;

	public MalformedTstlException(String string) 
	{
		this.message = string;
	}
	public String getMessage()
	{
		return message;
	}

}
