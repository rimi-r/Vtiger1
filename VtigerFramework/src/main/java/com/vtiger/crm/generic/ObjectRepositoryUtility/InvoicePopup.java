package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class InvoicePopup {
	
	
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=null;
	
	public InvoicePopup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//a[.='Kimli']")
	private WebElement orgOption;

	public WebElement getOrgOption() {
		return orgOption;
	}
	
	public void chooseOrg()
	{
		orgOption.click();
		wb.switchToAlertAndAccept(driver);
	}
	
	
	
	

}
