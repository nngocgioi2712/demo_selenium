package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GooglePage {
    private WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver = driver;
    }

    private By inputSearch = By.xpath("//form/div[1]/div[1]/div[1]/div/div[2]/input");

    private By listResult = By.xpath("//div[@id=\"search\"]/div/div//a/h3");
    private By result1 = By.xpath("//div[@id=\"search\"]/div/div/div/div/div/div/a/h3");

    public void searchText(String text){
        WebElement element = driver.findElement(inputSearch);
        if(element.isDisplayed()){
            element.sendKeys(text);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER);
            action.perform();
        }


    }
    public boolean verifyResult(String[] expectedResult){
        List<WebElement> listElement = driver.findElements(listResult);
        int i = 0;
        while(i < expectedResult.length){
            if(!listElement.get(i).getText().equals(expectedResult[i])){
                return false;
            }
            i++;
        }
        return true;
    }

}
