package com.qait.automation.mail.keywords;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.automation.mail.utils.DataProviders;
import com.qait.automation.mail.utils.LocatorReader;

public class ComposeMailActions {

	WebDriver driver;
	LocatorReader lr;
	DataProviders dp;

	public ComposeMailActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.lr = new LocatorReader("src/test/resources/locators/locators.spec");
	}

	public void verifyComposeMail(String p1, String p2, String p3) throws IOException, InterruptedException {
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 500);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("newmessage_button")));
		driver.findElement(lr.getlocator("newmessage_button")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("sendto_tab")));
		driver.findElement(lr.getlocator("sendto_tab")).sendKeys(p1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("subject_tab")));
		driver.findElement(lr.getlocator("subject_tab")).sendKeys(p2);

		Thread.sleep(2000);

		driver.switchTo().frame("ZmHtmlEditor1_body_ifr");

		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("messagebody_box")));
		driver.findElement(lr.getlocator("messagebody_box")).sendKeys(p3);

		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lr.getlocator("sendmail_button")));
		driver.findElement(lr.getlocator("sendmail_button")).click();

	}
}