package com.vtiger.crm.generic.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CalendarMonthPage {
	
	WebDriverUtility wd=new WebDriverUtility();
	JavaUtility jv=new JavaUtility();
	WebDriver driver=null;
	public CalendarMonthPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//td[@class='calAddButton']")
	private WebElement addAppointment;
	
	@FindBy(xpath="//a[.='Meeting']")
	private WebElement meetingLink;
	
	@FindBy(xpath="//form[@name='EditView']//input[@name='subject']")
	private WebElement eventEdit;
	
	@FindBy(xpath="//a[.='Repeat']")
	private WebElement repeatLink;
	
	@FindBy(xpath="//td[.='Enable Repeat']/preceding-sibling::td[1]/input[@type='checkbox']")
	private WebElement repeatCheckBox;
	
	
	@FindBy(xpath="//b[.='Event starts at']/../../..//select[@id='startfmt']")
	private WebElement startTimeDD;
	
	@FindBy(xpath="//td[@id='date_table_secondtd']//select[@name='endfmt']")
	private WebElement endTimeDD;
	

	@FindBy(xpath="//form[@name='EditView']//td[@align='center']/input[@value='Save']")
	private WebElement saveBtn;
	
	@FindBy(id="calendar_repeat_limit_date")
	private WebElement untilDate;
	
	
	public WebElement getUntilDate() {
		return untilDate;
	}

	public WebElement getAddAppointment() {
		return addAppointment;
	}

	public WebElement getMeetingLink() {
		return meetingLink;
	}

	public WebElement getEventEdit() {
		return eventEdit;
	}


	public WebElement getRepeatLink() {
		return repeatLink;
	}
	
	public WebElement getRepeatCheckBox() {
		return repeatCheckBox;
	}
	

	public WebElement getStartTimeDD() {
		return startTimeDD;
	}

	public WebElement getEndTimeDD() {
		return endTimeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void makeAnAppointment(String eventName) throws InterruptedException
	{
		
		wd.executeImplicitWait(driver,15);
		wd.mouseHoverAction(driver, addAppointment);
		meetingLink.click();
		eventEdit.sendKeys(eventName);
		
		wd.selectDropdownWithText(startTimeDD, "PM");
		wd.selectDropdownWithText(endTimeDD, "PM");
		
		repeatLink.click();
		repeatCheckBox.click();
		
		String da=jv.getSpecifiedDate(5);
		String day=jv.getSpecifiedDay(5);
		System.out.println(day);
		untilDate.clear();
		untilDate.sendKeys(da);
		
		Thread.sleep(4000);
		saveBtn.click();
		verifyAppointment(day);
		
	}
	
	
	public void verifyAppointment(String day)
	{
		
		int n=0;
		if(day.contains("1")||day.contains("8")||day.contains("15")||day.contains("22")||day.contains("29"))
		{
			n=2;
		}
//		else if(d==2||d==9||d==16||d==23||d==30)
//		{
//			n=3;
//		}
//		else if(d==3||d==10||d==17||d==24||d==31)
//		{
//			n=4;
//		}
//		else if(d==4||d==11||d==18||d==25)
//		{
//			n=5;
//		}
//		else if(d==5||d==12||d==19||d==26)
//		{
//			n=5;
//		}
//		else if(d==6||d==13||d==20||d==27)
//		{
//			n=5;
//		}
//		else if(d==7||d==14||d==21||d==28)
//		{
//			n=1;
//		}
		//int n=4;
		WebElement ele=driver.findElement(By.xpath("//div[@class='event']/../../td["+n+"]//span[.='10:35PM - 11:35PM']"));
		String date=ele.getText();
		if(date.contains("PM"))
		{
			System.out.println("pass");
			
			
		}
		else
			System.out.println("fail");
		}

}
