package com.crm.generic.baseutility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.vtiger.crm.generic.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.generic.fileutility.JsonUtility;


public class OnlyBM {
	public WebDriver driver=null;
	public JsonUtility jv=new JsonUtility();
	@BeforeMethod(groups= {"smokeTesting","regressionTesting"})
	public void configBM() throws IOException, ParseException
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
		
		
		System.out.println("Before Method ==> login");
	 
		LoginPage lp=new LoginPage(driver);
		String url=jv.getDataFromJsonFile("url");
		String usn=jv.getDataFromJsonFile("usn");
		String pwd=jv.getDataFromJsonFile("pwd");
		lp.loginToApp(url, usn, pwd);
	}

}
