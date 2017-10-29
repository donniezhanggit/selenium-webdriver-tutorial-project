package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MicrosoftEdge {

	public static void main(String[] args) {
		String exePath = "drivers\\MicrosoftEdgeDriver\\MicrosoftWebDriver.exe";
		System.out.println("launching Microsoft Edge browser");
		System.setProperty("webdriver.edge.driver", exePath);

		// launching Microsoft Edge Driver

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com");
		String tagName = "";
		// find element by ID
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagName);
		driver.quit();
		//
	}

}
