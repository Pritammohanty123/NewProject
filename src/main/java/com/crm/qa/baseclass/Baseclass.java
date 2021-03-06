package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class Baseclass {
	public static WebDriver driver;
	public static Properties pro;
	
	
	public Baseclass() {
		try {
			pro=new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\GLB-156\\eclipse-workspace\\NewProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro.load(fis);	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void Initproperty() {
		 String browser =pro.getProperty("url");
		 if(browser.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtimeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.implicitywait, TimeUnit.SECONDS);
				driver.get(pro.getProperty("url"));
				
		 }
		
	}

}
