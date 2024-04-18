package automation_practice.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation_practice.AbstractComponet.Abstract_Component;


public class LandingPage  extends Abstract_Component{
WebDriver  driver;
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(LandingPage.class);

    public  LandingPage(WebDriver driver) {
    super(driver);  // life of the driver child to parent
        this.driver = driver; // life of the this class
        PageFactory.initElements(driver,this);  // life of the pageFactory
    }
    //driver.findElement(By.id("userEmail"))
    @FindBy (id ="userEmail")
    WebElement userEmail;
    @FindBy(id ="userPassword")
    WebElement userPassword;
    @FindBy(name = "login")
    WebElement login;
   // div[aria-label='Incorrect email or password.
   // .ng-tns-c4-7.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
   @FindBy(css = ".toast-error")
   WebElement errorMessage;

   By MessageBy = By.cssSelector(".toast-error");

 // credential for the application and login and returnning to the ProductCatalogue page
    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        logger.info("credential for the application and login  and returnning to the ProductCatalogue page");
        return productCatalogue;
    }

    // url for the application
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    //finding error message for incorrect password or mail and returned error message
    public String GetErrorMessage(){
        waitforElementToAppear(MessageBy);
        logger.info("finding error message for incorrect password or mail and returned error message");
        return errorMessage.getText();
    }
}
