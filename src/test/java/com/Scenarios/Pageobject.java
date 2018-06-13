package com.Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pageobject {

	WebDriver driver ;
	public Pageobject(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement username(){
		By username=By.xpath("//form[@id='login_form']//input[@class='textfield' and @id='email']");
		return driver.findElement(username);	
	}
	public WebElement password(){
		By password=By.xpath("//form[@id='login_form']//input[@class='textfield' and @id='pwd']");
		return driver.findElement(password);	

	}

	public WebElement submit() {
		// TODO Auto-generated method stub
		By Submit= By.xpath(".//*[@id='submit'][@class='signingraybg btn-lrg-green']");
		return driver.findElement(Submit);	
	}
	public WebElement loginoption() {
		// TODO Auto-generated method stub
		By loginoption=By.xpath("//a[@title='Log In']");
		return driver.findElement(loginoption);	
		
	}
}



