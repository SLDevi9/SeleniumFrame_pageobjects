package automation_practice.TestComponent;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import automation_practice.pageobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.*;

public class ConfigClass  {
    public WebDriver driver;
    public LandingPage landingpage;
    public static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ConfigClass.class);

    public WebDriver browserintilization() throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\swamy\\IdeaProjects\\SeleniumFrame_pageobjects\\SeleniumFrame_pageobjects\\src\\main\\java\\rahulesettyacademy\\globaldata\\Globaldata.Properties");
        prop.load(file);
        String BrowserName=  System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

        if (BrowserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("browser setup done");
        }
        else if (BrowserName.contains("firefox")) {
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
            logger.info("browser setup done");
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
// browser initilized
        driver = browserintilization();
       logger.info("browser initilized");
        landingpage = new LandingPage(driver);
       // application launched & returned to landingpage
        landingpage.goTo();
        logger.info("application launched & returned to landingpage");
        return landingpage;

    }

    @AfterMethod(alwaysRun = true)
    public void close_browser() throws InterruptedException {
      //  Thread.sleep(2000);
        driver.close();
        logger.info("browser closed successfully");
    }




}

