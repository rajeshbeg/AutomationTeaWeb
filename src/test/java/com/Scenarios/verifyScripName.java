package com.Scenarios;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class verifyScripName extends BrowserInitiate{
	@Test
	public void g()
	{
	 System.out.println("Script verified");
	 
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		System.out.println("Now logout the page");
	}

}
