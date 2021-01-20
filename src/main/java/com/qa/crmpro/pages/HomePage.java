package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By locators

	By UserDetails = By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]");

	By logotext = By.xpath("//td[@class=\"logo_text\"]");

	// Constructor of the page class

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// Page actions:

	public String getUserDetailsTest() {
		driver.switchTo().frame("mainpanel");
		return elementUtil.doGetText(UserDetails);

	}

	public String getLogoTextTest() {
		return elementUtil.doGetText(logotext);

	}

}
