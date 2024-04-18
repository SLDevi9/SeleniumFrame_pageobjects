package automation_practice.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation_practice.AbstractComponet.Abstract_Component;

public class CheckoutPage extends Abstract_Component {
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(CheckoutPage.class);
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[contains(@placeholder,'Select Country')]")
    WebElement country;

    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
    WebElement submit;

    @FindBy(css =".list-group-item:nth-child(2)")
    WebElement selectcountry;

    By results = By.cssSelector(".ta-results");


    public void selectCountry(String countryName){
        Actions a = new Actions(driver);
      a.sendKeys(country, "india").build().perform();
      waitforElementToAppear(results);
      selectcountry.click();
      logger.info("selecting country in cheout page");
    }
public ConfirmationPage submitOrder(){
        submit.click();
        logger.info("returning to the order confirmation page");
       return new ConfirmationPage(driver);
}

}


//
//Actions a = new Actions(driver);
//        a.sendKeys(driver.findElement(By.xpath("//input[contains(@placeholder,'Select Country')]")), "india").build()
//                .perform(); // mouse overing to country name