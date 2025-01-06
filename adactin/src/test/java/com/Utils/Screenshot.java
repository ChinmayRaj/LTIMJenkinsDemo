package com.Utils;

import java.io.IOException;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
public class Screenshot {
    
    public static void Capture(WebDriver driver)throws IOException{
        // File dir=new File("/home/coder/project/workspace/adactin/screenshots/hotel.png");
        // if(!dir.exists()){
        //     dir.mkdir();
        // }
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        
        FileHandler.copy(src,new File(".//screenshots/click.png"));
    }
}
