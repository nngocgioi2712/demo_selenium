package demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver = null;
    private String path = "./chromedriver.exe";
    public void setDriver( String url){

        //WebDriverManager.chromedriver().setup();
        System.setProperty("driver.chromeDriver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void init(){
        setDriver("https://www.google.com.vn/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
