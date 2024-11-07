package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductConfirmationPage {
	
	WebDriver driver=null;
	public ProductConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement prodHeader;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement prodName;
	
	public WebElement getProdHeader()
	{
		return prodHeader;
	}
	
	public WebElement getProdName()
	{
		return prodName;
	}
	
	public void testConfirmation(String product)
	{
		String prodHdr=prodHeader.getText();
		String productName=prodName.getText();
		
		boolean header=prodHdr.contains(product);
		Assert.assertEquals(header,true);
		System.out.println("pass");
		
		SoftAssert as=new SoftAssert();
		as.assertEquals(productName, "fly");
		System.out.println("continue");
		
		as.assertAll();
		
//		if(prodHdr.contains(product))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
//		if(productName.contains(product))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
	}

}
