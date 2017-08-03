package com.qait.automation.mail.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.mail.utils.DataProviders;
import com.qait.automation.mail.utils.LocatorReader;

public class MailAutomation {
	public LocatorReader lr;
	public TestSessionInitiator ti;
	public String username;
	public String password;

	WebDriverWait wait;

	WebElement element;

	@BeforeMethod()
	public void initSession() throws IOException {
		ti = new TestSessionInitiator();
	}

	@Test
	public void T1_verifyLoginFunctionality() throws IOException, InterruptedException {
		System.out.println("Executing test to check user is able to login");

		ti.loginPage.verifyLogin();
	}

	@Test(dataProvider = "mydata", dataProviderClass = DataProviders.class)
	public void T2_verifyComposeNewMailFunctionality(String p1, String p2, String p3)
			throws IOException, InterruptedException {
		System.out.println("Executing composing a new mail");
		Thread.sleep(5000);
		ti = new TestSessionInitiator();
		ti.loginPage.verifyLogin();
		ti.composenewmail.verifyComposeMail(p1, p2, p3);

	}

	@AfterTest()
	public void destroySession() throws IOException {
		ti.closeSession();
	}

}
