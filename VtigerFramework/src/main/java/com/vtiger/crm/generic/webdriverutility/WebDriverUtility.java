package com.vtiger.crm.generic.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	public void executeImplicitWait(WebDriver driver,int n) //1
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));
	}

	public void executeExplicitWait(WebDriver driver,int n, String contData)  //2
	{
		Duration dur = Duration.ofSeconds(n);
		WebDriverWait wait=new WebDriverWait(driver,dur);
		wait.until(ExpectedConditions.titleContains(contData));
	}
	
	public void switchToTabBasedOnUrl(WebDriver driver,String partialUrl) //3
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String nextTab=it.next();
			driver.switchTo().window(nextTab);
			String curUrl=driver.getCurrentUrl();
			if(curUrl.contains(partialUrl))
			{
				break;
			}
				
		}
	}
	
	public void swithctotab(WebDriver driver, String title)
	{
		Set<String> list=driver.getWindowHandles();
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			
			
		}
	}
	
	public void switchToTabBasedOnTitle(WebDriver driver, String partialTitle) { //4
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String nextTab=it.next();
			driver.switchTo().window(nextTab);
			String curTitle=driver.getTitle();
			if(curTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
		
		public void switchtoFrame(WebDriver driver,int index)  //5
		{
			driver.switchTo().frame(index);
		}
		
		public void switchtoFrame(WebDriver driver,String id)  //6
		{
			driver.switchTo().frame(id);
		}
		
		public void switchtoFrame(WebDriver driver,WebElement ele)  //7
		{
			driver.switchTo().frame(ele);
		}
		
		public void switchToAlertAndAccept(WebDriver driver)   //8
		{
			driver.switchTo().alert().accept();
		}
		
		public void switchToAlertAndDismiss(WebDriver driver)   //9
		{
			driver.switchTo().alert().dismiss();
		}
		
		public void selectDropdown(WebElement ele, int n) //10
		{
			Select s=new Select(ele);
			s.selectByIndex(n);
		}
		
		public void selectDropdown(WebElement ele, String text) //11
		{
			Select s=new Select(ele);
			s.selectByValue(text);
		}
		
		public void selectDropdownWithText(WebElement ele, String text) //12
		{
			Select s=new Select(ele);
			s.selectByVisibleText(text);
			//WebElement k=s.getWrappedElement();
			//System.out.println(k);
		}
		
		public String selectDropdownMultipleOptions(WebElement ele, int n) //13
		{
			Select s=new Select(ele);
			List<WebElement> li=s.getOptions();
			String data="";
			for(WebElement curr:li)
			{
				data=curr.getText();
			}
			return data;
		}
	
		public void mouseHoverAction(WebDriver driver, WebElement ele) //14
		{
			Actions act=new Actions(driver);
			act.moveToElement(ele).perform();
		}
		public void doubleClickAction(WebDriver driver, WebElement ele) //15
		{
			Actions act=new Actions(driver);
			act.doubleClick(ele).perform();
		}
		public void rightClickAction(WebDriver driver, WebElement ele) //16
		{
			Actions act=new Actions(driver);
			act.contextClick(ele).perform();
		}
		public void dragAndDropAction(WebDriver driver, WebElement src, WebElement dest ) //17
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src,dest).perform();
		}   
	
	public ChromeOptions notificationPopUp() //18
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		return opt;
//		driver=new ChromeDriver(opt);
//		return driver; //?
	}
	


	
	public void getPhotos(WebDriver driver) throws IOException //19
	{
		String photos="./photo/";
		Date d=new Date();
		String s=d.toString();
		String p=s.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(photos+p+".jpeg");
		FileHandler.copy(src, dest);
	}
	public void getPhotos(WebElement ele) throws IOException //20
	{
		String photos="./photo/";
		Date d=new Date();
		String s=d.toString();
		String p=s.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) ele;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(photos+p+".jpeg");
		FileHandler.copy(src, dest);
	}
	
	public void scrollPageDown(WebDriver driver, int y)    //21
	{
		JavascriptExecutor jsp=(JavascriptExecutor) driver;
			jsp.executeScript("window.scrollBy(0,y)");
			
		}
	public void scrollPageUp(WebDriver driver, int y)   //22
	{
		JavascriptExecutor jsp=(JavascriptExecutor) driver;
			jsp.executeScript("window.scrollBy(0,-n)");
			
		}
	public void scrollPageLeft(WebDriver driver, int x)  //23
	{
		JavascriptExecutor jsp=(JavascriptExecutor) driver;
			jsp.executeScript("window.scrollBy(-x,0)");
			
		}
	public void scrollPageRight(WebDriver driver, int x) //24
	{
		JavascriptExecutor jsp=(JavascriptExecutor) driver;
			jsp.executeScript("window.scrollBy(x,0)");
			
		}
	
	public void tabUsingKeyboard(WebDriver driver) throws AWTException//25
	{
      Robot r=new Robot();
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_T);
		
		}
	
	
	
}
