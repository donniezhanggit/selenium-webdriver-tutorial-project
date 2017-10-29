package com.softwaretestingboard.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticWebtableExample {

	public static void main(String[] args) {
		String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		String URL = "C:\\Users\\HEMANT\\Desktop\\tutorials\\Selenium\\SoftwareTestingBoard\\StaticExample.html";
		// navigateTo use
		driver.navigate().to(URL);
		// Locating Webtable Element "Onida"
		String name = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Tagname is " + name);
		driver.quit();

	}

}
