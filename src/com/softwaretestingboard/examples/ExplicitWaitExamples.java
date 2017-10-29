package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExamples {

	public void explicitwait() throws InterruptedException {

		String exePath = "drivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		// click on forgotten password
		driver.findElement(By.linkText("Forgotten account?")).click();
		// setting a default wait time for timeout
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// setting a wait condition till the "ForgottenPassword" link is not
		// visible
		WebElement clickonLink;
		clickonLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgotten account?")));
		clickonLink.click();
		System.out.println("Test case passed");
		driver.close();

	}

}
