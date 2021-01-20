package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.ElementUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// by locators

	By contacts = By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a");
	By checkbox = By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[3]/td[1]/input");
	By dropdown = By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[2]/td[2]/select");
	By doButton = By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[2]/td[2]/input");
	By newcontact = By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input[3]");
	By Title = By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select");
	By firstname = By.xpath("//*[@id=\"first_name\"]");
	By lastname = By.xpath("//*[@id=\"surname\"]");
	By Company = By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[8]/td[2]");
	By save = By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]");
	By home = By.xpath("//*[@id=\"navmenu\"]/ul/li[1]/a");
	By logotext = By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[1]");

	// Constructor of the page class

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// page actions

//	public void doClick() {
//		driver.switchTo().frame("mainpanel");
//		elementUtil.doClick(contacts);
//	}

//	public void deleteAll() {
//		elementUtil.clickWhenReady(checkbox, 1);
//		elementUtil.doSelectValuesByVisibleText(dropdown, "Delete Checked");
//		elementUtil.doClick(doButton);
//		driver.switchTo().alert().accept();
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void createNewContact(String Title, String firstname, String lastname, String Company) {

		driver.switchTo().frame("mainpanel");
		elementUtil.doClick(contacts);
		elementUtil.doClick(newcontact);
		elementUtil.doSelectValuesByVisibleText(this.Title, Title);
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doActionsSendKeys(this.Company, Company);
		elementUtil.doClick(save);
		driver.switchTo().defaultContent();   //swithc to parent window
		
		//elementUtil.doClick(home);
		//elementUtil.doGetText(logotext);
		
		

	}

}
