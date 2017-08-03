package com.qait.automation.mail.keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.Yaml;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.WebDrivers;
import com.qait.automation.mail.utils.LocatorReader;


public class HomePageActions {
	
	File file;
	File newfile;
	InputStream yamlfile;
	Yaml yaml;
	String url;
	String title;
	Map<String, Object> yamlreader;
	Map<String, String> userdetails;
	WebDrivers wd = new WebDrivers();
	WebDriver myDriver;
	TestSessionInitiator ti;
	LocatorReader lr;
	String username;
	String password;
	String base_url;


	public void ReadYamlFile() throws FileNotFoundException {
		file = new File("src/test/resources/mail.yml");
		newfile = new File("src/test/resources/newfile.yml");

		yamlfile = new FileInputStream(file);
		yaml = new Yaml();
		yamlreader = (Map<String, Object>) yaml.load(yamlfile);
		url = (String) yamlreader.get("base_url");
		title = (String) yamlreader.get("landingPageTitle");

		userdetails = (Map<String, String>) yamlreader.get("credentials");

		String username = userdetails.get("username");
		String password = userdetails.get("password");

	}


	public void Login() throws IOException {
		ti = new TestSessionInitiator();
		//myDriver.get(base_url);
		//myDriver.get("https://webmail.qainfotech.com/");
//		myDriver.findElement(lr.getlocator("tab_loginPage")).click();
//		myDriver.findElement(lr.getlocator("input_username")).sendKeys(username);
//		myDriver.findElement(lr.getlocator("input_password")).sendKeys(password);
//		myDriver.findElement(lr.getlocator("loginPage_submitButton")).click();
	}

}
