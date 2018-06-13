package scenarioTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectMenu {
	
	@Test
		public void setBrowser(){
			System.setProperty("webdriver.chrome.driver","E:\\Google Drive\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			// Disable to Extension
			options.addArguments("--disable-extensions");
			// Maximize the Page
			options.addArguments("--start-maximized");
			WebDriver driver= new ChromeDriver(options);
		
		       // Set URL
					driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
					//Wait for loading the page 
					driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
					// Slect Object for Drop Down Menu
					Select Menu = new Select(driver.findElement(By.id("select-demo")));
					Menu.selectByIndex(4);

}
}