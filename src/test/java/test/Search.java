package test;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GooglePage;

public class Search extends BaseSetup {
    private WebDriver driver;
    private GooglePage googlePage;
    @BeforeClass
    public void setup(){
        driver = getDriver();
    }
    @Test
    public void search1(){
        String[] listExpectedResult = {"Selenium",
                "Selenium là gì? Một số kinh nghiệm làm việc với Selenium",
                "Làm quen: Tóm tắt cơ bản về Selenium | TopDev"};
        googlePage = new GooglePage(driver);
        googlePage.searchText("selenium");

        Assert.assertTrue(googlePage.verifySearch(listExpectedResult));
    }
    @Test
    public void search2(){
        googlePage = new GooglePage(driver);
        driver.navigate().to("https://www.google.com/");
        int sum = googlePage.searchSumOfNumber(10);

        Assert.assertTrue(googlePage.verifyCalculator(sum));
    }
}
