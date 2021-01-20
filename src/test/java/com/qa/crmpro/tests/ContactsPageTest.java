package com.qa.crmpro.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.testlisteners.TestAllureListener;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic -99 Design CRM loginPage features ") // epic
@Feature("UK-90 Design Login page Title,SignupLink and login form modules") //user stroy
@Listeners(TestAllureListener.class) // for screen shots

public class ContactsPageTest extends BaseTest {

	
	@Description("Verify the CreateNewContacts on homepage")
	@Severity(SeverityLevel.NORMAL)
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}
	@Description("Verify the getconatcts on homepage")
	@Severity(SeverityLevel.CRITICAL)
	@Test( dataProvider = "getContactsTestData")
	public void createNewContactTest(String Title, String firstname, String lastname, String Company) {
		contactsPage.createNewContact(Title, firstname, lastname, Company);

	}

}
