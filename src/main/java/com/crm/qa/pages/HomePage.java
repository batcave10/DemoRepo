package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K ')]")
	@CacheLookup
	//@FindBy(xpath="User: Naveen K ")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@title='Contacts']")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@title='Deals']")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@title='Tasks']")
	@CacheLookup
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		String userLable = userNameLabel.getText();
		System.out.println(userLable);
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContacsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
