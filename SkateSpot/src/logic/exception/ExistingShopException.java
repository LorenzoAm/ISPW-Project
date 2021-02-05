package logic.exception;

public class ExistingShopException extends Exception 
{

		private static final long serialVersionUID = 1L;

		public ExistingShopException()
		{
			super(" Some data entered for the shop already exist in the DB ! ");
		}
		
		@Override
		public String toString()
		{
			return getMessage();
		}
}
