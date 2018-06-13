package com.Scenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Linkverify extends BrowserInitiate{
	@Test(priority=4)
	public void linkverify()
	{
		sublog=logger.createNode("TC1-Link verify");
		System.out.println("Link verify pass");
        sublog.log(Status.FAIL, MarkupHelper.createLabel("Link verify is Fail", ExtentColor.RED));

	}

}
