package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.crm.generic.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.generic.databaseutility.DatabaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.fileutility.JsonUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass extends WebDriverUtility {
	
	public FileUtility f=new FileUtility();
	public DatabaseUtility db=new DatabaseUtility();
	public ExcelUtility ex=new ExcelUtility();
	public JsonUtility jv=new JsonUtility();
	public JavaUtility js=new JavaUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
//	public ExtentTest test;
//	public ExtentSparkReporter spark;
//	public ExtentReports report;
	
	
	@BeforeSuite(groups= {"smokeTesting","regressionTesting"})
	public void configBS() throws SQLException
	{
		System.out.println("Before Suite==> Register db connection");
		db.registerDbConnection();
		
		
	}
	
   //  @Parameters("BROWSER") String browserType browserType;
	@BeforeClass(groups= {"smokeTesting","regressionTesting"})
	public void configCS() throws IOException, ParseException
	{
		System.out.println("Before class==> launch the browser");
		String browser=jv.getDataFromJsonFile("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	
//	@Parameters("BROWSER")
//	@BeforeClass(groups= {"smokeTesting","regressionTesting"})
//	public void configCS(String browse) throws IOException, ParseException
//	{
//		System.out.println("Before class==> launch the browser");
//		String browser=browse;
//				//jv.getDataFromJsonFile("browser");
//		if(browser.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(browser.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		
//	}
	
	@BeforeMethod(groups= {"smokeTesting","regressionTesting"})
	public void configBM() throws IOException, ParseException
	{
		System.out.println("Before Method ==> login");
	 
		LoginPage lp=new LoginPage(driver);
		String url=jv.getDataFromJsonFile("url");
		String usn=jv.getDataFromJsonFile("usn");
		String pwd=jv.getDataFromJsonFile("pwd");
		lp.loginToApp(url, usn, pwd);
	}
	
	@AfterMethod(groups= {"smokeTesting","regressionTesting"})
	public void configAM() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		System.out.println("After Method==> logout");
		executeImplicitWait(driver,10);
		hp.signOutFromApp();	
	}
	
	@AfterClass(groups= {"smokeTesting","regressionTesting"})
	public void configAC()
	{
		System.out.println("After Class==> close the application");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTesting","regressionTesting"})
	public void configAS() throws SQLException
	{
		System.out.println("After Suite ==> close db connectiom");
		db.closeDbConnection();	
	}

}
