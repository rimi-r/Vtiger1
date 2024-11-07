package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	WebDriver driver=null;
	public  OpportunitiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@title='Create Opportunity...']")
	private WebElement opportunitiesIcon;

	public WebElement getOpportunitiesIcon() {
		return opportunitiesIcon;
	}
	
	

}
