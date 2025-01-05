package com.example;

import java.io.File;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHybrid {
  
    public static WebDriver driver;

    @BeforeMethod
    public void setup()throws IOException{
        String filePath=System.getProperty("user.dir");

        File file=new File(filePath+"/config/config.properties");
        Properties props=new Properties();
        props.load(file);
        String url=props.getProperty("Url");

        ChromeOptions op=new ChromeOptions();
        op.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.get(url);

    }
    @Test
    public void testcase1(){
 
    }
    @AfterTest
    public void tesrDown(){
        driver.quit();
    }
}
