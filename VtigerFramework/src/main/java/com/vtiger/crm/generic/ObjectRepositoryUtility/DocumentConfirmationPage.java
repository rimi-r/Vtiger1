package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DocumentConfirmationPage {

	WebDriver driver = null;

	public DocumentConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement docHeader;

	@FindBy(id = "dtlview_Title")
	private WebElement docTitle;

	public WebElement getDocHeader() {
		return docHeader;
	}

	public WebElement getDocTitle() {
		return docTitle;
	}

	public void testConfirmation(String document) {
		String docHdr = docHeader.getText();
		String documentTitle = docTitle.getText();
		
		boolean header=docHdr.contains(document);
		boolean title=documentTitle.contains(document);
		
		Assert.assertEquals(header, true);
		System.out.println("pass");
//		Assert.assertEquals(title, true);
//		System.out.println("pass");
		
		Assert.assertTrue(title);
		System.out.println("pass");
		
		
//		if (docHdr.contains(document)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
//
//		if (documentTitle.contains(document)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
	}

}
