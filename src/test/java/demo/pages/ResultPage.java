package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "input")
    WebElement inputSearch;
    @FindBy(xpath = "//a/h3")
    List<WebElement> resultList;
    private By calculationResult = By.id("cwos");
    public ResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    public boolean verifyResultList(String text, String[] expected){
        wait.until(ExpectedConditions.titleIs("Selenium - Tìm trên Google"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputSearch, text));

        int i = 0;
        while (i < expected.length){
            if(!resultList.get(i).equals(expected[i])){
                System.out.println("Actual: " + resultList.get(i).getText() + " and Expected is " + expected[i]);
                return false;
            }
            i++;
        }
        return true;
    }
    public void verifyCalculationResult(){

    }
}
