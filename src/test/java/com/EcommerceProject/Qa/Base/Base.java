package com.EcommerceProject.Qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.Ecommerce.Qa.Utils.Utils;

public class Base 
{
	public WebDriver driver;
	public Properties prop;
	
	public  Base() 
	{
		prop=new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Ecommerce\\Qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName)
	{
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.implicitWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.pageLoadTimeOut));
		driver.get(prop.getProperty("Url"));
		
		return driver;
	}
	

}
