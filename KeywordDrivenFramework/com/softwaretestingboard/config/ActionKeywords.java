package com.softwaretestingboard.config;

import static com.softwaretestingboard.examples.execution.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.softwaretestingboard.examples.execution.DriverScript;
import com.softwaretestingboard.utility.Log;

public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser(String object, String data) {
		Log.info("Opening Browser");
		try {
			if (data.equals("Mozilla")) {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", false);
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			} else if (data.equals("IE")) {

				String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\MicrosoftEdgeDriver\\MicrosoftWebDriver.exe";
				System.out.println("launching Microsoft Edge browser");
				System.setProperty("webdriver.edge.driver", exePath);

				// launching Microsoft Edge Driver

				driver = new EdgeDriver();

				Log.info("Internet Edge browser started");
			} else if (data.equals("Chrome")) {
				// Dummy Code, Implement you own code
				String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			}

			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void click(String object, String data) {
		try {
			Log.info("Clicking on Webelement " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void input(String object, String data) {
		try {
			Log.info("Entering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Not able to Enter UserName --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void waitFor(String object, String data) throws Exception {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error("Not able to Wait --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void closeBrowser(String object, String data) {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.error("Not able to Close the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

}