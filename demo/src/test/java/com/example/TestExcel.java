package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.google.common.annotations.VisibleForTesting;

public class TestExcel {
public static WebDriver driver;

@BeforeMethod
public void EstablisgConnection()throws MalformedURLException{
      ChromeOptions op=new ChromeOptions();
      driver=new RemoteWebDriver(new java.net.URL("http://localhost:4444"), op);
      

}

}
