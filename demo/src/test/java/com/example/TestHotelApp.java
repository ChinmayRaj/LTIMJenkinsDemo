package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHotelApp {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        try{
            ChromeOptions op=new ChromeOptions();
            op.addArguments("--disable-notifications");
            op.addArguments("--start-maximized");

     driver=new RemoteWebDriver(new URL("http://localhost:4444"),op);
     driver.get("http://www.adactinhotelapp.com");
     driver.findElement(By.id("username")).sendKeys("chinmay");
     driver.findElement(By.id("password")).sendKeys("chinmay123");
     driver.findElement(By.className("login_button")).click();
     driver.findElement(By.linkText("Forgot Password?")).click();
     driver.navigate().back();
     driver.findElement(By.linkText("New User Register Here")).click();

     String msg=driver.findElement(By.className("auth_error")).getText();

     System.out.println(msg);

     Thread.sleep(10000);
        }catch(MalformedURLException e){
System.out.println(e.getMessage());
        }
        finally{
            driver.quit();
        }
    }
}
