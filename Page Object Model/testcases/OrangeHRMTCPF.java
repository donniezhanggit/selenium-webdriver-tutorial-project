package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageFactory.OrangeHRMHomePF;
import pageFactory.OrangeHRMLoginPF;
import screenShot.ScreenShot;

public class OrangeHRMTCPF {

	WebDriver driver;

	OrangeHRMLoginPF objLogin;

	OrangeHRMHomePF objHomePage;

	ScreenShot objScreenShot;

	@BeforeTest

	public void setup() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.ohrm.softwaretestingboard.com");

	}

	/**
	 * 
	 * This test case will login in http://demo.ohrm.softwaretestingboard.com
	 * 
	 * Verify Home page title as "Welcome Hemant"
	 * 
	 * Login to application
	 * 
	 * @throws Exception
	 * 
	 * 
	 */

	@Test(priority = 0)

	public void test_Home_Page_Appear_Correct() throws Exception {

		objScreenShot = new ScreenShot(driver);
		// Taking screen shot
		objScreenShot.takeScreenShot(driver);

		// Create Login Page object

		objLogin = new OrangeHRMLoginPF(driver);

		// login to application

		objLogin.LoginOrangeHRM("hemant", "hemant@123");

		// go the next page

		objHomePage = new OrangeHRMHomePF(driver);

		// Verify home page

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Welcome Hemant"));

		// Taking screen shot of home page
		objScreenShot.takeScreenShot(driver);

		// Logout from OrangeHRM
		objHomePage.applicationLogoutAction();

		// Taking screen shot of login page
		objScreenShot.takeScreenShot(driver);

	}

}
