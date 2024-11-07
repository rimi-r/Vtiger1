package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertyFiles(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\rstar\\OneDrive\\Desktop\\propertyfiles.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		return data; 
		
	}

}
