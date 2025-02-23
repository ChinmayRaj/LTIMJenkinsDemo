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
    
     driver.findElement(By.xpath("//div/label/input[@id='fromCity']")).click();
     Thread.sleep(6000);
     driver.findElement(By.xpath("//div//input[@placeholder='From']")).sendKeys("Bhubaneswar");
     Thread.sleep(2000);
     Actions act=new Actions(driver);

     WebElement btn1=driver.findElement(By.xpath("//div/p[text()='Bhubaneswar, India']"));
       act.moveToElement(btn1).build().perform();
       Thread.sleep(2000);
       btn1.click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//div/label/input[@id='toCity']")).click();
     Thread.sleep(6000);
     driver.findElement(By.xpath("//div//input[@placeholder='To']")).sendKeys("Hyderabad");
     Thread.sleep(2000);
     WebElement btn2=driver.findElement(By.xpath("//li[@role='option']/div/div/p[text()='Rajiv Gandhi International Airport']"));
       act.moveToElement(btn2).build().perform();
       Thread.sleep(2000);
       btn2.click();
       Thread.sleep(5000);
     
       driver.findElement(By.xpath("//div/label[@for='departure']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@aria-label='Sun Jan 05 2025']")).click();
       Thread.sleep(3000);
       
       driver.findElement(By.xpath("//div/label[@for='return']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@aria-label='Tue Jan 07 2025']")).click();
       Thread.sleep(3000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
