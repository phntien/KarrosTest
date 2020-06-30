package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class SetUp{
    public static WebDriver driver;

    /* Initial Selenium Web Driver based on which browser has been set in TestRunner file - glue.
    i.e: glue glue = {"stepdefs","testrunner.hook","testrunner.browsers.chrome"}
    => Init ChromeDriver */
    public static void initDriver(String browser) throws Exception{
        //Check if parameter passed as 'chrome'
        if(browser.equalsIgnoreCase("Chrome")){
            String CHROME_VERSION = Config.getProperty("chromeDriverVersion");
            WebDriverManager.chromedriver().browserVersion(CHROME_VERSION).setup();
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'firefox'
        else if(browser.equalsIgnoreCase("Firefox")){
            String FIREFOX_VERSION = Config.getProperty("firefoxDriverVersion");
            WebDriverManager.firefoxdriver().browserVersion(FIREFOX_VERSION).setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            String EDGE_VERSION = Config.getProperty("edgeDriverVersion");
            WebDriverManager.edgedriver().browserVersion(EDGE_VERSION).setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("IE")){
            String IE_VERSION = Config.getProperty("ieDriverVersion");
            WebDriverManager.iedriver().browserVersion(IE_VERSION).setup();
            driver = new InternetExplorerDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Util.printLog("[INFO] " + browser + " Browser & Driver has been initialized successfully");
    }
}
