package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigationcommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String exePath = "drivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		String URL = "http://www.facebook.com";
		// navigateTo use
		driver.navigate().to(URL);
		System.out.println("The facebook is launches successfully");
		// navigate refresh
		driver.navigate().refresh();
		System.out.println("The browser is refreshed");

		driver.findElement(By.linkText("Forgotten account?")).click();
		// navigate back
		driver.navigate().back();
		System.out.println("performed click on back browser button");
		Thread.sleep(1000);
		// navigate forward
		driver.navigate().forward();
		System.out.println("navigated again back to forgot password page");
		// closing the browser
		driver.close();
		System.out.println("The browser is closed successfully and test is passed");
	}

}
