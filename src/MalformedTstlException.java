
public class MalformedTstlException extends RuntimeException 
{

	private String message;

	public MalformedTstlException(String string) 
	{
		this.message = string;
	}
	@Override
	public String getMessage()
	{
		return message;
	}

}
