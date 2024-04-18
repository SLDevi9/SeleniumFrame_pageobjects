package automation_practice.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation_practice.AbstractComponet.Abstract_Component;

import java.util.List;

public class CartPage extends Abstract_Component {
WebDriver  driver;
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

@FindBy(xpath = "//div[@class='cartSection']/h3")
    private List<WebElement> cartProducts;
@FindBy(css =".totalRow button")
WebElement Checkoutele;

    public Boolean VerifyProductDisplay(String productName){
        Boolean match = cartProducts.stream()
        .anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
        logger.info("verifying selected items in the cart page");
       return match;
    }

    public CheckoutPage goToCheckout(){
        Checkoutele.click();
        logger.info("retured to the checkout page");
    return new CheckoutPage(driver);
    }

//    List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3")); // finding selected products
//    Boolean match = cartproducts.stream()
//            .anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productItem));
//        Assert.assertTrue(match);  /// verifying product name
//    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow
//    // button")));
//        driver.findElement(By.cssSelector(".totalRow button")).click();
}


