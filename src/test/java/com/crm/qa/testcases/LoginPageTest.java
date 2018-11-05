package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;


public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	/*
	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	*/
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
}
