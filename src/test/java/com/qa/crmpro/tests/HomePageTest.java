package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Epic -101 Design CRM HomePage features ")
@Feature("UK-104 Design Home page Title,SignupLink and login form modules")

public class HomePageTest extends BaseTest {
	@Description("Verify the HomePageTitle on homepage")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifygetUserDetailsTest() {
		String userdetails = homePage.getUserDetailsTest();
		System.out.println(userdetails);
		Assert.assertEquals(userdetails, Constants.HOME_PAGE_USER);

	}
	

}
