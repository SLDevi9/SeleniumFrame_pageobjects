package automation_practice.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation_practice.AbstractComponet.Abstract_Component;

public class ConfirmationPage extends Abstract_Component {
    WebDriver driver;
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ConfirmationPage.class);
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".hero-primary")
    WebElement confirmationMessage;

By primary = By.cssSelector(".hero-primary");

    public String verifyConfirmationMessage(){
        System.out.println("verifyConfirmationMessage");
        waitforElementToAppear(primary);
        return confirmationMessage.getText();
    }

}
