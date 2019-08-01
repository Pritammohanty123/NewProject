package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.Baseclass;

public class Loginpage extends Baseclass {
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(linkText="Sign Up")
	WebElement signupbtn;
	public Loginpage () {
		PageFactory.initElements(driver, this);
	}
		
	public String verifypagetitle() {
		
	return driver.getTitle();
	}
	
	public homepage logintest (String un , String pwd) {
		username.sendKeys("tusharkec123");
		password.sendKeys("lenovopc@12");
		loginbtn.click();
		return new homepage ();
	
}

}


 