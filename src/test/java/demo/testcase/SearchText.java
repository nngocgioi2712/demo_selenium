package demo.testcase;

import demo.common.BaseSetup;
import demo.common.helper.ExcelHelper;
import demo.pages.ResultPage;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import demo.common.KeyBoardEvents;

public class SearchText extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;
    private ResultPage resultPage;
            ExcelHelper excel = new ExcelHelper();
    private KeyBoardEvents event;
    @BeforeClass
    public void setup(){
        this.driver = getDriver();
    }
    @Test (priority = 0)
    public void searchText(){
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        String input = "Selenium";
        String[] expectedResultList = {
                "Selenium",
                "Selenium là gì? Một số kinh nghiệm làm việc với Selenium",
                "Làm quen: Tóm tắt cơ bản về Selenium | TopDev"
        };
        searchPage.enterInput(input);

        Assert.assertTrue(resultPage.verifyResultList(input, expectedResultList), "Fail");
    }

}
