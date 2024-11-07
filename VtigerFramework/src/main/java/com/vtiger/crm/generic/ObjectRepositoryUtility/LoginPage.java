package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
//@FindAll({@FindBy(name ="user"),@FindBy(xpath="//input[@type='text']")})
//private WebElement usernameEdit;






	@FindBy (name="user_name")
	private WebElement usernameEdit;
//	
	@FindBy (name="user_password")
	private WebElement passwordEdit;
	
	@FindBy (id="submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String url,String usn, String pwd)
	{
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdit.sendKeys(usn);
		passwordEdit.sendKeys(pwd);
		loginBtn.click();
	}
	
	

}
