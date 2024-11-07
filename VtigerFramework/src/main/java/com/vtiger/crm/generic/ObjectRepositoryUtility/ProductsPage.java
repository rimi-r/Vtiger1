package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ProductsPage {

	
WebDriverUtility wd=new WebDriverUtility();
	
	WebDriver driver =null;
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement productIcon;
	
	
	
	public WebElement getProductIcon() {
		return productIcon;
	}
	
	
	
	
	
}
