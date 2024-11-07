package com.vtiger.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.generic.ObjectRepositoryUtility.ContactConfirmationPage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.ContactDetails;
import com.vtiger.crm.generic.ObjectRepositoryUtility.ContactPage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.JsonUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactTest extends BaseClass {

	@Test(groups="smokeTesting")
	public void createContactWithMandatoryFields() throws InterruptedException, IOException, ParseException {

		int ran = js.getRandomeNumber();

		String lastName = ex.getDataFromExcel("Sheet1", 1, 2) + ran;

		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		ContactDetails cd = new ContactDetails(driver);
		ContactConfirmationPage pg = new ContactConfirmationPage(driver);

		hp.getContactLink().click();

		cp.getContactIcon().click();

		cd.createContactWithLN(lastName);

		pg.testConfirmation(lastName);

	}

	@Test(groups="regressionTesting")
	public void createContactWithOrg() throws IOException, ParseException, InterruptedException {

		int ran = js.getRandomeNumber();

		String lastName = ex.getDataFromExcel("Sheet1", 1, 2) + ran;
		String orgName = ex.getDataFromExcel("Sheet1", 1, 3) + ran;

		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		ContactDetails cd = new ContactDetails(driver);
		ContactConfirmationPage pg = new ContactConfirmationPage(driver);

		hp.getContactLink().click();

		cp.getContactIcon().click();

		cd.createContactWithOrganization(lastName, orgName);

		pg.testConfirmation(lastName);

	}
	
	@Test(groups="regressionTesting")
	public void createContactWithDate() throws EncryptedDocumentException, IOException, InterruptedException
	{
        int ran=js.getRandomeNumber();
		
		WebDriverUtility wb=new WebDriverUtility();
		
		ExcelUtility ex=new ExcelUtility();
		String lastName=ex.getDataFromExcel("Sheet1", 1, 2)+ran;
		String orgName=ex.getDataFromExcel("Sheet1", 1, 3)+ran;
		String currentDate=js.getCurrentDate();
		String endDate=js.getSpecifiedDate(35);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		ContactDetails cd= new ContactDetails(driver);
		ContactConfirmationPage pg=new ContactConfirmationPage(driver);

		
		hp.getContactLink().click();
		
		cp.getContactIcon().click();
		
		cd.enterDate(lastName, currentDate, endDate);
		
		pg.testConfirmation(lastName);
	}

}
