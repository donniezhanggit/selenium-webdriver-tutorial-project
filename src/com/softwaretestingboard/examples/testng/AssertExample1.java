package com.softwaretestingboard.examples.testng;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExample1 {

	public static WebDriver driver;

	String baseUrl = "http://demo.ohrm.softwaretestingboard.com";

	@Test
	public void loginAction() {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		driver = new FirefoxDriver(options);
		// launch Browser
		driver.get(baseUrl);

		// Enter Username
		driver.findElement(By.id("txtUsername")).sendKeys("hemant");
		// Enter Password
		driver.findElement(By.name("txtPassword")).sendKeys("hemant@123");
		// Here driver will try to find out login button on the application
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		// Test will be only continue, if the below statement is true
		// This is to check whether the link is displayed or not

		Assert.assertTrue(loginBtn.isDisplayed());

		// loginBtn will be clicked only if the above condition is true

		loginBtn.click();

		driver.findElement(By.linkText("Welcome Hemant")).click();
		driver.findElement(By.linkText("Logout")).click();

	}

}
