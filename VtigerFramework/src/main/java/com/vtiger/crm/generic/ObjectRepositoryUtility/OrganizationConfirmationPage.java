package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationConfirmationPage {
	
	WebDriver driver=null;
	public OrganizationConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerField;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgEdit;
	
	
	//getters
	public WebElement getOrgEdit() {
		return orgEdit;
	}



	public WebElement getHeaderField() {
		return headerField;
	}
	
	
	

}
