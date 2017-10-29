package pageFactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class OrangeHRMHomePF {
	
	WebDriver driver;

    @FindBy (linkText = "Welcome Hemant")
    
    WebElement homePageUserName;

    @FindBy (linkText= "Logout")

    WebElement LogoutLink;

    

    public OrangeHRMHomePF(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    

    //Get the User name from Home Page

        public String getHomePageDashboardUserName(){

         return    homePageUserName.getText();

        }
        
        
     // Logout from orangeHRM application
        
        public void applicationLogoutAction(){
        	homePageUserName.click();
        	LogoutLink.click();
        }



}
