package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\rstar\\OneDrive\\Desktop\\excel\\ddt_excel2.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\\\Users\\\\rstar\\\\OneDrive\\\\Desktop\\\\excel\\\\ddt_excel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public int getLastRowNum(String sheet) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\rstar\\OneDrive\\Desktop\\excel\\ddt_excel2.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		int lastRowNum=book.getSheet(sheet).getLastRowNum();
		return lastRowNum; 
	}
	
	
	public void setDataInExcel(String sheet, int row, int cell, int setData) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\rstar\\OneDrive\\Desktop\\excel\\ddt_excel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheet).getRow(row).getCell(cell).setCellValue(setData);
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\rstar\\\\OneDrive\\\\Desktop\\\\excel\\\\ddt_excel.xlsx");
		book.write(fos);
	}
	
	
}
