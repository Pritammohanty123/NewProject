import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.Loginpage;

public class Loginpagetest extends Baseclass {
	Loginpage loginpage;
	com.crm.qa.pages.homepage homepage;

	public Loginpagetest()

	{
		super();
	}

	@BeforeMethod
	public void setup() {
		Initproperty();
		loginpage = new Loginpage();
	}

	@Test
	public void verifyloginpage() {
		String title = loginpage.verifypagetitle();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support");
	}

@Test
public void login() {
	homepage=loginpage.logintest(pro.getProperty("usernme"), pro.getProperty("password"));
	
}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
