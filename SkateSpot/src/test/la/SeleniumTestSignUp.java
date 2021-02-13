package test.la;

import static org.junit.Assert.assertEquals;



import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.entities.dao.UserDAO;

public class SeleniumTestSignUp {
	static final String nome="Prova";
	static final String cognome="Selenium";
	static final String username="provaSel";
	static final String email="prova.selenium@gmail.com";
	static final String password="password";
	
	static final String prova="Account created correctly!";
	
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
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(nome);
		driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(cognome);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"data\"]")).sendKeys("22/11/2000");
		WebElement radio1 = driver.findElement(By.id("maleButton"));
		radio1.click();		
		WebElement radio2 = driver.findElement(By.id("skaterButton"));
		radio2.click();
		//clicco su sign Up
		driver.findElement(By.xpath("/html/body/div[2]/form/input[12]")).click();	
		//verifico inserimento dello user nel db
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
