package com.qait.automation.mail.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.mail.utils.DataProviders;
import com.qait.automation.mail.utils.LocatorReader;

public class MailAutomation {
	public LocatorReader lr;
	
	public String username;
	public String password;

	

//	@BeforeMethod
//	public void initSession() throws IOException, InterruptedException {
//		ti = new TestSessionInitiator();
//		ti.loginPage.verifyLogin();
//
//	}

	// @Test
	// public void T1_verifyLoginFunctionality() throws IOException,
	// InterruptedException {
	// System.out.println("Executing test to check user is able to login");
	//
	// ti.loginPage.verifyLogin();
	// }

	@Test(dataProvider = "mydata", dataProviderClass = DataProviders.class )
	public void T2_verifyComposeNewMailFunctionality(String p1, String p2, String p3)
			throws IOException, InterruptedException {
		TestSessionInitiator 	ti = new TestSessionInitiator();
		ti.loginPage.verifyLogin();
		System.out.println("Executing composing a new mail");

		System.out.println("p1:" + p1 + "p2:" + p2 + "p3:" + p3);
		ti.composenewmail.verifyComposeMail(p1, p2, p3);
		ti.closeSession();

	}

//	@AfterMethod
//	public void destroySession() throws IOException {
//
//	}

}
