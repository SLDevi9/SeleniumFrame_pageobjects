package automation_practice.submitorder;

import automation_practice.TestComponent.ConfigClass;
import automation_practice.pageobjects.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;

public class Submit_Order extends ConfigClass {
    ConfirmationPage confirmationPage;
    String ProductName = "IPHONE 13 PRO";
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Submit_Order.class);
    @Test(dataProvider = "getdata", groups ={"Purchase"})
    public void Order(String email, String Password, String productName) throws InterruptedException {

        //
        ProductCatalogue productCatalogue= landingpage.loginApplication(email, Password);
        logger.info("productCatalogue returned");
        List<WebElement>products = productCatalogue.getProductList();
        productCatalogue.addProductTocart(productName);
        CartPage cartPage = productCatalogue.gotoCartpage();
        Boolean match=cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage=cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
       confirmationPage=  checkoutPage.submitOrder();
        String message = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }
    @Test(dependsOnMethods= {"Order"})
    public void MyOrde(){
        logger.info("dependsOnMethods = Order");
        landingpage.loginApplication("sivalakshmidevi9@gmail.com", "Amma@123udemy");
        landingpage.MyOrderpage();
        MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
        Assert.assertTrue(myOrdersPage.Verify_MyOrderList());
    }
    @DataProvider
    public Object[][] getdata(){
        return new Object[][]  {{"sivalakshmidevi9@gmail.com", "Amma@123udemy", "ADIDAS ORIGINAL"}, {"shetty@gmail.com", "Iamking@000","IPHONE 13 PRO"}};
    }
}