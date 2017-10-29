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
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

public class TestNGParExe {

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
	// by using @Parameter we will pass the value to the function

	@Test
	@Parameters({ "sUsername", "sPassword" })
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
