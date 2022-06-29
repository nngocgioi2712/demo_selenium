package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    private WebDriver driver;

    private By inputSearch = By.tagName("input");
    private By listResult = By.xpath("//a/h3");
    private By calculationResult = By.id("cwos");
    public ResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean verifyResultList(String text, String[] expected){
        WebElement elementInput = driver.findElement(inputSearch);
        List<WebElement> elements = driver.findElements(listResult);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Selenium - Tìm trên Google"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(elementInput, text));

        int i = 0;
        while (i < expected.length){
            if(!elements.get(i).equals(expected[i])){
                System.out.println("Actual: " + elements.get(i).getText() + " and Expected is " + expected[i]);
                return false;
            }
            i++;
        }
        return true;
    }
    public void verifyCalculationResult(){
        WebElement elementInput = driver.findElement(inputSearch);
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }
}
