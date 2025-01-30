package com.Ecommerce.Qa.Utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter 
{
	@Test
	public static ExtentReports  generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter saprkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\Report.html");
		saprkReporter.config().setTheme(Theme.DARK);
		saprkReporter.config().setReportName("Ecommerce Test Automation Results");
		saprkReporter.config().setDocumentTitle("EC Automation Report");
		saprkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(saprkReporter);
		Properties prop = new Properties();
		try {
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Ecommerce\\Qa\\config\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL", prop.getProperty("Url"));
		extentReport.setSystemInfo("Browser Name",prop.getProperty("browserName"));
		extentReport.setSystemInfo("userName", "Srikanth Yadav");
		
		return extentReport;
		
		
		
	}

}
