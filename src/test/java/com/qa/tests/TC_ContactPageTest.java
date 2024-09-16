package com.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.constants.AppConstants;
import com.qa.pageObjects.ContactsPage;
import com.qa.utils.ElementUtil;

public class TC_ContactPageTest extends BaseClass {

	ContactsPage cp;
	ElementUtil eleUtil;
	AppConstants apc;
	

	@Test(dataProvider = "getTestData")
	public void verifyEmailIDTest(String fname, String lname, String email, String comment)
			throws InterruptedException {
		cp = new ContactsPage(driver);
		eleUtil = new ElementUtil(driver);
		cp.enterContactDetails(fname, lname, email, comment);
		cp.clickSubmitButton();
		Thread.sleep(3000);
		sf.assertTrue(cp.verifySuccessMessage(), "Invalid Email address");
		driver.navigate().back();
		sf.assertAll();
	   
	}

	@DataProvider
	public Object[][] getTestData() {
		return new Object[][] { { "Sudhir", "Dahiya", "sd12@gmail.com", "NA" },
				{ "Deepu", "Tiwari", "dt12234@gmail.com", "NA" }, { "Sahil", "Juneja", "sahil123@gmail.com", "NA" },
				{ "Varun", "Chawla", "vcgmail.com", "NA" }, { "Sudhir", "Dahiya", "sudhird99@gmail", "NA" },
				{ "Vishal", "Kumar", "vk1!2@gmail.com", "NA" }, 
				{"Mohit", "Kumar", "","NA"}};
	}

}
