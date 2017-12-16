package com.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObj {
	
	public static WebDriver driver = null;
//	SeleniumFunctions sFun =  new SeleniumFunctions() ;
	
	public WebElement LoginButton = driver.findElement(By.xpath(".//*[@id='login']/div[2]/div[5]/p[1]/input"));
	
	public WebElement txtuserid = driver.findElement(By.id("login_id"));
	
	public WebElement txtpassword = driver.findElement(By.id("password"));
//	public By PasswordEdit = By.id("password");	
	
}
