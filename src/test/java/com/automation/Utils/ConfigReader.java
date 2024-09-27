package com.automation.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;
    public static void createConfig(){
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/config/config.properties"));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public static String getConfigValue(String key){
        return prop.getProperty(key);
    }


}
