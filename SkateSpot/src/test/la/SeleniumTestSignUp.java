package test.la;

import static org.junit.Assert.assertEquals;



import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.entities.dao.UserDAO;

public class SeleniumTestSignUp 
{
	static final String NOME="Prova";
	static final String COGNOME="Selenium";
	static final String USERNAME="provaSel";
	static final String EMAIL="prova.selenium@gmail.com";
	static final String PASSWORD="password";
	
	static final String PROVA="Account created correctly!";
	
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//apro sito
		driver.get("http://localhost:8081/SkateSpot/pages/index.jsp");
		//vado su SignUp
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[7]/table/tbody/tr[4]/td/a/img")).click();	
		//Inserisco dati
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(NOME);
		driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(COGNOME);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"data\"]")).sendKeys("22/11/2000");
		WebElement radio1 = driver.findElement(By.id("maleButton"));
		radio1.click();		
		WebElement radio2 = driver.findElement(By.id("skaterButton"));
		radio2.click();
		//clicco su sign Up
		driver.findElement(By.xpath("/html/body/div[2]/form/input[12]")).click();	
		//verifico inserimento dello user nel db
		WebElement txtBoxContent = driver.findElement(By.xpath("/html/body/h2"));
		assertEquals(PROVA,txtBoxContent.getText());
		driver.close();
	}
	@After
	public void tearDown() 
	{		
		UserDAO.deleteUser(EMAIL,PASSWORD);		
	}
}
