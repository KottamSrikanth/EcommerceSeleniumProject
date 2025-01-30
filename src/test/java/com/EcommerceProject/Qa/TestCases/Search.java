package com.EcommerceProject.Qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Ecommerce.Qa.pageObjects.HomePage;
import com.Ecommerce.Qa.pageObjects.SearchPage;
import com.EcommerceProject.Qa.Base.Base;

public class Search extends Base
{
	public WebDriver driver;
	
	public Search()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithAnExistingProduct()
	{
		HomePage hp = new HomePage(driver);
		hp.enterProductNameIntoSearchBoxField("iMac");
		hp.enterSearchButton();
		
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.displayStatusOfimac());
		
	}
	
	@Test (priority=2)
	public void verifySearchNonExistingProductName()
	{
		HomePage hp = new HomePage(driver);
		hp.enterProductNameIntoSearchBoxField("Bout");
		hp.enterSearchButton();
		
		SearchPage sp = new SearchPage(driver);
		String Text= sp.getWarningMsg();
		Assert.assertEquals(Text, "There is no product that matches the search criteria.");
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutProvidingAnyProductName()
	{
		HomePage hp = new HomePage(driver);
		hp.enterSearchButton();
		
		SearchPage sp = new SearchPage(driver);
		String Text=sp.getWarningMsg();
		Assert.assertEquals(Text, "There is no product that matches the search criteria.");
	}

}
