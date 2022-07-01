package demo.testcase;

import demo.common.BaseSetup;
import demo.common.helper.ExcelHelper;
import demo.pages.ResultPage;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchExpression extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;
    private ResultPage resultPage;
    private ExcelHelper excel;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        excel = new ExcelHelper();
    }
    @Test
    public void searchExpression() throws Exception{
        excel.setExcelFile("D:\\0.GIOINN\\AUTO_selenium\\demo_selenium\\data-test.xlsx", "Sheet1");
        String data1 = excel.getCellData("input", 1);
        int n = Integer.parseInt(data1);
        String dataExpected = excel.getCellData("expected", 1);
        System.out.println(data1);
        System.out.println(dataExpected);
        String text = "";
        int sum = n;
        int i = 1;
        while (i < n){
            text += i + "+";
            sum += i;
            i++;
        }
        text += n;
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        searchPage.enterInput(text);
        Assert.assertTrue(resultPage.verifyCalculationResult(text, dataExpected), "Fail");
    }
}
