package com.softwaretestingboard.examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebtableExample {

	public static void main(String[] args) {

		String exePath = "C:\\Users\\HEMANT\\Desktop\\Softwares\\selenium-java-3.4.0\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		String URL = "http://money.rediff.com/gainers/bsc/daily/groupa";
		// navigateTo use
		driver.navigate().to(URL);

		// No.of Columns
		List<WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th[1]"));
		System.out.println("No of cols are : " + col.size());
		// No.of rows
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("No of rows are : " + rows.size());
		// Fetching the Cell value of 8 th row 2nd coloumn
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement baseTable = driver.findElement(By.tagName("table"));

		// To find 8th row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[8]"));

		// WebElement tableRowText = baseTable.findElement(By.xpath
		// ("//*[@id='leftcontainer']/table/tbody/tr[8]/td[1]"));

		String rowtext = tableRow.getText();
		System.out.println("8th row of table : " + rowtext);

		// to get 8rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[8]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed);
		driver.close();

	}

}
