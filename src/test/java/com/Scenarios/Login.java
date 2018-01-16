package com.Scenarios;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Login extends BrowserInitiate {

	//	public static Object[][] dataMap = null;
	//	public Properties pro= null; 
	WebDriver driver;
	

	@Test(priority=1)
	public void setUrl() throws IOException
	{
		
		driver=setBrowser();
		driver.get("http://www.moneycontrol.com/");
		//driver.get("http://www.moneycontrol.com/");
	}
	@Test(priority=2)
	@Parameters({ "Username","Password"})
	public void Loginclick(String Username,String Password) throws IOException, InterruptedException
	{
		Pageobject po= new Pageobject(driver);
		
		po.loginoption().click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://accounts.moneycontrol.com/mclogin/?d=2']")));
		po.username().sendKeys(Username);
		po.password().sendKeys(Password);

		//click on Login 
		po.submit().click();
	}

}
//@DataProvider
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
