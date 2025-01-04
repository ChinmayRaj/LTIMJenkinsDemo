package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestExcel {
public static WebDriver driver;

@BeforeMethod
public void EstablishConnection()throws MalformedURLException{
      ChromeOptions op=new ChromeOptions();
      driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
       op.addArguments("--disable-notifications");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get("https://www.jiomart.com");
}
@Test
public void TestReadExcel()throws IOException{
FileInputStream fis=new FileInputStream("/home/coder/project/workspace/demo/ExcelData/excelsheet.xlsx");

XSSFWorkbook wb=new XSSFWorkbook(fis);
XSSFSheet sheet=wb.getSheetAt(0);
Row row=sheet.getRow(0);
Cell cel0=row.getCell(0);
Cell cel1=row.getCell(1);

System.out.println("First Name:"+cel0+" ,Last Name:"+cel1);
}

@AfterTest
public void QuitDriver(){
    if(driver!=null){
          driver.quit();
    }
}


}
