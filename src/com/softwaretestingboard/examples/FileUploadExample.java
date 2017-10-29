package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {

		String exePath = "drivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		String URL = "file:///C:/Users/HEMANT/Desktop/tutorials/Selenium/SoftwareTestingBoard/fileUpload.html";
		// navigateTo use
		driver.navigate().to(URL);
		WebElement element = driver.findElement(By.name("uploadsubmit"));
		// To input the filename along with path
		element.sendKeys("D:/NewFile.txt");
		// To click on the submit button (Not the browse button)
		driver.findElement(By.name("SUBMITBtn")).click();
		System.out.println("File uploaded successfully");
		// Closing the Driver
		driver.close();

	}

}
