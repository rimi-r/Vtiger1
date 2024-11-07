package com.vtiger.orgtest;

/**
 * @author rstar
 * test class for the Organization module
 */

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.generic.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.OrganizationConfirmationPage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.OrganizationDetailsPage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.OrganizationPage;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.vtiger.crm.listenerutilitytest.ListenerImplemenetationTest.class)
public class OrgTest extends BaseClass {

	@Test(groups = "smokeTesting")
	public void createOrgWithManadatoryFields()
			throws IOException, ParseException, EncryptedDocumentException, InterruptedException {

		// JavaUtility jv=new JavaUtility();
		/* Read the organization data from the excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Read organization data from the excel sheet");
		String data = ex.getDataFromExcel("Sheet1", 6, 2) + js.getRandomeNumber();

		// HomePage hp = new HomePage(driver);
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		OrganizationDetailsPage og = new OrganizationDetailsPage(driver);
		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);
		/* click on 'Create Organization' link */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the organization link");
		hp.getAddOrgIcon().click();
		
		/* click on 'Create Organization' icon */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the 'add organization' icon");
		op.getOrgIcon().click();
		
		/* Enter Organization data */
		UtilityClassObject.getTest().log(Status.INFO, "enter the organization data");
		og.enterDataInOrgField(data);

	}

	@Test(groups = "regressionTesting")
	public void createOrgWithIndustryType()
			throws EncryptedDocumentException, IOException, ParseException, InterruptedException {
		
		/* Read data from the excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Read organization data from the excel sheet");
		int ran = js.getRandomeNumber();
		String data = ex.getDataFromExcel("Sheet1", 6, 2) + ran;
		String indData = ex.getDataFromExcel("Sheet1", 6, 3);
		String typeData = ex.getDataFromExcel("Sheet1", 6, 4);
		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		OrganizationDetailsPage og = new OrganizationDetailsPage(driver);
		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);

		/* Click on organization link */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the Organization link");
		hp.getAddOrgIcon().click();
		
		/* Click on organization icon */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the Organization icon");
		op.getOrgIcon().click();
		
		/*Enter the data*/
		UtilityClassObject.getTest().log(Status.INFO, "Enter the data");
		og.enterDataInOrgField(data, indData, typeData);
		

	}

	@Test(groups = "regressionTesting")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException {

		int ran = js.getRandomeNumber();

		// WebDriverUtility wb=new WebDriverUtility();
		
		/* Read organization data and the phone number from the excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Read organization data and phone number from the excel sheet");
		
		ExcelUtility ex = new ExcelUtility();
		String data = ex.getDataFromExcel("Sheet1", 9, 2) + ran;
		String phoneData = ex.getDataFromExcel("Sheet1", 9, 3);

		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		OrganizationDetailsPage og = new OrganizationDetailsPage(driver);
		OrganizationConfirmationPage pg = new OrganizationConfirmationPage(driver);

		/* Click on organization link */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the Organization link");
		hp.getAddOrgIcon().click();
		
		/* Click on organization icon */
		UtilityClassObject.getTest().log(Status.INFO, "Click on the Organization icon");
		op.getOrgIcon().click();
		
		/* Enter the organization data */
		UtilityClassObject.getTest().log(Status.INFO, "Enter organization data");
		og.enterDataInOrgField(data, phoneData);
		// Thread.sleep(3000);

	}
}
