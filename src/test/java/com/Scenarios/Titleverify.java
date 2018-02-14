package com.Scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//public class Titleverify extends BrowserInitiate{
//	WebDriver driver;
//	@Test(priority=1)
//	public void Title() throws IOException{
//		driver=setBrowser();
//		driver.get("http://gmail.com");
//		System.out.println("title is Welcome");
//	}
//	@Test(priority=1)
//	public void Title1() throws IOException{
//		driver=setBrowser();
//		logger=extent.createTest("TC1-Title verify");
//		driver.get("http://www.practiceselenium.com/");
//		System.out.println("title2 is Welcome");
//		logger.log(Status.PASS, MarkupHelper.createLabel("Browser set up successfull", ExtentColor.BLUE));
//	}
//}
	
//}


public class Titleverify extends BrowserInitiate {

	WebDriver driver;
	

	@BeforeTest
	public void setUrl() throws IOException
	{
     logger = extent.createTest("TC1-");
     
		driver=setBrowser();
		
		driver.get("http://www.practiceselenium.com/");

		logger.log(Status.PASS, MarkupHelper.createLabel("Browser setup successfull",ExtentColor.BLUE));
		
	}
@Test(priority=2)
	public void Title() throws IOException, InterruptedException
	{
//		Pageobject po= new Pageobject(driver);
		
		sublog=logger.createNode("TC1-Title verify");
		
		try{
			
	  String title =driver.getTitle();
	  System.out.println("Webpage tiltle: "+title);
		
//		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://accounts.moneycontrol.com/mclogin/?d=2']")));

		
		
	sublog.log(Status.PASS, MarkupHelper.createLabel(" Grab Title test pass ", ExtentColor.GREEN));
	  
		}catch(Exception e){
			System.out.println("Unable to find the element"+e);
		}
	}
}
