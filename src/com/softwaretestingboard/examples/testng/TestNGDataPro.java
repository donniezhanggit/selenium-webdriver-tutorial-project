package com.softwaretestingboard.examples.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class TestNGDataPro {

	public static WebDriver driver;

	String baseUrl = "http://opensource.demo.orangehrmlive.com/";

	@BeforeTest
	public void beforeLogin() {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		driver = new FirefoxDriver(options);
		// launch Browser
		driver.get(baseUrl);

	}
	// Here we are initializing @DataProvider

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "Admin", "admin" } };

	}

	//// Here we are calling the Data Provider object with its Name :
	//// "Authentication"
	@Test(dataProvider = "Authentication")

	public void loginAction(@Optional("Abc") String sUsername, @Optional("Abcd") String sPassword)
			throws InterruptedException {

		// Enter Username
		driver.findElement(By.id("txtUsername")).sendKeys(sUsername);
		// Enter Password
		driver.findElement(By.name("txtPassword")).sendKeys(sPassword);
		// Here driver will try to find out login button on the application
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));

		// Test will be only continue, if the below statement is true
		// This is to check whether the link is displayed or not

		Assert.assertTrue(loginBtn.isDisplayed());

		// loginBtn will be clicked only if the above condition is true

		loginBtn.click();

	}

	@AfterTest

	public void logoutAction() {
		driver.close();

	}

}
