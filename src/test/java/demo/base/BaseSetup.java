package demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseSetup {
    WebDriver driver = null;

    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void init(){
        setDriver();
    }

}
