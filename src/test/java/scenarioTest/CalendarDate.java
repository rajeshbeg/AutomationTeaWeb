package scenarioTest;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarDate {
	private WebDriver driver;
	@BeforeTest
	public void calendarTest(){
	System.setProperty("webdriver.chrome.driver","E:\\Google Drive\\chromedriver.exe");
	ChromeOptions options= new ChromeOptions();
	// Disable to Extension
	options.addArguments("--disable-extensions");
	// Maximize the Page
	options.addArguments("--start-maximized");
	driver= new ChromeDriver(options);

       // Set URL
			driver.get("https://play.google.com/store/apps/collection/promotion_3000791_new_releases_games?clp=SiwKKgokcHJvbW90aW9uXzMwMDA3OTFfbmV3X3JlbGVhc2VzX2dhbWVzEAcYAw%3D%3D:S:ANO1ljJAzZo");
			//Wait for loading the page 
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			System.out.println(driver.getTitle());
			
}
	
	@Test(priority=1)
	public void Test1(){
	//first  find out the title of App name 
	List<WebElement> urls=driver.findElements(By.xpath(".//*[@id='body-content']/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/a[2]"));
	int NumofApp=urls.size();	
	for (int i=0;i<urls.size();i++){
		System.out.println(urls.get(i).getText());
	}
	}
	
	@Test(priority=2)
	public void Test2(){
		
	}
	
}