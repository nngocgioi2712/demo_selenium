package demo.testcase;

import demo.base.BaseSetup;
import demo.pages.ResultPage;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import demo.base.KeyBoardEvents;

public class SearchText extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;
    private ResultPage resultPage;
    private KeyBoardEvents event;
    @BeforeClass
    public void setup(){
        this.driver = getDriver();
    }

    @Test (priority = 0)
    public void enterText(){
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        //event = new KeyBoardEvents();
        searchPage.enterInput("Selenium");
        //event.pressEnter(driver);
        resultPage.verifyInput("Selenium");


    }

}
