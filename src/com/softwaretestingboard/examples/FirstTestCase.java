package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// if You are using latest version of Selenium WebDriver i.e. Selenium
		// 3.x, this version of webdriver doesn't support direct firefox launch.
		// You have to set the SystemProperty for webdriver.gecko.driver.

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
		WebDriver driver = new FirefoxDriver(firefoxOptions);

		// WebDriver driver;
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		// System.setProperty("webdriver.firefox.marionette",
		// "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-2.53.0\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		// driver =new FirefoxDriver();

		String baseUrl = "https://accounts.google.com/ServiceLogin?sacu=1&rip=1#identifier";
		String expectedTitle = "Sign in - Google Accounts";
		String actualTitle = "";
		String expectedText = "Welcome, hemant varhekar";
		String actualText = "";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		/*
		 * compare the actual title of the page witht the expected one and print
		 * the result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Title matched proceeding for next action!");
			// • Enter Username:"hemantvarhekar310@gmail.com"
			driver.findElement(By.id("identifierId")).sendKeys("hemantvarhekar310@gmail.com");

			// Click on next button
			driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
			Thread.sleep(2000);
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

		} else {
			System.out.println("Test Failed");
		}

		// close Firefox
		driver.quit();

	}

}
