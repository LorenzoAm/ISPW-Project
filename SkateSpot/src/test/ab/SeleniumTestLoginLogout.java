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

public class SeleniumTestLoginLogout {
	static final String EMAIL="prova.selenium@gmail.com";
	static final String PASSWORD="password";
	static final String STREET="provaselenium";
	static final String NUMBER="1";
	static final String CITY="provaselenium";
	static final String PROVA="Welcome back Prova !";
	static final String PROVA2="Logout completed, see you soon !";
	
	@Before
	public void init()
	{
		SignUpBean bean= new SignUpBean("Prova","Selenium",STREET,EMAIL,PASSWORD,PASSWORD);
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
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("/html/body/div[2]/form/input[3]")).click();
		//verifico
		WebElement txtBoxContent = driver.findElement(By.xpath("/html/body/h2"));
		assertEquals(PROVA,txtBoxContent.getText());
		//torno homepage
		driver.findElement(By.xpath("/html/body/div/a/img")).click();
		//eseguo logout
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[7]/table/tbody/tr[2]/td/a/img")).click();
		//verifico logout eseguito
		WebElement txtBoxContent2 = driver.findElement(By.xpath("/html/body/h2"));
		assertEquals(PROVA2,txtBoxContent2.getText());
		driver.close();
	}
	@After
	public void tearDown() 
	{		
		UserDAO.deleteUser(EMAIL,PASSWORD);		
	}
			

}
