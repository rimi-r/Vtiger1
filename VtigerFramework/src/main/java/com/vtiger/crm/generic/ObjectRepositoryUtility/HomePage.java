package com.vtiger.crm.generic.ObjectRepositoryUtility;
/**
 * @author rstar
 * Test class that contains all the elements and business actions associtaed with the application home page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	
	
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=null;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath="//a[.='Organizations']")
	private WebElement organizationLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIcon;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy (xpath="//td[@align='center']/a[.='Calendar']")
	private WebElement calenderTab;
	
	@FindBy (linkText="Products")
	private WebElement productTab;
	
	@FindBy (xpath="//a[.='More']")
	private WebElement moreTab;
	
	@FindBy (xpath="//a[.='Invoice']")
	private WebElement invoiceLink;
	
	@FindBy (xpath="//a[.='Documents']")
	private WebElement docTab;
	
	@FindBy (xpath="//select[@class='small' and @id='qccombo']")
	private WebElement quickCreateDD;
	
	@FindBy (name="notes_title")
    private WebElement quickTitleEdit;
	
	@FindBy (xpath="//input[@name='notes_title']/../../../../../table[2]//input[@value='  Save']")
	private WebElement saveBtn;
	
	@FindBy (xpath="//a[.='Contacts']")
    private WebElement contactLink;
	
	@FindBy (xpath="//td[@class='tabUnSelected']/a[.='Opportunities']")
	private WebElement opportunitiesLink;
    
    
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getQuickTitleEdit() {
		return quickTitleEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getQuickCreateDD() {
		return quickCreateDD;
	}

	public WebElement getDocTab() {
		return docTab;
	}

	public WebElement getProductTab() {
		return productTab;
	}

	public WebElement getMoreTab() {
		return moreTab;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getCalenderTab() {
		return calenderTab;
	}

	//getters
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getSignOutIcon() {
		return signOutIcon;
	}

	public WebElement getAddOrgIcon() {
		return organizationLink;
	}
	
	public WebElement getOpportunitiesLink()
	{
		return opportunitiesLink;
	}
	
	
	
	//business actions
	public void addOrganization()
	{
		organizationLink.click();
	}
	
/**
 * Sign out form the application
 * @author rstar
 * @throws InterruptedException
 */
	public void signOutFromApp() throws InterruptedException
	{
		wb.mouseHoverAction(driver, signOutIcon);
		//wb.executeImplicitWait(driver, 10);
		Thread.sleep(4000);
		signOutLink.click();
		Thread.sleep(2000);
		
	}
	
	public void goToInvoice() throws InterruptedException
	{
		wb.mouseHoverAction(driver,moreTab );
		Thread.sleep(3000);
		invoiceLink.click();
		
	}
	
	public void quickDropDown()
	{
		quickCreateDD.click();
		wb.selectDropdownWithText(quickCreateDD,"New Document" );
	}

	
	

}
