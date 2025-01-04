package com.example;

import org.openqa.selenium.WebDriver;

public class TestEnd {

public static void TestEnd(WebDriver driver) {
    
    if(driver!=null){
        driver.quit();
    }
    
}
}
