package com.softwaretestingboard.examples;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class IEDriverExample {

	public static void main(String[] args) {

		String exePath = "drivers\\iedriverserver\\IEDriverServer.exe";
		InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
		serviceBuilder.usingPort(1080); // This specifies that sever should
										// start at this port
		serviceBuilder.usingDriverExecutable(new File(exePath)); // Tell it
																	// where you
																	// server
																	// exe is
		serviceBuilder.withHost("3.4.0.0");
		InternetExplorerDriverService service = serviceBuilder.build(); // Create
																		// a
																		// driver
																		// service
																		// and
																		// pass
																		// it to
																		// Internet
																		// explorer
																		// driver
																		// instance
		InternetExplorerDriver driver = new InternetExplorerDriver(service);
		driver.get("https://www.facebook.com");
		String tagName = "";
		// find element by ID
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagName);
		driver.quit();

	}

}
