package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseclass.Baseclass;

public class contactspage  extends Baseclass {
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement compnyname;
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebtn;
	
	@FindBy(xpath="//a[contains(text(),'hema latha')]/parent::td/preceding-sibling::td/input[@name='contact_id']")
	WebElement contacttitle;
	public contactspage() {
		PageFactory.initElements(driver, this);
	}
	public void  verifycontacttitlename(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input[@name='contact_id")).click();		 
	}
	public  void createcontactdetails(String Title,String firstnamez, String lastname, String comp) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(Title);
		firstname.sendKeys(firstnamez);
		
		
	}
	
	
}
