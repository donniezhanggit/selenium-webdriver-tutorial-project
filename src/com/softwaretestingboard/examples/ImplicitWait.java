package com.softwaretestingboard.examples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		String exePath = "drivers\\MicrosoftEdgeDriver\\MicrosoftWebDriver.exe";
		System.out.println("launching Microsoft Edge browser");
		System.setProperty("webdriver.edge.driver", exePath);

		// launching Microsoft Edge Driver

		WebDriver driver = new EdgeDriver();
		// Setting implicit wait of 10 seconds

		driver.get("https://www.gmail.com");
		// check for title
		String expTitle = "Gmail";
		String actTitle = "";
		// Maximizes the browser window
		driver.manage().window().maximize();
		// get the actual value of the title
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		actTitle = driver.getTitle();
		System.out.println("The actual title is " + actTitle);
		// compare the actual title with the expected title
		if (actTitle.equals(expTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		// close browser
		driver.close();

	}

}
