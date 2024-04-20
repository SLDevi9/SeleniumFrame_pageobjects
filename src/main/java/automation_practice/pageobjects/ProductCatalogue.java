package automation_practice.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation_practice.AbstractComponet.Abstract_Component;

import java.util.List;

public class ProductCatalogue extends Abstract_Component {
WebDriver  driver;
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ProductCatalogue.class);

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (css =".mb-3")
  List<WebElement> products;

    @FindBy (css =".ng-animating")
    WebElement spinner;

    By productBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.id("toast-container");

    //collecting list of Elements
    public List<WebElement> getProductList() {
        waitforElementToAppear(productBy);
        logger.info("Collecting list of Elements and returned elements");
        return products;
    }
    //getProductList() is likely a method that returns a list of products.
    //.stream() is used to convert the list into a stream, which allows for functional-style operations.
    //.filter() is applied to the stream to retain only those elements (products) that satisfy the given condition.
    //Inside the filter, product is an individual element (product) in the stream, and product.findElement(By.cssSelector("b")).getText().equals(ProductName)
    // is the condition. It checks if the text of the element found by the CSS selector "b" within the product matches the specified ProductName.
    //.findFirst() is called to retrieve the first element that matches the filter condition. If no such element is found, it returns an empty Optional.
    //.orElse(null) is used to return the found element if present, or null if no element matches the filter condition.
        public WebElement getProductByName(String ProductName){
            WebElement prod = getProductList().stream()
                    .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
                    .orElse(null);
            logger.info("Collecting list of Elements and returned elements");
            return prod;
        }
        //adding product to cart
public void addProductTocart(String ProductName){
        // stored element
        WebElement prod = getProductByName(ProductName);

    prod.findElement(addToCart).click();
    waitforElementToAppear(toastMessage);
   waitforElementToDisAppear(spinner);
}

}
