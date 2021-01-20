package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.testlisteners.TestAllureListener;
import com.qa.crmpro.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic -100 Design CRM loginPage features ")
@Feature("UK-103 Design Login page Title,SignupLink and login form modules")
@Listeners(TestAllureListener.class)

public class LoginPageTest extends BaseTest {

	
	
	@Description("Verify the singup link on loginpage")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void verifySingUpLinkTest() {
		Assert.assertEquals(loginPage.isSingUpLinkExists(), true);

	}

	@Description("Verify the LoginPageTitle on loginpage")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyLoginPageTitle() {

		String title = loginPage.getPageTitle(driver);

		System.out.println("Page title is: " + title);

		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	
	@Description("Verify the LoginDetails on loginpage")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void verifyDoLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

}
