package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class DocumentsPage {
	
	

	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=null;
	
	public DocumentsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Document...']")
    private WebElement addIcon;

	public WebElement getAddIcon() {
		return addIcon;
	}
	
	
}
