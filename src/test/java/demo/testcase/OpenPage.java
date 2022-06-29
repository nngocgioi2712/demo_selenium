package demo.testcase;

import demo.common.BaseSetup;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenPage extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setup(){
        this.driver = getDriver();
    }


    @Test (priority = 0)
    public void verifyOpenPage(){
        searchPage = new SearchPage(driver);
        //searchPage.openPage();
        //softAssert.assertTrue(searchPage.verifyOpenPage("Google1"), "title: " + driver.getTitle());

        Assert.assertTrue(searchPage.verifyOpenPage("Google"), "title: " + driver.getTitle());
        //softAssert.assertTrue(searchPage.verifyOpenPage("Google"), "title: " + driver.getTitle());
        //softAssert.assertAll();
    }
    @Test
    public void test1(){
        System.out.println("annotation");
    }
}
