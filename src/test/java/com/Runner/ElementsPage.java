package com.Runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage {
	
	WebDriver driver;
	public ElementsPage()
	{
		this.driver=driver;
	}
	By Login =By.xpath("//a[@title='Log In']");

	
	public WebElement login()
	{
		
		return driver.findElement(Login);
		
	}
}
