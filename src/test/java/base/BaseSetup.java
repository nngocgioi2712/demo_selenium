package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseSetup {
    private WebDriver driver;
    private String driverpath = "./chromedriver.exe";

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(String url) {
        System.setProperty("webdriver.chrome.driver", driverpath);
        this.driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }
    @BeforeClass
    public void init(){
        setDriver("https://www.google.com/");

    }


}
