package com.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtility {
    
    public static String readProp(String propToRead)throws IOException{
        String  filePath=System.getProperty("user.dir");
        FileInputStream file=new FileInputStream(filePath+"/config/config.properties");
        Properties props=new Properties();
        props.load(file);
        String property=props.getProperty(propToRead);
        return property;
    }
}
