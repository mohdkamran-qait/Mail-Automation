package com.qait.automation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qait.automation.mail.keywords.ComposeMailActions;
import com.qait.automation.mail.keywords.LoginPageActions;
import com.qait.automation.mail.utils.LocatorReader;

public class TestSessionInitiator {

	WebDrivers wd = new WebDrivers();
	public WebDriver driver;
	public LoginPageActions loginPage;
	public ComposeMailActions composenewmail;
	LocatorReader lr;
	String username;
	String password;

	public TestSessionInitiator() throws IOException {
		// TODO Auto-generated constructor stub

		try {
			wd.load_config_properties_file();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = wd.getBrowser();
		driver.manage().window().maximize();
		try {
			initActionClasses();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initActionClasses() throws IOException, InterruptedException {
	
		loginPage = new LoginPageActions(driver);
		composenewmail = new ComposeMailActions(driver);
	}

	public void closeSession() {
		// TODO Auto-generated method stub
		driver.quit();
	}

}
