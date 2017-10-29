package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenShot {

	WebDriver driver;

	public ScreenShot(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 */

	public void takeScreenShot(WebDriver ldriver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File("screenshots" + System.currentTimeMillis() + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

}
