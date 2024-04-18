package automation_practice.TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import automation_practice.globaldata.ExtentRepoterNG;

import java.io.IOException;

public class Listerners extends ConfigClass implements ITestListener {
 ExtentTest test;
    ExtentReports extent =  ExtentRepoterNG.getReportObject();

ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread Safe method

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
      test=  extent.createTest(result.getMethod().getMethodName());
      extentTest.set(test); // unique thread values (errorvalidationTest() -> Test
    }

    @Override
    public void onTestSuccess(ITestResult ITestResult) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

@Override
    public void onTestFailure(ITestResult result) {
    extentTest.get().fail(result.getThrowable());
    try {
        driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
    } catch (Exception e) {
        e.printStackTrace();
    }
    String filepath = null;
    try {
        filepath = getScreenshot(result.getMethod().getMethodName(), driver);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    //Screenshot and attach to the report
}
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

