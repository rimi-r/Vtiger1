package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunitiesVerificationPage {
	
	WebDriver driver=null;
	public OpportunitiesVerificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement oppHeader;
	
	@FindBy (id="dtlview_Opportunity Name")
	private WebElement oppName;
	
	@FindBy (xpath="//td[@class='tabSelected']/a[.='Opportunities']")
	private WebElement oppLink;

	public WebElement getOppLink() {
		return oppLink;
	}

	public WebElement getOppHeader() {
		return oppHeader;
	}

	public WebElement getOppName() {
		return oppName;
	}
	
	public void testConfirmation(String oppData) throws InterruptedException
	{
		WebDriverUtility wb=new WebDriverUtility();
		 wb.executeImplicitWait(driver, 20);
		 
		String oppN=oppName.getText();
		String oppHdr=oppHeader.getText();
		
		boolean flag=oppN.contains(oppData);
		boolean flag1=oppHdr.contains("flyer");
		Assert.assertEquals(flag, true);
		
//		SoftAssert soft=new SoftAssert();
		Assert.assertEquals(flag1, true);
//		soft.assertAll();
//		if(oppN.contains(oppData))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
//		if(oppHdr.contains(oppData))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		wb.mouseHoverAction(driver, oppLink);
		Thread.sleep(2000);
		oppLink.click();
	}
	

}
