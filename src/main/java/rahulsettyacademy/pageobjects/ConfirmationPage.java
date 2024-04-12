package rahulsettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsettacademy.AbstractComponet.Abstract_Component;

public class ConfirmationPage extends Abstract_Component {
    WebDriver driver;

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
