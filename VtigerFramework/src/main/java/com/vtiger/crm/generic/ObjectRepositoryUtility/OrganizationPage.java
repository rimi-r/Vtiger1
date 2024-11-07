package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationPage {
	
	WebDriverUtility wd=new WebDriverUtility();
	WebDriver driver=null;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addOrgIcon;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchEdit;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@name='search_field']")
	private WebElement orgDropdown;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	
	//getters
	public WebElement getOrgIcon() {
		return addOrgIcon;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddOrgIcon() {
		return addOrgIcon;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getOrgDropdown() {
		return orgDropdown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	//Business actions
	
	public void selectFromDD(String ddData)
	{
		wd.selectDropdownWithText(orgDropdown, ddData);
	}
	
	
	
	

//	public void clickOrgIcon()
//	{
//		addOrgIcon.click();
//	}
	
}
