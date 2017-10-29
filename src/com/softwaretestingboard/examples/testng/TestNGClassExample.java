package com.softwaretestingboard.examples.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;

public class TestNGClassExample {

	public static WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		String actualText = "";

		// • Enter Username:"hemantvarhekar310@gmail.com"
		driver.findElement(By.id("identifierId")).sendKeys("hemantvarhekar310@gmail.com");

		// Click on next button
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		// thread to wait for some time before executing next action
		Thread.sleep(2000);
		// Enter Password
		WebElement txtbox_password = driver.findElement(By.name("password"));

		if (txtbox_password.isEnabled()) {
			txtbox_password.sendKeys("Test@1234");
		}

		// Click on next button
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();

		// wait some time till the page load
		Thread.sleep(1000);
		actualText = driver.getPageSource();

		if (actualText.contains("Welcome")) {
			System.out.println("We have sucessfully logged in!");
		} else {
			System.out.println("Login is unsuccessful");
		}

	}

	@BeforeMethod
	public void beforeMethod() {

		// add the desired compatilibities
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		driver = new FirefoxDriver(capabilities);

		// declaration of variables
		String baseUrl = "https://accounts.google.com/ServiceLogin?sacu=1&rip=1#identifier";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
