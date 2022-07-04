package demo.common;

import demo.common.helper.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver = null;
    //private String path = "./chromedriver.exe";
    public void setDriver( String url, String browserType){
        driver = setupDriver(browserType);
        driver.navigate().to(url);
    }
    public WebDriver getDriver(){
        return driver;
    }

    public WebDriver setupDriver(String browserType){
        WebDriver driver;
        switch(browserType.trim().toLowerCase()){
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice");
                driver = initChromeDriver();
        }
        return driver;
    }
    public WebDriver initChromeDriver(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver initFirefoxDriver(){
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver initEdgeDriver(){
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeClass
    public void init(){
        PropertiesHelper.setFile("src/test/resources/configs.properties");
        setDriver("https://www.google.com.vn/", PropertiesHelper.getValue("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

}
