package com.softwaretestingboard.examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframesExample {

	WebDriver driver;

	@BeforeTest

	public void setup() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);

		driver = new FirefoxDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://softwaretestingboard.com/tutorials/iframe-sample/");

	}

	@Test

	public void iframestest() throws Exception {

		// By finding all the web elements using iframe tag
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total number of iframes are " + size);

	}

}
