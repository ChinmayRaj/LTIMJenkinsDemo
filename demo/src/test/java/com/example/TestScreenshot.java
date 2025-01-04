package com.example;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestScreenshot {
    public static WebDriver driver;
    public static void main(String[] args)throws MalformedURLException,IOException{
        ChromeOptions op=new ChromeOptions();
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        op.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jiomart.com");
String path="";
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File dest=new File("screenshots");
        if(!dest.exists()){
            dest.mkdir();
        }
        org.openqa.selenium.io.FileHandler.copy(src,dest);
        

    } 
}
