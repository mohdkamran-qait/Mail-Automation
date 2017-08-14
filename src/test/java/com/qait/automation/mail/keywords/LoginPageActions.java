package com.qait.automation.mail.keywords;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.automation.WebDrivers;
import com.qait.automation.mail.utils.LocatorReader;
import com.qait.automation.mail.utils.SpecFileReader;

public class LoginPageActions {
	SpecFileReader sr = new SpecFileReader();
	WebDriver driver;
	String username;
	String password;
	String base_url;

	LocatorReader lr;

	public LoginPageActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.lr = new LocatorReader("src/test/resources/locators/locators.spec");
	}

	public void verifyLogin() throws IOException, InterruptedException {

		base_url = sr.loadBaseUrl();
		username = sr.loadusername();
		password = sr.loadpassword();

		
		driver.get(base_url);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("input_username")));
		driver.findElement(lr.getlocator("input_username")).sendKeys(username);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("input_password")));
		driver.findElement(lr.getlocator("input_password")).sendKeys(password);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("loginPage_signinButton")));
		driver.findElement(lr.getlocator("loginPage_signinButton")).click();

		//Thread.sleep(5000);
	}

	
}