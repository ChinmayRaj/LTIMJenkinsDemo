

package com.example;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class TestBigSmall {

    public static WebDriver driver;

   @BeforeMethod
   public void onSetup()throws MalformedURLException{
       ChromeOptions op=new ChromeOptions();
       op.addArguments("--disable-notifications");
       driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
      
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       driver.get("https://www.bigsmall.in");
   }
    @Test
    public void TestBigsmall()
    {
        Actions act=new Actions(driver);

     WebElement  christmas=driver.findElement(By.xpath("//ul/li[2]/details[@id='site-nav-item--2']"));
act.moveToElement(christmas).build().perform();
driver.findElement(By.partialLinkText("Secret")).click();
    }

    @AfterTest
    public void close(){
        if(driver!=null)
        driver.quit();
    }
}

