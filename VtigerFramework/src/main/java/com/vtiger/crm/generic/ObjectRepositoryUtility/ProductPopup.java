package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ProductPopup {
	
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=null;
	
	public ProductPopup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//a[.='Electric biller']")
	private WebElement prodOption;

	public WebElement getProdOption() {
	
		return prodOption;
}
//	public WebDriver selectProd(WebDriver driver) throws InterruptedException
//	{
//		wb.switchToTabBasedOnTitle(driver, "Products&action");
//		Thread.sleep(2000);
//		wb.mouseHoverAction(driver, prodOption);
//		Thread.sleep(2000);
//		wb.doubleClickAction(driver, prodOption);
//		Thread.sleep(2000);
//		wb.switchToTabBasedOnTitle(driver, "Invoice&action");
//		Thread.sleep(2000);
//		return driver;
//	}


}
