package demo.common.helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class CaptureHelper {
    public void takeScreenshot(String theDir, String name, WebDriver driver){
        //Thêm date
        //properties
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File theDirFile = new File(theDir);
            if (!theDirFile.exists()) {
                theDirFile.mkdirs();
            }
            FileHandler.copy(source, new File(theDir + name + ".png"));
        }catch (Exception e){
            e.getMessage();
        }
    }
}
