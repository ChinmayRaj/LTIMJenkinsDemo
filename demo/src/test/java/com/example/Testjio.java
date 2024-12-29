package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Testjio {
    public static WebDriver driver;
    public static void main(String[] args)throws InterruptedException {
        try {
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");

            driver=new RemoteWebDriver(new URL("http://localhost:4444"),op);
     driver.get("https://www.jiomart.com");
     Thread.sleep(2000);

      driver.findElement(By.xpath("//*[@id='nav_link_2']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id='nav_link_61']")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Baked Cookies")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='variant_RCNRIQNBOE']/div[2]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/main/section/section[2]/div[1]/div[2]/div[1]/div/div[3]/div/button")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/header/section[1]/div/section[2]/div[2]/div/div[1]")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@id='login-container']/jds-container[5]/section/div/jds-button/button/div")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//*[@id='phoneNumber']")).sendKeys("7455095324");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[2]/div[3]/button")).click();
    Thread.sleep(20000);
} catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            driver.quit();
        }
    }
}
