package test.ab;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.beans.SignUpBean;
import logic.controllers.SignUpController;
import logic.entities.dao.UserDAO;
import logic.exception.ExistingEmailException;

public class SeleniumTestLogin {
	static final String email="prova.selenium@gmail.com";
	static final String password="password";
	static final String street="provaselenium";
	static final String number="1";
	static final String city="provaselenium";
	static final String prova="Welcome back Prova !";
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
		
	}
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//apro sito
		driver.get("http://localhost:8081/SkateSpot/pages/index.jsp");
		//apro login
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[7]/table/tbody/tr[2]/td/a/img")).click();
		//inserisco daati
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div[2]/form/input[3]")).click();
		//verifico
		WebElement txtBoxContent = driver.findElement(By.xpath("/html/body/h2"));
		assertEquals(prova,txtBoxContent.getText());
		
		driver.close();
	}
	@After
	public void tearDown() 
	{		
		UserDAO.deleteUser(email,password);		
	}
			

}
