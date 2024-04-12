package rahulsettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulsettacademy.AbstractComponet.Abstract_Component;

import java.util.List;

public class ProductCatalogue extends Abstract_Component {
WebDriver  driver;

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
        return products;
    }
    //finding product name
        public WebElement getProductByName(String ProductName){
            WebElement prod = getProductList().stream()
                    .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
                    .orElse(null);
            return prod;
        }
public void addProductTocart(String ProductName){
        WebElement prod = getProductByName(ProductName);
    prod.findElement(addToCart).click();
    waitforElementToAppear(toastMessage);
    waitforElementToDisAppear(spinner);
}

}
