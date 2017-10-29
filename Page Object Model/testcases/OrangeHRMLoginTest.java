package testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import webPages.OrangeHRMHomePage;

import webPages.OrangeHRMLoginPage;


public class OrangeHRMLoginTest {

	
    WebDriver driver;

    OrangeHRMLoginPage objLogin;

    OrangeHRMHomePage objHomePage;

    

    @BeforeTest

    public void setup(){
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);

        driver = new FirefoxDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.ohrm.softwaretestingboard.com");

    }

    /**

     * This test case will login in http://demo.ohrm.softwaretestingboard.com

     * Verify Home page title as "Welcome Hemant"

     * Login to application


     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object

    objLogin = new OrangeHRMLoginPage(driver);



    //login to application

    objLogin.LoginOrangeHRM("hemant", "hemant@123");

    // go the next page

    objHomePage = new OrangeHRMHomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Welcome Hemant"));
    
    // Logout from OrangeHRM
    objHomePage.applicationLogoutAction();
    

}
}
