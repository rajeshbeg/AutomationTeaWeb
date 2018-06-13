package com.Scenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SearchLinkText extends BrowserInitiate{
	@Test(priority=3)
	public void serchtext()
	{
		sublog=logger.createNode("TC1-Search Text");
		System.out.println("Search text pass");
		sublog.log(Status.PASS, MarkupHelper.createLabel("Serch text is pass", ExtentColor.GREEN));
	}

}
