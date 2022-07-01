package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(tagName = "input")
    WebElement input;
    @FindBys({
            @FindBy(id = "input"),
            @FindBy(className = "abc")
    })
    WebElement a;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

/*    public void openPage(){
        driver.navigate().to("https://www.google.com.vn/");
    }*/

    public boolean verifyOpenPage(String expectedTitle){
        return driver.getTitle().equals(expectedTitle) ? true : false;
    }
    public void enterInput(String text){
//        driver.navigate().to("https://www.google.com.vn/");
//        wait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
    }

}
