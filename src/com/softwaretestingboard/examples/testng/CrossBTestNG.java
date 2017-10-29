package com.softwaretestingboard.examples.testng;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBTestNG {
	public static WebDriver driver;

	String baseUrl = "http://opensource.demo.orangehrmlive.com/";

	@Parameters("browser")

	@BeforeClass

	// Passing Browser parameter from TestNG xml

	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this

		if (browser.equalsIgnoreCase("firefox")) {

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", false);
			FirefoxOptions options = new FirefoxOptions(capabilities);
			driver = new FirefoxDriver(options);

			// If browser is Chrome, then do this

		} else if (browser.equalsIgnoreCase("chrome")) {

			// Here I am setting up the path for my IEDriver

			String exePath = "drivers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();

		}

		// launch Browser
		driver.get(baseUrl);

	}

	String sUsername = "Admin";
	String sPassword = "admin";

	@Test
	public void loginAction() {

		// Enter Username
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		// Enter Password
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		// Here driver will try to find out login button on the application
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		// Test will be only continue, if the below statement is true
		// This is to check whether the link is displayed or not

		Assert.assertTrue(loginBtn.isDisplayed());

		// loginBtn will be clicked only if the above condition is true

		loginBtn.click();

	}

	@AfterClass

	public void logoutAction() {
		driver.close();

	}

}
