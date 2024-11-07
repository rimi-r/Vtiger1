package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class InvoiceConfirmationPage {
	
	WebDriver driver=null;
	public InvoiceConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement invoiceHeader;
	
	@FindBy(id="dtlview_Subject")
	private WebElement subjectEdit;
	
	public WebElement getInvoiceHeader()
	{
		return invoiceHeader;
	}
	
	public WebElement getSubjectEdit()
	{
		return subjectEdit;
	}
	
	public void validateInvoiceHeader(String subName)
	{
		String headerName=invoiceHeader.getText();
		String subjectField=subjectEdit.getText();
		
		boolean header=headerName.contains("fli");
		
		Assert.assertEquals(header, true);
		System.out.println("pass");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(subjectField, subName);
		System.out.println("continue");
		//sa.assertAll();
		
		
		
		
//		if(headerName.contains(subName))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
//		
//		if(subjectField.contains(subName))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		
	}
}
