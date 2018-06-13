package com.Scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Buttonsverify extends BrowserInitiate{

	@Test(priority=2)
	public void buttonverfiy()
	{
		logger=extent.createTest("TC1");
		sublog=logger.createNode("TC1-ButtonVerify");
		  Assert.assertTrue(driver.findElement(By.xpath(".//a[@id='wsb-button-00000000-0000-0000-0000-000450914890']")).isDisplayed());
		System.out.println("Button is displayed ");
		sublog.log(Status.PASS, MarkupHelper.createLabel("Button Verify is successfull", ExtentColor.GREEN));
//		extents.endTest(logger);
//		extents.flush();
		
		
	}
}
