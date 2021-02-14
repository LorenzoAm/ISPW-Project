package logic.exception;

public class ExistingSpotException extends Exception 
{

	private static final long serialVersionUID = 1L;
	
	public ExistingSpotException() 
	{
		super(" Some data entered for the spot already exist in the DB ! ");
	}
	
	@Override
	public String toString()
	{
		return getMessage();
	}

}
