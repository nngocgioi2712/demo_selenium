package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    By input = By.tagName("input");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.navigate().to("https://www.google.com.vn/");
    }

    public boolean verifyOpenPage(String expectedTitle){
        return driver.getTitle().equals(expectedTitle) ? true : false;
    }


}
