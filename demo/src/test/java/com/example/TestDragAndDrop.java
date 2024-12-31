package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestDragAndDrop {
    public static WebDriver driver;
    public static void main(String[] args)throws InterruptedException {
        try {
            driver=new RemoteWebDriver(new URL("http://localhost/4444"),new ChromeOptions());
            driver.get("https://demoqa.com/droppable");
            Thread.sleep(5000);
            WebElement from=driver.findElement(By.id("draggable"));
            WebElement to=driver.findElement(By.id("droppable"));

            Actions act=new Actions(driver);
            act.moveToElement(from).build().perform();
            Thread.sleep(5000);
            act.dragAndDrop(from, to).build().perform();
            Thread.sleep(5000);

        //     //screenshot
        //     File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //   try {
        //     FileUtils.copyFile(screenshot,new File("C:\\downloads\xyz.png"));
        //   } catch (Exception e) {
           
        //   }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
