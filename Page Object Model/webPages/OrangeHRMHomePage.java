package webPages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class OrangeHRMHomePage {
	
	WebDriver driver;

    By homePageUserName = By.linkText("Welcome Hemant");
    
    By LogoutLink = By.linkText("Logout");

    

    public OrangeHRMHomePage(WebDriver driver){

        this.driver = driver;

    }
    
  //Get the User name from Home Page

    public String getHomePageDashboardUserName(){

     return    driver.findElement(homePageUserName).getText();

    }
    
    // Logout from orangeHRM application
    
    public void applicationLogoutAction(){
    	 driver.findElement(homePageUserName).click();
    	 driver.findElement(LogoutLink).click();
    }

}
