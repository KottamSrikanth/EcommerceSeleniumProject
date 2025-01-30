package com.Ecommerce.Qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	//Constructor
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Objects
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement passwordConfirm;
	
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[contains(text(),'First Name must')]")
	private WebElement firstNameWarningMsg;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[contains(text(),'Last Name must')]")
	private WebElement lastNameWarningMsg;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[contains(text(),'E-Mail Address')]")
	private WebElement emailWarningMsg;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[contains(text(),'Telephone')]")
	private WebElement telephoneWarningMsg;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[contains(text(),'Password')]")
	private WebElement passwordWarningMsg;
	
	
	//Methods
	
	public void enterFirstName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void entertelephone(String tel)
	{
		telephone.sendKeys(tel);
	}
	
	public void  enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String cpwd)
	{
		passwordConfirm.sendKeys(cpwd);
	}
	
	public void clickOnPrivacyPolicyCheckBox()
	{
		privacyPolicy.click();
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public String getFirstNameWarningMsg()
	{
		return firstNameWarningMsg.getText();
	}
	
	public String getLastNameWarningMsg()
	{
		return lastNameWarningMsg.getText();
	}
	
	public String getEmailWarningMsg()
	{
		return emailWarningMsg.getText();
	}
	
	public String getTelephoneWarningMsg()
	{
		return telephoneWarningMsg.getText();
	}
	
	public String getPasswordWarningMsg()
	{
		return passwordWarningMsg.getText();
	}
}