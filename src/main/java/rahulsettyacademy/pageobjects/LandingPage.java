package rahulsettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsettacademy.AbstractComponet.Abstract_Component;


public class LandingPage  extends Abstract_Component{
WebDriver  driver;

    public  LandingPage(WebDriver driver) {
super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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

    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public String GetErrorMessage(){
        waitforElementToAppear(MessageBy);
        return errorMessage.getText();
    }
}
