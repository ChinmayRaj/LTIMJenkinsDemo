package com.example;
import org.openqa.selenium.io.FileHandler;
import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHybrid {
  public static String url;
  public static String filePath;
    public static WebDriver driver;
public static By uname;
public static By uname;
    @BeforeMethod
    public void setup()throws IOException{
        filePath=System.getProperty("user.dir");
//taking url from config directory
        FileInputStream file=new FileInputStream(filePath+"/config/config.properties");
        Properties props=new Properties();
        props.load(file);
        url=props.getProperty("Url");

        ChromeOptions op=new ChromeOptions();
        op.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.get(url);

    }
    @Test
    public void testHotel(){
 driver.findElement(By.xpath("")).sendKeys("");
    }
    @AfterTest
    public void tesrDown(){
        driver.quit();
    }
}
