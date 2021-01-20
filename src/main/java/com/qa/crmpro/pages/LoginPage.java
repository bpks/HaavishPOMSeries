package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By locators _OR

	By Username = By.name("username");
	By Password = By.name("password");
	By Login = By.xpath("//*[@id=\"loginForm\"]/div/div/input");

	By SignUpLink = By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a");

	// Constructor of the page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		elementUtil = new ElementUtil(this.driver);

	}
	// page actions:
@Step("getting page title")
	public String getPageTitle(WebDriver driver) {
		// return driver.getTitle();
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);

	}

	public boolean isSingUpLinkExists() {
		// return driver.findElement(SignUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(SignUpLink);

	}

	public HomePage doLogin(String username, String Pswd) {
//		driver.findElement(Username).sendKeys(username);
//		driver.findElement(Password).sendKeys(Pswd);
//		driver.findElement(Login).click();

		elementUtil.waitForElementToBeVisible(Username, 10);
		elementUtil.doSendKeys(Username, username);
		elementUtil.doSendKeys(Password, Pswd);
		elementUtil.doClick(Login);
		return new HomePage(driver);
	}
	
	@Step("Login with user name {0}  and password {1}")

	public ContactsPage doLoginForContactsPage(String username, String Pswd) {
		elementUtil.waitForElementToBeVisible(Username, 10);
		elementUtil.doSendKeys(Username, username);
		elementUtil.doSendKeys(Password, Pswd);
		elementUtil.doClick(Login);
		return new ContactsPage(driver);
	}
}
