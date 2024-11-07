package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunitiesDetailsPage {

	WebDriver driver = null;

	public OpportunitiesDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement oppName;

	@FindBy(xpath = "//select[@id='related_to_type']/../../td[@class='dvtCellInfo']/img")
	private WebElement chooseOrg;

	@FindBy(xpath = "//a[.='Jelly8']")
	private WebElement orgName;

	@FindBy(xpath = "//b[.='Description Information:']/../../../tr[13]//input[@value='  Save  ']")
	private WebElement saveBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getChooseOrg() {
		return chooseOrg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void fillOpportunityManadatoryDetails(String pData) throws InterruptedException {
		 WebDriverUtility wb=new WebDriverUtility();
		 wb.executeImplicitWait(driver, 20);
		oppName.sendKeys(pData);
		chooseOrg.click();

		wb.switchToTabBasedOnUrl(driver, "module=Accounts");
		orgName.click();
		wb.switchToTabBasedOnUrl(driver, "module=Potentials");

		saveBtn.click();

		OpportunitiesVerificationPage opv = new OpportunitiesVerificationPage(driver);
		opv.testConfirmation(pData);
		wb.executeImplicitWait(driver, 20);
		
//		HomePage hp=new HomePage(driver);
//		hp.getOpportunitiesLink().click();
		
		////a[.='Jelly8']/../../td[9]/a[.='del']

	}

}
