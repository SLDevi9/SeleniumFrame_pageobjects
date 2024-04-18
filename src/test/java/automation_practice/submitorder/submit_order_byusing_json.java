package automation_practice.submitorder;

import automation_practice.json_reader.DataReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automation_practice.TestComponent.ConfigClass;
import automation_practice.pageobjects.CartPage;
import automation_practice.pageobjects.CheckoutPage;
import automation_practice.pageobjects.ConfirmationPage;
import automation_practice.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class submit_order_byusing_json extends ConfigClass {
    ConfirmationPage confirmationPage;
    String ProductName = "IPHONE 13 PRO";

    @Test(dataProvider = "getdata", groups = {"Purchase"})
    public void Order(HashMap<String, String> input) throws InterruptedException {

        ProductCatalogue productCatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductTocart(input.get("productname"));
        CartPage cartPage = productCatalogue.gotoCartpage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("productname"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
        String message = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("THANKY FOR THE ORDER."));

    }

  /*  @Test(dependsOnMethods = {"Order"})
    public void MyOrde() {
        landingpage.loginApplication("sivalakshmidevi9@gmail.com", "Amma@123udemy");
        landingpage.MyOrderpage();
        MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
        Assert.assertTrue(myOrdersPage.Verify_MyOrderList());
    }*/

    @DataProvider
    public Object[][] getdata() throws IOException {

        DataReader datareader = new DataReader();
        List<HashMap<String, String>> data = datareader.getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/rahulsettyacademy/json_reader/Data_reader.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }


}
