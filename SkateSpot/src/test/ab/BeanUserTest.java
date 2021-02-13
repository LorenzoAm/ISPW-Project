package test.ab;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import logic.beans.LoginBean;
import logic.beans.JoinSpotBean;



public class BeanUserTest 
{
	@Test
	public void testLoginBean()
	{
		LoginBean bean = new LoginBean("email@gmail.com","password");
		assertEquals(true,bean.check());
	}
	
	@Test
	public void joinSpotBean()
	{
		JoinSpotBean bean = new JoinSpotBean("street","12","city");
		assertEquals(true,bean.check());
	}
	
	
}
