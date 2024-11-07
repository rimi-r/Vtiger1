package com.vtiger.crm.generic.ObjectRepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationDetailsPage {

	WebDriver driver = null;

	public OrganizationDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationField;

	@FindBy(xpath = "//input[@value='Cancel  ']//preceding-sibling::input[@value='  Save  ']")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement typeDD;

	@FindBy(id = "phone")
	private WebElement phoneEdit;

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrganizationField() {
		return organizationField;
	}
/**
 * Enter the data in organization page -only name and create an organization
 * @author rstar
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 * @throws InterruptedException
 */
	public void enterDataInOrgField(String data) throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriverUtility wb = new WebDriverUtility();
		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);
		ExcelUtility ex = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		wb.executeImplicitWait(driver, 10);

		organizationField.sendKeys(data);

		saveBtn.click();
		String orghdr = pg.getHeaderField().getText();
		String orgName = pg.getOrgEdit().getText();

		Assert.assertEquals(orghdr, data);

		SoftAssert as = new SoftAssert();
		as.assertEquals(orgName, data);
		as.assertAll();

//		if(orghdr.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else 
//			System.out.println("fail");
//		
//		if(orgName.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else
//			System.out.println("fail");
		// hp.signOutFromApp();
	}

	/**
	 * Method to enter the organization data -name, industry, type and create an
	 * organization
	 * 
	 * @author rstar
	 * @param data
	 * @param indData
	 * @param typeData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterDataInOrgField(String data, String indData, String typeData)
			throws EncryptedDocumentException, IOException, InterruptedException {

		organizationField.sendKeys(data);
		WebDriverUtility wb = new WebDriverUtility();
		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);
		ExcelUtility ex = new ExcelUtility();
		HomePage hp = new HomePage(driver);

		wb.executeImplicitWait(driver, 10);

		Thread.sleep(2000);
		wb.selectDropdownWithText(industryDD, indData);
		Thread.sleep(2000);
		wb.selectDropdownWithText(getTypeDD(), typeData);
		Thread.sleep(2000);

		saveBtn.click();
		String orghdr = pg.getHeaderField().getText();
		String orgName = pg.getOrgEdit().getText();

		Assert.assertEquals(orghdr, data);

		SoftAssert as = new SoftAssert();
		as.assertEquals(orgName, data);
		as.assertAll();

//		if(orghdr.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else 
//			System.out.println("fail");
//		
//		if(orgName.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else
//			System.out.println("fail");
		// hp.signOutFromApp();
	}

	public void enterDataInOrgField(String data, String phoneData)
			throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriverUtility wb = new WebDriverUtility();
		wb.executeImplicitWait(driver, 10);
		organizationField.sendKeys(data);
		phoneEdit.sendKeys(phoneData);
		saveBtn.click();

		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);
		Thread.sleep(2000);

		String orghdr = pg.getHeaderField().getText();
		String orgName = pg.getOrgEdit().getText();
		
		
		Assert.assertEquals(orghdr, data);
		
		SoftAssert as= new SoftAssert();
		as.assertEquals(orgName, data);
		as.assertAll();

//		if(orghdr.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else 
//			System.out.println("fail");
//		
//		if(orgName.contains(data))
//		{
//			System.out.println("pass");
//		}
//		else
//			System.out.println("fail");

	}
//	String indData1=ex.getDataFromExcel("Sheet1", 6, 3);
//	String typeData1=ex.getDataFromExcel("Sheet1", 6, 4);

}
