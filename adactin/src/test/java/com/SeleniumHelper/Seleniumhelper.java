package com.SeleniumHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Seleniumhelper {
public static WebDriver driver;
    public Seleniumhelper(WebDriver driver){
        this.driver=driver;
    }
     public void typefield(By loc,String text){
        driver.findElement(loc).sendKeys(text);
    }
    public void clickElement(By loc){
        driver.findElement(loc).click();
    }
}
