package bai5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefineLocatorOfElement {
    ChromeDriver driver;
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }
    public void getElement(){
        //    HTML attribute
        //    1. Id (id là duy nhất)
        WebElement byId = driver.findElement(By.id("id"));
//        2. Name (duy nhất ? maybe)
        WebElement byName = driver.findElement(By.name("name"));
//        3. Link text (text trong thẻ a)
        WebElement byLinkText = driver.findElement(By.linkText("linkText"));
//        4. Partial Link Text (định vị văn bản liên kết 1 phần)
        WebElement byPartialLinkText = driver.findElement(By.partialLinkText("partialLinkText"));
//        5. TagName (vd: xác định tất cả các liên kết trong trang và xác minh xem có hđ hay không)
        WebElement byTagName = driver.findElement(By.tagName("a"));
//        6. ClassName (không chính xác, nhiều pt chung class)
        WebElement byClassName = driver.findElement(By.className("classname"));
            //Xpath


    }

}

