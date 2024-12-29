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
    driver.findElement(null)
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            driver.quit();
        }
    }
}
