package com.Ecommerce.Qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Login;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMsg;
	
	public void enterEmailAddress(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		Login.click();
	}
	
	public String getWarningMsg()
	{
		String warningMsg=WarningMsg.getText();
		return warningMsg;
	}

}
