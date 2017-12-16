package com.StepDefinitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumFunctions {

	public static WebDriver driver = null;
	public static WebDriverWait waitVar = null;
	public static final String baseURL = "http://www.moneycontrol.com/portfolio_plus/sso/portfolio_signup.php";
	
//	LoginPageObj LogPgobj = new LoginPageObj (); // Import page objects from page object class
//	CommonMethods CmnMtdobj = new CommonMethods();
	
	public void createDriver() throws MalformedURLException,InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		
		waitVar = new WebDriverWait(driver, 15);
	}
	
	public void teardown() {
//		driver.quit();
	}
	
	public void isLoginpageDisplayed() {
//		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='login']/div[2]/div[5]/p[1]/input")));
		
//		WebElement LoginButton = LogPgobj.LoginButton;
//		waitVar.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) LoginButton));
//		driver.
//		System.out.println("Login button display: "+ driver.findElement(By.id("login")).isDisplayed());
		
//		System.out.println("Login button display: "+ LogPgobj.LoginButton.isDisplayed());
	}
	
	public void enterUserID(String userid) {
		driver.findElement(By.id("login_id")).sendKeys(userid);
		
//		WebElement txtuserid = LogPgobj.txtuserid;
//		CmnMtdobj.Insert_Textbox(txtuserid, userid);
	}
	
	public void enterPassword(String password) {
//		driver.findElement(By.id("password")).sendKeys(password);
		
//		WebElement txtpassword = driver.findElement(LogPgobj.Password);
//		txtpassword.sendKeys(password);
		
//		WebElement txtpassword = LogPgobj.txtpassword;
//		CmnMtdobj.Insert_Textbox(txtpassword, password);
	}
	
	public void clickLoginButton() {
//		driver.findElement(By.xpath(".//*[@id='login']/div[2]/div[5]/p[1]/input")).click();
//		WebElement signinBtnElement = driver.findElement(LogPgobj.LoginButton);
//		signinBtnElement.click();
	}
	
	public void isUserLoggedIn() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/center[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/form/div/select")));
		Select select = new Select(driver.findElement(By.xpath("html/body/center[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/form/div/select")));
		select.selectByIndex(2);
		
	}

}