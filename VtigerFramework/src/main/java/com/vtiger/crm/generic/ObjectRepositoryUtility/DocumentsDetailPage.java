package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class DocumentsDetailPage {

	WebDriverUtility wb = new WebDriverUtility();

	WebDriver driver = null;

	public DocumentsDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "notes_title")
	private WebElement titleEdit;

	@FindBy(xpath = "//input[@value='  Cancel  ']/../../../../tr[13]/td/div/input[@value='  Save  ']")
	private WebElement saveBtn;

	@FindBy(name = "filename")
	private WebElement chooseFile;

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getTitleEdit() {
		return titleEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createDocumentWithMandatoryField(String docData) {
		WebDriverUtility wb = new WebDriverUtility();
		wb.executeImplicitWait(driver, 20);

		titleEdit.sendKeys(docData);
		chooseFile.sendKeys("C:\\Users\\rstar\\OneDrive\\Desktop\\facebook.txt");

		saveBtn.click();
		
		DocumentConfirmationPage dcp = new DocumentConfirmationPage(driver);
		dcp.testConfirmation(docData);
		

	}

	public void createDocAndDeleteIt(String docTitle) {
		WebDriverUtility wb = new WebDriverUtility();
		wb.executeImplicitWait(driver, 20);
		titleEdit.sendKeys(docTitle);
		chooseFile.sendKeys("C:\\Users\\rstar\\OneDrive\\Desktop\\facebook.txt");

		saveBtn.click();
		
		DocumentConfirmationPage dcp = new DocumentConfirmationPage(driver);
		dcp.testConfirmation(docTitle);
		
		HomePage hp = new HomePage(driver);
		hp.getDocTab().click();

		

	}

}
