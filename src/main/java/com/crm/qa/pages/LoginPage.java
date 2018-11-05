package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//pagefactory - OR
	@FindBy(name="username")
	@CacheLookup
	WebElement username;

	@FindBy(name="password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement loginbtn;

	@FindBy(xpath="//*[@id='navbar-collapse']/ul/li[2]/a")
	@CacheLookup
	WebElement signupbtn;
	
	//@FindBy(xpath="//img[containts(@class,'img-responsive')]")
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	@CacheLookup
	WebElement crmLogo;
	
	//Initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		 return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage validateLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		js.executeScript("arguments[0].click();", loginbtn);
		return new HomePage();	
	}
}
