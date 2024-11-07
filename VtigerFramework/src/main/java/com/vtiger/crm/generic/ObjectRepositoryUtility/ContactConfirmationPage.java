package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactConfirmationPage {
	
	
	WebDriver driver=null;
	public ContactConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerField;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameEdit;
	
	
	//getters
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}



	public WebElement getHeaderField() {
		return headerField;
	}
	
	public void testConfirmation(String data)
	{
		String contactHdr=getHeaderField().getText();
		String lastName=getLastNameEdit().getText();
		
		
		if(contactHdr.contains(data))
		{
			System.out.println("pass");
		}
		else 
			System.out.println("fail");
		
		if(lastName.contains(data))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}

}
