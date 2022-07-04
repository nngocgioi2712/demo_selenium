package demo.testcase;

import demo.common.BaseSetup;
import demo.common.helper.CaptureHelper;
import demo.pages.SearchPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.IResultListener;

import java.io.File;
import java.lang.reflect.Method;

public class OpenPage extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;

    SoftAssert softAssert = new SoftAssert();
    private CaptureHelper captureHelper;

    @BeforeClass
    public void setup(){
        this.driver = getDriver();
        //Tạo tham thiếu TakesScreenshot với Driver hiện tại

    }
    @Test
    public void verifyOpenPage(Method result) throws Exception{
        searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.verifyOpenPage("Google"), "title: " + driver.getTitle());
        /*TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File theDir = new File("./screenshots/OpenPage/");
        if(!theDir.exists()){
            theDir.mkdirs();
        }
        FileHandler.copy(source, new File("./screenshots/OpenPage/" + result.getName() +  ".png"));*/

    }
    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            captureHelper = new CaptureHelper();
            captureHelper.takeScreenshot("./screenshots/OpenPage/", result.getName(), driver);

        }
    }
}
