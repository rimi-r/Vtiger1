package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class InvoiceDetailsPage {

	WebDriverUtility wb = new WebDriverUtility();
	WebDriver driver = null;

	public InvoiceDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement subjectEdit;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement addOrgIcon;

	@FindBy(name = "bill_street")
	private WebElement billigEdit;

	@FindBy(name = "ship_street")
	private WebElement shippingEdit;

	@FindBy(id = "searchIcon1")
	private WebElement addItem;

	@FindBy(id = "qty1")
	private WebElement qtyEdit;

	@FindBy(id = "listPrice1")
	private WebElement listPriceEdit;

	@FindBy(xpath = "//input[@value='  Cancel  ']/../../../../tr[1]/td[1]/div[1]/input[@value='  Save  ']")
	private WebElement saveBtn;

	public WebElement getSubjectEdit() {
		return subjectEdit;
	}

	public WebElement getAddOrgIcon() {
		return addOrgIcon;
	}

	public WebElement getBilligEdit() {
		return billigEdit;
	}

	public WebElement getShippingEdit() {
		return shippingEdit;
	}

	public WebElement getAddItem() {
		return addItem;
	}

	public WebElement getQtyEdit() {
		return qtyEdit;
	}

	public WebElement getListPriceEdit() {
		return listPriceEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createInvoice(String sData, String billData, String shipData, String qtyData, String listPriceData)
			throws InterruptedException {

		InvoicePage ip = new InvoicePage(driver);
		ip.getInvoiceIcon().click();
		InvoicePopup ipp = new InvoicePopup(driver);

		getSubjectEdit().sendKeys(sData);
		getAddOrgIcon().click();

		wb.switchToTabBasedOnTitle(driver, "Accounts&action");

		ipp.chooseOrg();

		wb.switchToTabBasedOnTitle(driver, "Invoice&action");

		getBilligEdit().sendKeys(billData);
		getShippingEdit().sendKeys(shipData);

		getAddItem().click();

		wb.switchToTabBasedOnTitle(driver, "Products&action");
		Thread.sleep(2000);

		ProductPopup pp = new ProductPopup(driver);
		// pp.selectProd(driver);

		pp.getProdOption().click();

//		wb.mouseHoverAction(driver, prodOption);
//		Thread.sleep(2000);
//		wb.doubleClickAction(driver, prodOption);

		Thread.sleep(2000);
		wb.switchToTabBasedOnTitle(driver, "Invoice&action");
//		Thread.sleep(2000);
//		
//		Thread.sleep(3000);

		// wb.switchToTabBasedOnTitle(driver, "Invoice&action");

		Thread.sleep(3000);

		getQtyEdit().sendKeys(qtyData);

		getListPriceEdit().sendKeys(listPriceData);

		getSaveBtn().click();

		InvoiceConfirmationPage icp = new InvoiceConfirmationPage(driver);
		icp.validateInvoiceHeader(sData);

	}

}
