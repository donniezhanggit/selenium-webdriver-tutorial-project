package com.softwaretestingboard.examples.listners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.softwaretestingboard.examples.listners.Demo.class)

public class LoginTest {

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

		AssertJUnit.assertTrue(loginBtn.isDisplayed());

		// loginBtn will be clicked only if the above condition is true

		loginBtn.click();

		// click on logout button

		WebElement Select = (driver.findElement(By.xpath(".//*[@id='welcome']")));
		Select.findElement(By.linkText("Logout")).click();

	}

	// Forcefully failed this test as to verify listener.
	@Test
	public void TestToFail() {
		System.out.println("This method is added to test fail");
		AssertJUnit.assertTrue(false);
	}

	@AfterTest

	public void logoutAction() {
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.close();

	}

}
