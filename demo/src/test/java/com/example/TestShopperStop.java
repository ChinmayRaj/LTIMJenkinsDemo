package com.example;



import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestShopperStop {
     public static WebDriver driver;
   
     public static void main(String[] args)throws InterruptedException {
        try {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");

            driver=new RemoteWebDriver(new URL("http://localhost:4444"),op);
     driver.get("https://www.shoppersstop.com");
     Thread.sleep(2000);

     driver.findElement(By.xpath("//div/input")).sendKeys("Kurta");
     Thread.sleep(5000);
     driver.findElement(By.xpath("//div/input")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[@class='bg-transparent flex flex-col']/div[2]/p")).click();
     Thread.sleep(6000);
     
     driver.findElement(By.xpath("//div/button[@role='combobox']/img")).click();
     Thread.sleep(5000);
     driver.findElement(By.xpath("//span/div/span[text()='Discount']")).click();
     Thread.sleep(5000);

     Actions act=new Actions(driver);
     act.moveToElement(driver.findElement(By.xpath("//div[@class='bg-transparent relative rounded md:rounded-lg']/img"))).build().perform();
     Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
     }
}
