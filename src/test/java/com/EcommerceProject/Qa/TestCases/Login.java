package com.EcommerceProject.Qa.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecommerce.Qa.Utils.Utils;
import com.Ecommerce.Qa.pageObjects.AccountPage;
import com.Ecommerce.Qa.pageObjects.HomePage;
import com.Ecommerce.Qa.pageObjects.LoginPage;
import com.EcommerceProject.Qa.Base.Base;

public class Login extends Base
{
	
	public WebDriver driver;
	
	public Login()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.selectLoginOption();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test (priority=1)
	public void verfiyLoginWithValidCreditionals()
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress("srikanth36@gmail.com");
		lp.enterPassword("123456");
		lp.clickOnLoginButton();
		
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(ap.getDisplayStatusEditYourAccountOption());
	}
	
	
	@Test (priority=2)
	public void verifyLoginWithInvalidCreditionals()
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(GenerateFakeData.Email());
		lp.enterPassword(GenerateFakeData.Password());
		lp.clickOnLoginButton();
		
		String warningMsg=lp.getWarningMsg();
		Assert.assertEquals(warningMsg,"Warning: No match for E-Mail Address and/or Password.");
	
		
	}
	
	@Test (priority=3)
	public void testWithoutPassingAnyCreditionals()
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickOnLoginButton();
		
		String warningText=lp.getWarningMsg();
		Assert.assertTrue(warningText.equals("Warning: No match for E-Mail Address and/or Password."));
		
	}
	/*
	@Test(priority=4 , dataProvider ="Test data" )
	public void verifyCreditionalsUsingDataProvider(String userName,String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(userName);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(ap.getDisplayStatusEditYourAccountOption());

	}
	
	@DataProvider(name="Test data")
	public Object[][] supplyData() 
	{
		Object[][] data = {{"srikanth36@gmail.com","123456"},
				{"srikanth998765@gmail.com","87650"},
				{"srikanth998765@gmail","1234"}};
		return data;
	}*/
}
