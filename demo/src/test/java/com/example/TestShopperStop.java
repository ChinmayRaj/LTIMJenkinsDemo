package com.example;



import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestShopperStop {
     public static WebDriver driver;

     public static void main(String[] args)throws InterruptedException {
        try {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");

            driver=new RemoteWebDriver(new URL("http://localhost:4444"),op);
     driver.get("https://www.shoppersstop.com/");
     Thread.sleep(2000);

     driver.findElement(By.xpath("//div/input")).sendKeys("Kurta");
     Thread.sleep(3000);
     
        } catch (Exception e) {
            // TODO: handle exception
        }
     }
}
