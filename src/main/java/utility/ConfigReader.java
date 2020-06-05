package utility;

import java.io.*;
import java.util.Properties;

public class ConfigReader{
   public static String  getapiUrl=null;
    public static String  incorrectGetapiUrl=null;
    public static String  individualEmployeeGetapiUrl=null;
    public static Properties prop = null;
    public static String postApiUrl=null;
    public static String incorrectPostApiUrl=null;
    public static String incorrectDeleteApiUrl=null;
    public static String correctDeleteApiUrl=null;
    public static String  putUrl=null;
    public static String incorrectPutUrl=null;

    public ConfigReader() throws FileNotFoundException {
        prop=new Properties();
        FileInputStream inputFile = new FileInputStream(new File("config.properties"));
        try {
            prop.load(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getapiUrl=prop.getProperty("getUrl");
        incorrectGetapiUrl=prop.getProperty("IncorrectGetUrl");
        individualEmployeeGetapiUrl=prop.getProperty("getUrlOfSpecificEmployee");
        postApiUrl=prop.getProperty("postUrl");
        incorrectPostApiUrl=prop.getProperty("incorrectPostApiUrl");
        correctDeleteApiUrl=prop.getProperty("deleteApiUrl");
        incorrectDeleteApiUrl=prop.getProperty("incorrectDeleteApiUrl");
        putUrl=prop.getProperty("putUrl");
        incorrectPutUrl=prop.getProperty("incorrectPutUrl");
    }

}
