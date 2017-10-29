package com.softwaretestingboard.examples.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IframesExe {

	public static WebDriver driver;

	String baseUrl = "https://softwaretestingboard.com/tutorials/iframe-sample/";

	@Test
	public void loginAction() {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		driver = new FirefoxDriver(options);
		// launch Browser
		driver.get(baseUrl);

		// By finding all the web elements using iframe tag
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The number of Iframes in the webpage are " + size);

		// Switch to second frame by index note index start's with 0
		driver.switchTo().frame(1);
		System.out.println("We have switched to second Iframe");

		// Switch to frame by name

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("iframe1");
		System.out.println("we have switched to first iframe by name");

		// Switch by frame ID
		driver.switchTo().frame("iframe1");
		System.out.println("We have switched to iframe by id");

		// Switch to frame by WebElement
		// First find the element using any of locator stratedgy
		WebElement iframeElement = driver.findElement(By.id("iframe2"));

		// now use the switch command
		driver.switchTo().frame(iframeElement);

		System.out.println("We have  switched to iframe by Webelement");

		// Switch back to the main window
		driver.switchTo().defaultContent();

		// quit the driver
		driver.quit();

	}

}