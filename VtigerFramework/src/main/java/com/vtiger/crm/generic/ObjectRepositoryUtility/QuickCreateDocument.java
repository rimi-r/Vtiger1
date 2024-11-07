package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class QuickCreateDocument {

	WebDriver driver = null;

	public QuickCreateDocument(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='qcform']//input[@name='notes_title']")
	private WebElement titleEdit;

	@FindBy(xpath = "//form[@name='QcEditView']//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public WebElement getTitleEdit() {
		return titleEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void fillDocDetails(String titleData) {
		WebDriverUtility wb = new WebDriverUtility();
		wb.executeImplicitWait(driver, 20);
		titleEdit.sendKeys(titleData);
		saveBtn.click();
		
		DocumentConfirmationPage dcp = new DocumentConfirmationPage(driver);
		dcp.testConfirmation(titleData);
		
		HomePage hp = new HomePage(driver);
		hp.getDocTab().click();
		
	}

//	public void quickCreateDocumentAndDeleteIt(String docTitle) {
//		WebDriverUtility wb = new WebDriverUtility();
//		wb.executeImplicitWait(driver, 20);
//		fillDocDetails(docTitle);
//
//		HomePage hp = new HomePage(driver);
//		hp.getDocTab().click();
//
//	}

}
