import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactspage;
import com.crm.qa.util.TestUtil;

public class Contactspage extends Baseclass {
	Loginpage loginpage;
	com.crm.qa.pages.homepage homepage;
	TestUtil testutil;
	contactspage contactpage;
	String sheetname="Contacts ";
	public Contactspage() {
		super();
		
	}
	@BeforeMethod
	public void setup() {
		Initproperty();
		loginpage = new Loginpage();
		testutil=new TestUtil();
		contactpage=new contactspage();
		testutil.switchtoframe("mainframe");
		contactpage=homepage.clickoncontactspage();
		homepage=loginpage.logintest(pro.getProperty("usernme"), pro.getProperty("password"));		
	}
	@Test(priority=1)
	public void selectcontactstest() {
		
		contactpage.verifycontacttitlename("test2-test2");
	}
	@DataProvider
	public  Object[][] gettestdata() {
		  Object [][] data =testutil.gettestdatafromsheet(sheetname);
		  return data;		
	}
	@Test(priority=2)
	public void selectmultiplrcontactstest() {
			contactpage.verifycontacttitlename("lol");
	}
	
	@Test(priority=3, dataProvider="gettestdata")
	public void validatecreatenewcontacts(String Title , String firstname, String lastname, String company) {
		homepage.clickoncontacts();
		contactpage.createcontactdetails(Title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}


