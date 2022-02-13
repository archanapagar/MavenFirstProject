package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TestCase passed with name" +result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TestCase failed with name" +result.getName());
		test.addScreenCaptureFromPath(captureScreenshot(result.getName()));
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "TestCase skipped with name" +result.getName());
	}
	
	public void onFinish(ITestContext arg0) {
	
		
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

}
