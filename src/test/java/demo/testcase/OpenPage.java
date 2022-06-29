package demo.testcase;

import com.sun.source.tree.AssertTree;
import demo.base.BaseSetup;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.TestRunner.PriorityWeight.priority;

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
