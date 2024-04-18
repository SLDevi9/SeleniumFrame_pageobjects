package automation_practice.submitorder;

import com.aventstack.extentreports.ExtentReports;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_practice.TestComponent.ConfigClass;
import automation_practice.TestComponent.Retry;

public class Error_Handling extends ConfigClass {
    ExtentReports extent;

    @Test(groups = {"errors"},retryAnalyzer=Retry.class)
    public void Login_Error(){

        landingpage.loginApplication("sivalakshmidevi@gmail.com", "Amma@123udemy");
        logger.info("application enter mail and  password ");
        String s = landingpage.GetErrorMessage();
        logger.info("error message received");
        Assert.assertEquals("Incorrect email or password.", s);
    }
}
