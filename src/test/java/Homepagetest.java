import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactspage;
import com.crm.qa.util.TestUtil;

public class Homepagetest extends Baseclass  {

	Loginpage loginpage;
	com.crm.qa.pages.homepage homepage;
	TestUtil testutil;
	contactspage contactpage;

	public Homepagetest()

	{
		super();
	}

	@BeforeMethod
	public void setup() {
		Initproperty();
		loginpage = new Loginpage();
		testutil=new TestUtil();
		contactpage=new contactspage();
		homepage=loginpage.logintest(pro.getProperty("usernme"), pro.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyhomepagetitle() {
		 String homepagetitle=homepage.verifytitlepage();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title is not available");
	}
	@Test(priority=2)
	public void  verifyusernametest() {
		testutil.switchtoframe("mainframe");
		Assert.assertTrue(homepage.verifyusername());
	}
		@Test(priority=3)
				public void verifycontactlinktest() {
			testutil.switchtoframe("mainframe");
			contactpage	=homepage.clickoncontactspage();			
		}
		
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
