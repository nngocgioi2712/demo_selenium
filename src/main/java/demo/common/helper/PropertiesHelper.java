package demo.common.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {
    private static Properties properties;
    private static String linkFile;
    private static FileInputStream fIn;
    private static FileOutputStream fOut;
    private static  String relPropertiesFilePathDefault;
    public static Properties loadFile(){
        String file = "src/test/resources/configs.properties";
        try{
            properties = new Properties();
            linkFile = System.getProperty("user.dir") + "/" + file;
            fIn = new FileInputStream(linkFile);
            properties.load(fIn);
            return properties;
        }
        catch(Exception e){
            return new Properties();
        }
    }
    public static void setFile(String relPropertiesFilePath){
        properties = new Properties();
        try{
            linkFile = System.getProperty("user.dir") + "/" + relPropertiesFilePath;
            fIn = new FileInputStream(linkFile);
            properties.load(fIn);
            fIn.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public static void setDefaultFile(){
        properties = new Properties();
        try{
            linkFile = System.getProperty("user.dir") + "/" + relPropertiesFilePathDefault;
            fIn = new FileInputStream(linkFile);
            properties.load(fIn);
            fIn.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    public static String getValue(String key){
        String keyVal = null;
        try{
            if(fIn == null){
               properties = new Properties();
               linkFile = System.getProperty("user.dir") + relPropertiesFilePathDefault;
               fIn = new FileInputStream(linkFile);
               properties.load(fIn);
               fIn.close();
            }
            keyVal = properties.getProperty(key);
        }catch(Exception e){
            e.getMessage();
        }
        return keyVal;
    }
    public static void setValue(String key, String keyValue){
        try{
            if(fIn == null){
                properties = new Properties();
                linkFile = System.getProperty("user.dir") + relPropertiesFilePathDefault;
                fIn = new FileInputStream(linkFile);
                properties.load(fIn);
                fIn.close();
                fOut = new FileOutputStream(linkFile);
            }
            fOut = new FileOutputStream(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(fOut, null);
            fOut.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
