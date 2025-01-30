package com.Ecommerce.Qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//ul[@class='list-inline']//a[@class='dropdown-toggle']")
	private WebElement MyAccountOption;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu d')]//a[text()='Register']")
	private WebElement RegisterOption;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu d')]//a[text()='Login']")
	private WebElement LoginOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchBoxButton;
	//Methods
	public void clickOnMyAccount()
	{
		MyAccountOption.click();
	}
	
	public void selectRegisterOption()
	{
		RegisterOption.click();
	}
	
	public void selectLoginOption()
	{
		LoginOption.click();
		
	}
	
	public void enterProductNameIntoSearchBoxField(String productName)
	{
		searchBoxField.sendKeys(productName);
	}
	
	public void enterSearchButton()
	{
		searchBoxButton.click();
	}

}
