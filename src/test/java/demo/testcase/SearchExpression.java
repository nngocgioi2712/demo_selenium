package demo.testcase;

import demo.common.BaseSetup;
import demo.common.helper.ExcelHelper;
import demo.common.helper.PropertiesHelper;
import demo.common.helper.RecordVideo;
import demo.pages.ResultPage;
import demo.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchExpression extends BaseSetup {
    private WebDriver driver;
    private SearchPage searchPage;
    private ResultPage resultPage;
    private ExcelHelper excel;

    @BeforeClass
    public void setUp() throws Exception{
        driver = getDriver();
        excel = new ExcelHelper();
        RecordVideo.startRecord("Test");
    }
    @AfterClass
    public void stopRecord() throws Exception{
        RecordVideo.stopRecord();
    }
    @Test
    public void searchExpression() throws Exception{
        String path = System.getProperty("user.dir");
        excel.setExcelFile("src/test/resources/data-test.xlsx", "Sheet1");
        String data1 = excel.getCellData("input", 1);
        int n = Integer.parseInt(data1);
        String dataExpected = excel.getCellData("expected", 1);
        //PropertiesHelper.setFile("src/test/resources/configs.properties");
        //System.out.println(PropertiesHelper.getValue("input1"));
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
        excel.setCellData("pass", 1, 3);
        //PropertiesHelper.setValue("test1", "pass");
        Assert.assertTrue(resultPage.verifyCalculationResult(text, dataExpected), "Fail");
    }
}
