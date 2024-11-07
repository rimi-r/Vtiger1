package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ProductDetailsPage {
	
	
WebDriverUtility wd=new WebDriverUtility();
	
	WebDriver driver =null;
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="productname")
	private WebElement productName;
	
	@FindBy (xpath="//input[@value='  Cancel  ']/../../../../tr[1]/td[1]/div[1]/input[@value='  Save  ']")
	private WebElement saveBtn;
	
	
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProductWithName(String pData)
	{
		wd.executeImplicitWait(driver, 20);
		productName.sendKeys(pData);
		saveBtn.click();
		
		ProductConfirmationPage cp=new ProductConfirmationPage(driver);
		cp.testConfirmation(pData);
		
	}
	

}
