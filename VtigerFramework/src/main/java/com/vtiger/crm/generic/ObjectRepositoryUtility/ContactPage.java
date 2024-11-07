package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactPage {
	
	WebDriverUtility wd=new WebDriverUtility();
	WebDriver driver=null;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement addContactIcon;
	
	@FindBy(xpath="//img[@title='Create Contact//...']")
	private WebElement addContactIcon1;
	

	
	
	//getters
	public WebElement getContactIcon() {
		return addContactIcon;
	}

	public WebDriver getDriver() {
		return driver;
	}



	
	//Business actions


}
