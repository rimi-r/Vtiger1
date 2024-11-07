package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomeNumber()
	{
		Random rand=new Random();
		int rNum=rand.nextInt(600);
		return rNum;
	}
	
	public String getCurrentDate() {
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String date=f.format(d);
		return date;
	}
	
	public String getSpecifiedDate(int n)
	{
		
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		f.format(d);
		
		Calendar cal=f.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, n);
		String newDate=f.format(cal.getTime());
		return newDate;
		
	}
	
	public String getSpecifiedDay(int n)
	{
		
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd");
		f.format(d);
		
		Calendar cal=f.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, n);
		String newDate=f.format(cal.getTime());
		return newDate;
		
	}
		
}
