package com.jbk.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.utility.PropertiesUtilities;

public class LoginTest extends BaseClass {
	
	@BeforeSuite
	public void setup()
	{
		initialization();
		reportInit();
		
	}
	
	@AfterSuite
	public void tearDown()
		{
			report.flush();//this method used to save extent report
		}
	
	
	@Test(priority=1)
	public void LoginTest()
	{
		driver.findElement(By.id("email")).sendKeys(PropertiesUtilities.readproperty("username"));
		driver.findElement(By.id("password")).sendKeys(PropertiesUtilities.readproperty("password"));
		driver.findElement(By.xpath("//button")).click();
		
	}
	
	@Test(priority=2)
	public void failTest()
	{
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}

}
