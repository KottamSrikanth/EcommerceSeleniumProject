package com.Ecommerce.Qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage 
{
	WebDriver driver;
	public AccountSucessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']//h1")
	private WebElement successMsg;
	
	
	public String getSuccessMsg()
	{
		return successMsg.getText();
	}

}
