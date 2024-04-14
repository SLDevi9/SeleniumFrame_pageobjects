package rahulsettyacademy.submitorder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsettyacademy.TestComponent.ConfigClass;
import rahulsettyacademy.TestComponent.Retry;

public class Error_Handling extends ConfigClass {
    ExtentReports extent;

    @Test(groups = {"errors"},retryAnalyzer=Retry.class)
    public void Login_Error(){

        landingpage.loginApplication("sivalakshmidevi@gmail.com", "Amma@123udemy");
        String s = landingpage.GetErrorMessage();
        Assert.assertEquals("Incorre mail or password.", s);
    }
}
