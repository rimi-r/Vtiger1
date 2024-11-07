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

import com.vtiger.crm.generic.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.generic.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.generic.databaseutility.DatabaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.fileutility.JsonUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass1 {
	
	
	public ExcelUtility ex=new ExcelUtility();
	public FileUtility f=new FileUtility();
	public DatabaseUtility db=new DatabaseUtility();
	public JsonUtility jv=new JsonUtility();
	public JavaUtility js=new JavaUtility();
	public WebDriverUtility wb=new WebDriverUtility();
	public WebDriver driver=null;
	
	@BeforeSuite
	public void configureBS() throws SQLException
	{
		System.out.println("Create Connection");
		db.registerDbConnection();
	}
	
	@BeforeClass
	public void configBC() throws IOException, ParseException
	{
		System.out.println("launch the browser");
		String browser=jv.getDataFromJsonFile("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("check browser value");
		}
	}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("login");
		String url=f.getDataFromPropertyFiles("url");
		String usn=f.getDataFromPropertyFiles("username");
		String pwd=f.getDataFromPropertyFiles("password");

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url, usn, pwd);
		
	}
	
	@AfterMethod
	public void configAM() throws InterruptedException
	{
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		wb.executeImplicitWait(driver, 20);
		hp.signOutFromApp();
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("closee the browser");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws SQLException
	{
		System.out.println("close db connection");
		db.closeDbConnection();
	}

}
