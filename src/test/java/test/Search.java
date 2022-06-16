package test;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GooglePage;

public class Search extends BaseSetup {
    private WebDriver driver;
    public GooglePage googlePage;
    @BeforeClass
    public void setup(){
        driver = getDriver();
    }
    @Test
    public void search(){
        String[] listExpectedResult = {"Selenium", "Selenium là gì? Một số kinh nghiệm làm việc với Selenium", "Làm quen: Tóm tắt cơ bản về Selenium | TopDev"};
        googlePage = new GooglePage(driver);
        googlePage.searchText("Selenium");

        Assert.assertTrue(googlePage.verifyResult(listExpectedResult));
    }
}
