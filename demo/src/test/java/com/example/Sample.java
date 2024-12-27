package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sample {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        try{
     driver=new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
     driver.get("http://www.google.com");
        }catch(MalformedURLException e){
e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
