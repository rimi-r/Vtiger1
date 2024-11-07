package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CalenderPage {
	
	WebDriverUtility wd=new WebDriverUtility();
	
	WebDriver driver =null;
	public CalenderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="Month")
	private WebElement monthLink;
	
	@FindBy(xpath="//select[@name='viewOption']")
	private WebElement viewDropdown;
	
	
	
	
	public WebElement getMonthLink() {
		return monthLink;
	}


	public WebElement getViewDropdown() {
		return viewDropdown;
	}
	
	public void selectViewDdOption()
	{
		wd.selectDropdownWithText(viewDropdown, "List View");
	}

}
