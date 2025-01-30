package com.Ecommerce.Qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Ecommerce.Qa.Utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class MyListeners implements ITestListener
{
	ExtentReports extentReport;
	ExtentTest extentTest ;
	String testName ;
	
	@Override
	public void onStart(ITestContext context) 
	{
		extentReport=ExtentReporter.generateExtentReport();
		
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		testName=result.getName();
		extentTest=extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+"----started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
	
		extentTest.log(Status.PASS, testName+"----got succesfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		WebDriver driver =null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		File desFile = new File(destinationScreenshotPath);
		sourceFile.renameTo(desFile);
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+"----got Failed");
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"---got skipped");
		
	}



	@Override
	public void onFinish(ITestContext context) 
	{
		extentReport.flush();
		
		String path=System.getProperty("user.dir")+"\\test-output\\ExtentReport\\Report.html";
		
		try {
			Desktop.getDesktop().browse(new File(path).toURI());
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}


}
