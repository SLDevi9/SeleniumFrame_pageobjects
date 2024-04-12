package rahulsettyacademy.submitorder;

import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsettyacademy.TestComponent.ConfigClass;

public class Error_Handling extends ConfigClass {

    @Test(groups = {"errors"})
    public void Login_Error(){
        landingpage.loginApplication("sivalakshmidevi@gmail.com", "Amma@123udemy");
        String s = landingpage.GetErrorMessage();
        Assert.assertEquals("Incorrect email or password.", s);
    }
}
