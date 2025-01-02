package com.example;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestMakeMyTrip {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException{
        try {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");

            driver=new RemoteWebDriver(new URL("http://localhost:4444"),op);
     driver.get("https://www.makemytrip.com/");
     Thread.sleep(2000);
    //  driver.findElement(By.xpath("//span[@class='commonModal_close']")).click();
    //  Thread.sleep(3000);
     driver.findElement(By.xpath("//div/label/input[@id='fromCity']")).click();
     Thread.sleep(4000);
     driver.findElement(By.xpath("//div/label/input[@id='fromCity']")).sendKeys("Bhubaneswar");
     Thread.sleep(2000);
     Actions act=new Actions(driver);

     WebElement btn1=driver.findElement(By.xpath("//div/p[text()='Bhubaneswar, India']"));
       act.moveToElement(btn1).build().perform();
       Thread.sleep(2000);
       btn1.click();
       Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
