package logic.exception;

public class SpotNotFoundException extends Exception 
{

	private static final long serialVersionUID = 1L;
	
	public SpotNotFoundException(String address)
	{
		super("The entered location "+address+" doesn't match with any spot in the DB");
	}
	
	@Override
	public String toString()
	{
		return getMessage();
	}

}
