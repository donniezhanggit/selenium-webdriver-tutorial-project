package com.softwaretestingboard.examples.multisession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftwareTestingMultipleSession {

	String baseUrl = "http://demo.ohrm.softwaretestingboard.com";

	// Session 1 code of login
	@Test

	public void executionSessionone() {

		String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
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

		// close the browser

		driver.close();

	}

	// Session 2 code of login

	@Test

	public void executionSessionTwo() {
		String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
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

		// close the browser
		driver.close();
	}

}
