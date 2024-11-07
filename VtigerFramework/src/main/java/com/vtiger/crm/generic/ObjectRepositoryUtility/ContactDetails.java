package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactDetails {
	
	WebDriverUtility wd=new WebDriverUtility();
	WebDriver driver=null;
	public ContactDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath="//input[@value='Cancel  ']/preceding-sibling::input")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement organizationEdit;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdit;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdit;
	
	
	public WebElement getOrganizationEdit() {
		return organizationEdit;
	}

	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndDateEdit() {
		return endDateEdit;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContactWithLN(String lastName) throws InterruptedException
	{
		lastNameEdit.sendKeys(lastName);
		Thread.sleep(10000);
		saveBtn.click();
	}
	
	public void createContactWithOrganization(String lastName, String orgName) throws InterruptedException
	{
		lastNameEdit.sendKeys(lastName);
		organizationEdit.click();
		wd.switchToTabBasedOnTitle(driver, "module=Accounts");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[.='Himli']")).click();
		Thread.sleep(10000);
		wd.switchToTabBasedOnTitle(driver, "module=Contacts");
		Thread.sleep(10000);
		saveBtn.click();
		
		
		
	}
	
	public void enterDate(String lastName, String currentDate, String endDate) throws InterruptedException
	{
		wd.executeImplicitWait(driver, 20);
		lastNameEdit.sendKeys(lastName);
		Thread.sleep(5000);
		startDateEdit.clear();
		startDateEdit.sendKeys(currentDate);
		Thread.sleep(5000);
		endDateEdit.clear();
		endDateEdit.sendKeys(endDate);
		Thread.sleep(10000);
		saveBtn.click();
		Thread.sleep(4000);
		
	}
	
	
	

}
