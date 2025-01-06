package com.example;



import java.net.URL;
import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AppTest 
{
    public static WebDriver driver;

   @BeforeMethod
   public void onSetup(){
       ChromeOptions op=new ChromeOptions();
       driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
       op.addArguments("--disable-notifications");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       driver.get("https://www.bigsmall.in");
   }
    @Test
    public void TestBigsmall()
    {
        Actions act=new Actions(driver);
        
     WebElement    christmas=driver.findElement(By.xpath("//ul/li[2]/details[@id='site-nav-item--2']"));

    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
