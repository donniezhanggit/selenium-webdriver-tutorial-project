package com.softwaretestingboard.examples.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softwaretestingboard.utility.ExcelUtilsKey;

public class DataProviderWithExcel {
	public static WebDriver driver;

	String baseUrl = "http://opensource.demo.orangehrmlive.com/";

	@BeforeMethod
	public void beforeLogin() {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		driver = new FirefoxDriver(options);
		// launch Browser
		driver.get(baseUrl);

	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		// We are calling method name GetTableArray to read the data from
		// TestData.xlsx
		Object[][] testObjArray = ExcelUtilsKey.getTableArray(
				"C:\\Users\\HEMANT\\workspace\\OnlineAutomation\\src\\externalTestData\\TestData.xlsx", "Sheet1");

		return (testObjArray);

	}

	// Here we are calling the Data Provider object with its Name

	@Test(dataProvider = "Authentication")

	public void test(String sUsername, String sPassword) {

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

	@AfterMethod

	public void logoutAction() {
		driver.close();

	}

}
