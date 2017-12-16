package com.StepDefinitions;

//import org.junit.Assert;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

//import com.cucumber.PageObjects.LoginPageObj;

public class CommonMethods {

//	public static WebDriver driver = null;
//	public static WebDriverWait waitVar = null;
//	public static final String baseURL = "http://www.moneycontrol.com/portfolio_plus/sso/portfolio_signup.php";
	
//	LoginPageObj LogPgobj = new LoginPageObj (); // Import page objects from page object class
	
	public void Insert_Textbox(WebElement element, String inputtext) {
		
		element.sendKeys(inputtext);
		element.sendKeys(Keys.TAB);
		String textinserted = element.getAttribute("value");
		
		if(inputtext.equals(textinserted)) {
			System.out.println("Text Sucessfully Inserted");
		}
		else{
			System.out.println("Text NOT Sucessfully Inserted");
		}
			
		Assert.assertEquals(inputtext, textinserted);
		
		
		
		System.out.println("string text :"+ textinserted);
		System.out.println("TEST");
//		System.out.println("Sucessfull: "+password);
//		WebElement signinBtnElement=driver.findElement(LogPgobj.LoginLink);
//		driver.findElement(By.id("password")).sendKeys(password);
		
	}

	private void If(boolean equalsIgnoreCase) {
		// TODO Auto-generated method stub
		
	}

}