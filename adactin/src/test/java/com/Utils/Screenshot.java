package com.Utils;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
    
    public static void Capture()throws IOException{
        File dir=new File("/home/coder/project/workspace/adactin/screenshots/hotel.png");
        if(!dir.exists()){
            dir.mkdir();
        }
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        
        FileHandler.copy(src,dir);
    }
}
