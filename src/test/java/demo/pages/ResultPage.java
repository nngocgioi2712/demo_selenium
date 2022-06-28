package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private WebDriver driver;

    private By inputSearch = By.tagName("input");
    public ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyInput(String text){
        WebElement element = driver.findElement(inputSearch);
        return element.getText().equals(text)? true : false;
    }
    public void verifyListResult(){

    }
    public void verifyCalculationResult(){

    }
}
