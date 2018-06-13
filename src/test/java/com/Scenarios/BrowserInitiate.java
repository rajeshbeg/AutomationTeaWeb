package com.Scenarios;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BrowserInitiate {
	public static WebDriver driver= null;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest sublog;
// declear the path of data properties
	String path="C:\\Users\\rajesh\\git\\CucumberBDDSelenium\\src\\test\\java\\com\\Scenarios\\data.properties";
	@BeforeTest
	public ExtentReports setupReport()
	{
		// Initialize the Report and set the system info and set the Result info 
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
		// Existed report appended by this command 
		htmlreporter.setAppendExisting(true);
		
	// New Test will be displaed first
		
		
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "Automation Framework");
		extent.setSystemInfo("Environment", "Automation Test");
		extent.setSystemInfo("Tester Name", "Rajesh Beg");

		htmlreporter.config().setDocumentTitle("TEA WEb Automation");
		htmlreporter.config().setReportName("TEA WEB Automation Test Result");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.STANDARD);
		 return extent;
	}

	
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
			//System.setProperty("webdriver.chrome.driver","E:\\Google Drive\\chromedriver.exe");
			//driver= new InternetExplorerDriver();
		}
		return driver;

	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"-Test is Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- tset is failed", ExtentColor.RED));
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Tes case is skipped", ExtentColor.ORANGE));
		}
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
}

