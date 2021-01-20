package com.qa.crmpro.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.crmpro.pages.ContactsPage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage = new ContactsPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
