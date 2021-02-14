package logic.exception;

public class ExistingEmailException extends Exception 
{

	private static final long serialVersionUID = 1L;
	
	public ExistingEmailException(String email)
	{
		super("The email address "+email+" is already used");
	}
	
	@Override
	public String toString()
	{
		return getMessage();	
	}

}
