package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtilities;

public class BaseClass {

	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark;
	public static ExtentTest test = null;
	
	// this class should have all common code
	public void initialization()//driver intialization
	{
		String browser = PropertiesUtilities.readproperty("browser"); //used to read browser name
	
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		/*if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver = new FirefoxDriver();
		
	}*/
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(PropertiesUtilities.readproperty("url"));
	}
	
	public void reportInit(){
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}
	
	public String captureScreenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/" +name+".jpg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
		
	}
}
