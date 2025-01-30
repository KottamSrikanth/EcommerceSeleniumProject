package com.EcommerceProject.Qa.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecommerce.Qa.pageObjects.AccountSucessPage;
import com.Ecommerce.Qa.pageObjects.HomePage;
import com.Ecommerce.Qa.pageObjects.RegisterPage;
import com.EcommerceProject.Qa.Base.Base;

public class RegisterAccount extends Base
{
	
	public WebDriver driver;
	
	public RegisterAccount()
	{
		super();
	}
	@BeforeMethod
	public void setup() 
	{
		driver =initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.selectRegisterOption();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test (priority=1)
	public void verifyRegisterProvidingOnlyMandotoryFields()
	{
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFirstName(GenerateFakeData.Name());
		rp.enterLastName(GenerateFakeData.Name());
		rp.enterEmail(GenerateFakeData.Email());
		rp.entertelephone(GenerateFakeData.phoneNumber());
		String password=GenerateFakeData.Password();
		rp.enterPassword(password);
		rp.enterConfirmPassword(password);
		rp.clickOnPrivacyPolicyCheckBox();
		rp.clickOnContinue();
		AccountSucessPage asp = new AccountSucessPage(driver);
		String msg= asp.getSuccessMsg();
		Assert.assertTrue(msg.equals("Your Account Has Been Created!"));
	}
	
	@Test (priority=2)
	public void verifyRegisterProvidingDifferentpasswords()
	{
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFirstName(GenerateFakeData.Name());
		rp.enterLastName(GenerateFakeData.Name());
		rp.enterEmail(GenerateFakeData.Email());
		rp.entertelephone(GenerateFakeData.phoneNumber());
		rp.enterPassword(GenerateFakeData.Password());
		rp.enterConfirmPassword(GenerateFakeData.Password());
		rp.clickOnPrivacyPolicyCheckBox();
		rp.clickOnContinue();

		
		String warningMsg=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		Assert.assertTrue(warningMsg.equals("Password confirmation does not match password!"));
	}
	
	@Test (priority=3)
	public void verfiyRegisterAccountWithoutProvidingAnyDetails()
	{

		RegisterPage rp = new RegisterPage(driver);
		rp.clickOnContinue();
		
		String frstName=rp.getFirstNameWarningMsg();
		Assert.assertTrue(frstName.equals("First Name must be between 1 and 32 characters!"));
		
		String LstName=rp.getLastNameWarningMsg();
		Assert.assertTrue(LstName.equals("Last Name must be between 1 and 32 characters!"));
		
		String emailAddress= rp.getEmailWarningMsg();
		Assert.assertTrue(emailAddress.equals("E-Mail Address does not appear to be valid!"));
		
		String telephone=rp.getTelephoneWarningMsg();
		Assert.assertTrue(telephone.equals("Telephone must be between 3 and 32 characters!"));
		
		String password=rp.getPasswordWarningMsg();
		Assert.assertTrue(password.equals("Password must be between 4 and 20 characters!"));
	}

}
