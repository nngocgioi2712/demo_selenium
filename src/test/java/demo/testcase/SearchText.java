package demo.testcase;

import demo.base.BaseSetup;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchText extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;
    private OpenPage openPage;
    @BeforeClass
    public void setup(){
        this.driver = getDriver();
    }

    @Test (priority = 0)
    public void openPage(){
        openPage = new OpenPage();
        openPage.verifyOpenPage();
    }
    @Test (priority = 1)
    public void enterText(){
        searchPage = new SearchPage(driver);
        searchPage.enterInput("Selenium");
    }

}
