package rahulsettyacademy.TestComponent;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulsettyacademy.pageobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigClass  {
    public WebDriver driver;
    public LandingPage landingpage;

    public WebDriver browserintilization() throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\swamy\\IdeaProjects\\SeleniumFrame_pageobjects\\src\\main\\java\\rahulesettyacademy\\globaldata\\Globaldata.Properties");
        prop.load(file);
        String BrowserName = prop.getProperty("browser");

        if (BrowserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
    TakesScreenshot ts =  (TakesScreenshot)driver ;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

}


    @BeforeMethod(alwaysRun = true)
    public LandingPage browserlunch() throws IOException {

        driver = browserintilization();
        landingpage = new LandingPage(driver);
        landingpage.goTo();
        return landingpage;
    }

    @AfterMethod(alwaysRun = true)
    public void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }




}

