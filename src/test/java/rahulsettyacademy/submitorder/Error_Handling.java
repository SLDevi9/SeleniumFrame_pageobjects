package rahulsettyacademy.submitorder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import loggers_demo.Log4j_log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsettyacademy.TestComponent.ConfigClass;
import rahulsettyacademy.TestComponent.Retry;

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
