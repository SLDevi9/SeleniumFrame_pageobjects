package automation_practice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automation_practice.AbstractComponet.Abstract_Component;

import java.util.List;

public class MyOrdersPage extends Abstract_Component {
  WebDriver driver;
    String ProductName = "IPHONE 13 PRO";
    public MyOrdersPage(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

@FindBy (css = "tr td:nth-child(3)")
List<WebElement> List_of_productNames;

    public Boolean Verify_MyOrderList(){
        return List_of_productNames.stream().anyMatch(List_of_productName -> List_of_productName.getText().equalsIgnoreCase(ProductName));

 }

}
