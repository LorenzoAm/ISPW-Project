package test.ab;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import logic.beans.LoginBean;
import logic.beans.SignUpBean;
import logic.beans.SpotBean;
import logic.controllers.LoginController;
import logic.controllers.SignUpController;
import logic.entities.dao.SpotDAO;
import logic.entities.dao.UserDAO;
import logic.exception.ExistingEmailException;
import logic.beans.JoinSpotBean;



public class BeanUserTest 
{
	static final String email="prova.selenium@gmail.com";
	static final String password="password";
	@Before
	public void init()
	{
		SignUpBean bean= new SignUpBean("Prova","Selenium","provaselenium",email,password,password);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2000";
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		bean.control(localDate,"M","Skater");
		try 
		{
			SignUpController.getInstance().signUp(bean);
		} 
		catch(ExistingEmailException e)
		{
			e.printStackTrace();
		}
		LoginBean beanL = new LoginBean(email,password);
		LoginController.getInstance().login(beanL);
		
		SpotBean beanS = new SpotBean("provaJUnit", "provaJUnit", "1", "provaJUnit", "provaJUnit","provaJUnit");//costruttore
        beanS.control("Skateapark", "provaJUnit");
	}
	@Test
	public void testNumberOfSkaters()
	{
		int numberSkaters=SpotDAO.NumberOfSkaters("provaJUnit", "provaJUnit", 1);
		assertEquals(0,numberSkaters);
	}
	
	@Test
	public void testLoginBean()
	{
		LoginBean bean = new LoginBean("email@gmail.com","password");
		assertEquals(true,bean.check());
	}
	
	@Test
	public void TestJoinSpotBean()
	{
		JoinSpotBean bean = new JoinSpotBean("street","12","city");
		assertEquals(true,bean.check());
	}
	
	@After
	public void tearDown() 
	{		
		UserDAO.deleteUser(email,password);		
	}
}
