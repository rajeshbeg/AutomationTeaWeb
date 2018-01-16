package com.Scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserInitiate {
public static WebDriver driver= null;
	String path="C:\\Users\\rajesh\\git\\CucumberBDDSelenium\\src\\test\\java\\com\\Scenarios\\data.properties";
	@Test
	public WebDriver setBrowser() throws IOException{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(path);
		prop.load(fis);
		String browser=prop.getProperty("browser");
		System.out.println(browser);
	if (browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\AutomationEnvironment\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver= new ChromeDriver(options);
	}
	else if(browser.equals("Firefox"))
	{
//		System.setProperty("webdriver.gecko.driver"," E:\\AutomationEnvironment\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browser.equals("IE"))
	{
		//System.setProperty("webdriver.chrome.driver"," E:\\Google Drive\\chromedriver.exe");
		//driver= new InternetExplorerDriver();
	}
	return driver;

}

}
