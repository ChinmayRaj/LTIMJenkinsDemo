package com.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCreation {
    public static WebDriver driver;
public TestCreation(WebDriver driver){
    this.driver=driver;
}
    public static void OpenURL(WebDriver driver)throws MalformedURLException{
        ChromeOptions op=new ChromeOptions();
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        op.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jiomart.com");
    }
}
