package com.softwaretestingboard.examples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadExample {

	public static void main(String[] args) {
		// Create a new profile
		FirefoxProfile profile = new FirefoxProfile();
		
		//Create firefox options
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		
		// Set preferences for file type
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
		
		firefoxOptions.setProfile(profile);
		
		// Open browser with profile
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		// Set Preference to not show file download confirmation dialogue using
		// MIME types Of different file extension types.

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximize window
		driver.manage().window().maximize();

		// Open APP to download application
		driver.get("http://www.filehippo.com/download_adobe_reader");

		// Click on download
		driver.findElement(By.xpath(".//*[@id='program-header']/div[4]/a[1]")).click();

	}

}
