package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverExample {
	public static WebDriver driver;

	public static void main(String[] args) {
		String exePath = "drivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		// launch Facebook.com using get

		String url = "https://www.facebook.com";
		driver.get("https://www.facebook.com");
		String tagName = "";

		// Storing Title name in the String variable
		String title = driver.getTitle();

		// Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();

		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		// Storing Current URL in String variable
		String actualUrl = driver.getCurrentUrl();

		// Adding a check to match the actual vs expected URL
		if (actualUrl.equals(url)) {
			System.out.println("Verification Successful - The correct Url is opened.");
		} else {
			System.out.println("Verification Failed - An incorrect Url is opened.");
			// In case of Fail, you like to print the actual and expected URL
			// for the record purpose
			System.out.println("Actual URL is : " + actualUrl);
			System.out.println("Expected URL is : " + url);
		}

		// Storing Page Source in the String variable
		String pageSource = driver.getPageSource();

		// Storing Page Source length in Int variable
		int pageSourceLength = pageSource.length();

		// Printing length of the Page Source on console
		System.out.println("Total length of the Pgae Source is : " + pageSourceLength);

		// find element by ID to get the tagname of inputbox
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagName);

		if (tagName.contains("input")) {
			System.out.println("Test passed");
		}

		else
			System.out.println("Test Failed");

		driver.quit();
	}

}
