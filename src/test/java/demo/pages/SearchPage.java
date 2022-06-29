package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    private By input = By.tagName("input");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

/*    public void openPage(){
        driver.navigate().to("https://www.google.com.vn/");
    }*/

    public boolean verifyOpenPage(String expectedTitle){
        return driver.getTitle().equals(expectedTitle) ? true : false;
    }
    public void enterInput(String text){
        WebElement element = driver.findElement(input);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

}
