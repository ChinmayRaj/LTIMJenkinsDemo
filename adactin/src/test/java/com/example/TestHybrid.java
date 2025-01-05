package com.example;
import org.openqa.selenium.io.FileHandler;
import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestHybrid {
  public static final Logger logger=Logger.getLogger(TestHybrid.class);
  ExtentSparkReporter spark;
  ExtentReports report;
  ExtentTest test;
 
  public static WebDriver driver;
public static Properties prop;
    
    @BeforeMethod
    public void setup()throws MalformedURLException,IOException{
     
        ChromeOptions op=new ChromeOptions();
        op.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        FileInputStream fis=new FileInputStream("/home/coder/project/workspace/adactin/config/config.properties");
        prop=new Properties();
        prop.load(fis);
        String url=prop.getProperty("Url");
        driver.get(url);
        String reportPath="./reports/SparkReport.html";
spark=new ExtentSparkReporter(reportPath);
extent=new ExtentReports();
extent.attachReporter(spark);
     }
    @DataProvider(name="readData")
    public Object[][] readData()throws IOException{
        String excelpath=readProp("excelPath");
        setExcelFile(excelpath, "Sheet1");
        Object[][] testdata=readExcelData();
        return testdata;
    }
    @Test(dataProvider ="readData" ) 
    public void testHotel(String user,String pass)throws Exception{
        
      TestHybrid th=new TestHybrid();
     
     
      th.typefield(uname, user);
      th.typefield(passwrd,pass);
      th.clickElement(login);
}
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    
   
    public static void Capture()throws IOException{
        File dir=new File("/home/coder/project/workspace/adactin/screenshots/hotel.png");
        if(!dir.exists()){
            dir.mkdir();
        }
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        
        FileHandler.copy(src,dir);
    }
}
