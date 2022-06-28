package demo.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvents {
    public void pressEnter(WebDriver driver){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        action.perform();

    }
}
