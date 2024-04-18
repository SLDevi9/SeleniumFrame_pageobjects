package automation_practice.AbstractComponet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation_practice.pageobjects.CartPage;
import automation_practice.pageobjects.MyOrdersPage;

import java.time.Duration;

public class Abstract_Component {


    WebDriver driver;
@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
WebElement cartHeader;

@FindBy(css ="button[routerlink='/dashboard/myorders']")
WebElement myOrder;

    public Abstract_Component(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CartPage gotoCartpage(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public MyOrdersPage MyOrderpage(){
        myOrder.click();
        MyOrdersPage orders = new MyOrdersPage(driver);
        return orders;
    }



    public void waitforElementToAppear(By findBy){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
    public void waitforElementToDisAppear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedConditions.invisibilityOf(ele)));
    }

    public void performaction(){
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.xpath("//input[contains(@placeholder,'Select Country')]")), "india").build()
                .perform();
    }
}
