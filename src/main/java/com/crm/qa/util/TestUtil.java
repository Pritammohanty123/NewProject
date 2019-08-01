package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.crm.qa.baseclass.Baseclass;

public class TestUtil  extends Baseclass {
	
	public static long pageloadtimeout=20;
	public static long implicitywait=25;
	public  static String TESTSHEETPATH="C:\\Users\\GLB-156\\eclipse-workspace\\NewProject"
			+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\freecrm_tesrdaa.xlsx";
	
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	public void switchtoframe(String frameName) {
		driver.switchTo().frame(frameName);
	}
	public Object[][]  gettestdatafromsheet(String sheetname) {
		FileInputStream file=null;
		try {
			 file= new FileInputStream(TESTSHEETPATH);
				}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException i) {
			i.printStackTrace();
		}catch (IOException m) {
			m.printStackTrace();		
		}
		sheet=	book.getSheet(sheetname);
		Object  [][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data [i][k]=  sheet.getRow(i+1).getCell(k).toString();
		}		
		}
return data;
}
	public static void takescreenshotendtest(ITestResult r) throws IOException 	
	{
		int i=0;
		File scrlife =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\GLB-156\\eclipse-workspace\\NewProject\\Screebshots"+"test"+i+".png");
		i++;
		FileHandler.copy(scrlife, des);
	}
}