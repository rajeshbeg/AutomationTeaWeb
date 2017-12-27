package com.Scenarios;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends BrowserInitiate {
	
	public static Object[][] dataMap = null;
	public Properties pro= null; 
	WebDriver driver; 
	
	@Test(priority=1)
	public void setUrl() throws IOException
	{
	driver=setBrowser();
	driver.get("http://www.moneycontrol.com/");
	}
	@Test(priority=2)
	public void Loginclick() throws IOException
	{
	driver.findElement(By.xpath("//a[@title='Log In']")).click();
	//enter user name and password
	WebElement x = driver.findElement(By.xpath("html/body/div[7]/div/div/div/button"));
	x.click();
	driver.findElement(By.xpath("//div[@class='formbox']/div[1]/form/div[1]")).click();
	driver.findElement(By.xpath("//div[@class='formbox']/div[1]/form/div[1]")).sendKeys("mirjarajesh@gmail.com");
	driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Rajesh@1992");
	//click on Login 
	driver.findElement(By.xpath("//button[@onclick='api_call('/login/index/', 'login_form')']")).click();
	}
		
//  @DataProvider
//  public Object[][]getData()
//  {  
////	  Object[][]data=new Object[2][2];
////	  data[0][0]="rajesh@indusos.com";
////	  data[0][1]="12345";
////	  
////	  data[1][0]="rajesh@indusos.com";
////	  data[1][1]="12345";
//	  
//return dataMap;
//	  
//  }
  
}
