package com.Ecommerce.Qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "iMac")
	private WebElement iMac;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	WebElement warningMsg;
	
	public boolean displayStatusOfimac()
	{
		return iMac.isDisplayed();
	}
	
	public String getWarningMsg()
	{
		return warningMsg.getText();
	}

}
