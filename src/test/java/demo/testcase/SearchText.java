package demo.testcase;

import demo.base.BaseSetup;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchText extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setup(){
        driver = getDriver();
    }

    @Test (priority = 1)
    public void enterText(){
        searchPage = new SearchPage(driver);
        searchPage.enterInput("Selenium");
    }

}
