package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage {
    private WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver = driver;
    }

    private By inputSearch = By.xpath("//form/div[1]/div[1]/div[1]/div/div[2]/input");
    private By cssSelector1 = By.cssSelector("input#input");
    private By cssSelector2 = By.cssSelector("input#input");

    private By listResult = By.xpath("//div[@id=\"search\"]/div/div//a/h3");
    private By resultOfCalculation = By.cssSelector("span[id = 'cwos'][class = 'qv3Wpe']");

    public void searchText(String text){
        WebElement element = driver.findElement(inputSearch);
        if(element.isDisplayed()){
            element.sendKeys(text);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER);
            action.perform();
        }
    }
    public int searchSumOfNumber(int n){
        WebElement element = driver.findElement(inputSearch);
        int sum = 0;
        if(element.isDisplayed()){
            String textSearch = "";
            for(int i =  1; i <= n; i++){
                textSearch += i;
                if(i < n)
                    textSearch += "+";

                sum += i;
            }
            element.sendKeys(textSearch);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER);
            action.perform();
        }
        return sum;
    }

    public boolean verifySearch(String[] expectedResult){
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
    public boolean verifyCalculator(int expectedResult){
        WebElement element = driver.findElement(resultOfCalculation);
        if(Integer.valueOf(element.getText()) == expectedResult) return true;
        else return false;

    }
}
