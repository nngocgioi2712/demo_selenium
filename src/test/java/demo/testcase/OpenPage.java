package demo.testcase;

import com.sun.source.tree.AssertTree;
import demo.base.BaseSetup;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class OpenPage extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;


    @BeforeClass
    public void setup(){
        this.driver = getDriver();
    }

    @Test (priority = 0)
    public void verifyOpenPage(){
        searchPage = new SearchPage(driver);
        searchPage.openPage();
        Assert.assertTrue(searchPage.verifyOpenPage("Google"), "title: " + driver.getTitle());
    }
}
