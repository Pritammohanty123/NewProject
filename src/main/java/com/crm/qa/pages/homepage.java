package com.crm.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.Baseclass;

public class homepage extends Baseclass {
	@FindBy(xpath="//td[contains(text(),'User: pritam mohanty')]")
	WebElement usernamelevel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Dealsslink;
	@FindBy(xpath="//a[contains(text(),Tasks')]")
	WebElement Taskslink;
	@FindBy(xpath="//a[contains(text(),Email')]")
	WebElement Emaillink;
	@FindBy(xpath="//a[contains(text(),Reports')]")
	WebElement Reportslink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
public homepage() {
	PageFactory.initElements(driver,this);
}
	
	public String verifytitlepage() {
		 return driver.getTitle();		
	}
	public  contactspage clickoncontactspage() {
		contactslink.click();
		return new contactspage();		
	}
	
	public  Dealspage clickondealspage() {
		Dealsslink.click();
		return new Dealspage();		
	}
	public Taskpage clickontaskspage() {
		Taskslink.click();
		return new Taskpage();		 
	}
	public boolean verifyusername() {
	return 	usernamelevel.isDisplayed();
	}

public  void clickoncontacts() {
	Actions action =new Actions(driver);
	action.moveToElement(contactslink).build().perform();
	newcontactslink.click();
	
	}
}
