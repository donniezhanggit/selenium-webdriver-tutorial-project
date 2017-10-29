package com.softwaretestingboard.examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {
	public static void main(String[] args) throws InterruptedException {

		String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.get("C:\\Users\\HEMANT\\Desktop\\tutorials\\Selenium\\SoftwareTestingBoard\\Month.html");

		WebElement element = driver.findElement(By.name("Month"));
		Select se = new Select(element);
		// Here we will take multi select dropdown to show you the difference
		se.selectByVisibleText("Jan");
		se.selectByValue("2");
		se.deselectByVisibleText("March");

		// From the above two commands, in the dropdown two values will be
		// selected.
		// Now we will try to deselect any of the One
		// Im using thread to see the difference when selecting and selecting
		Thread.sleep(3000);
		se.deselectByValue("2");

		// You can deselect the value by specifying the index, value and
		// VisibleText

		// It will work if you the index is already selected
		se.deselectByIndex(1);

		// It will deselect if the visible text jan is in selected mode
		se.deselectByVisibleText("Jan");

		// It will de-select all the values which are selected
		se.deselectAll();

		// Get the size of the Select element
		List<WebElement> oSize = se.getOptions();
		int iListSize = oSize.size();

		// Setting up the loop to print all the options
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = se.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal
			// to 'Africa" then select it
			if (sValue.equals("Africa")) {
				se.selectByIndex(i);
				break;
			}
		}

		Thread.sleep(2000);

	}
}
