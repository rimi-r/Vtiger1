package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class InvoicePage {
	
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=null;
	
	public InvoicePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//img[@title='Create Invoice...']")
	private WebElement invoiceIcon;

	public WebElement getInvoiceIcon() {
		return invoiceIcon;
	}
	
	

}
