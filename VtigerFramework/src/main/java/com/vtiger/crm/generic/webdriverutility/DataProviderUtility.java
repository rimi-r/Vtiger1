package com.vtiger.crm.generic.webdriverutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.vtiger.crm.generic.fileutility.ExcelUtility;

public class DataProviderUtility {
	
	@DataProvider
	public Object[][] getDataTest() throws EncryptedDocumentException, IOException
	{
		ExcelUtility ex=new ExcelUtility();
		int n=ex.getLastRowNum("Sheet2");
		Object[][] obj=new Object[n][2];
		for(int i=0;i<n;i++)
		{
			obj[i+1][0]=ex.getDataFromExcel("Sheet2", i+1, 0);
			obj[i+1][1]=ex.getDataFromExcel("Sheet2", i+1, 1);
			
		}
		return obj;
	}

}
