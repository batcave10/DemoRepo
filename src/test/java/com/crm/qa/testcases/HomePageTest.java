package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutilpage;
	ContactsPage contactpage;
	Logger log = Logger.getLogger(HomePageTest .class);
	
	public HomePageTest() {
		super(); 	
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage = new LoginPage();
		 testutilpage = new TestUtil();
		 contactpage = new ContactsPage();
		 homepage = loginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home PageTitle not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel() {
		testutilpage.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLink() {
		testutilpage.switchToFrame();
		contactpage = homepage.clickOnContacsLink();
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
	
}
