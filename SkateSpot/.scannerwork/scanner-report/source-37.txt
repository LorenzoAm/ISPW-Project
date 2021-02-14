package logic.exception;

public class FullSpotException extends Exception 
{

	private static final long serialVersionUID = 1L;

	public FullSpotException(String name) 
	{
		super("The spot "+name+" is full at the moment !");
	}
	
	@Override
	public String toString()
	{
		return getMessage();
	}
}
