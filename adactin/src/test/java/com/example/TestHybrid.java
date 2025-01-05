package com.example;
import org.openqa.selenium.io.FileHandler;
import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHybrid {
  
  public static XSSFSheet sheet;
  public static XSSFWorkbook wb;
  
    public static WebDriver driver;
public static By uname=By.id("username");
public static By pass=By.id("password");
public static By login=By.id("login");
    @BeforeMethod
    public void setup()throws IOException{
     
        ChromeOptions op=new ChromeOptions();
        op.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.get(readProp("Url"));

    }
    @Test
    public void testHotel()throws InterruptedException{
        String xlpath=readProp("excelPath");
      TestHybrid th=new TestHybrid();
      setExcelFile(xlpath, "Sheet1");
      th.typefield(uname, "Tonymontana");
      th.typefield(pass,"jarvis123");
      th.clickElement(login);
      
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public void typefield(By loc,String text){
        driver.findElement(loc).sendKeys(text);
    }
    public void clickElement(By loc){
        driver.findElement(loc).click();
    }
    public static void setExcelFile(String excelpath,String SheetName)throws IOException{
       FileInputStream fis=new FileInputStream(excelpath);
       wb=new XSSFWorkbook(fis);
       sheet=wb.getSheet(SheetName);
      }
    public static String readProp(String propToRead){
        String  filePath=System.getProperty("user.dir");
        FileInputStream file=new FileInputStream(filePath+"/config/config.properties");
        Properties props=new Properties();
        props.load(file);
        String property=props.getProperty(propToRead);
        return property;
    }
    public static String[][] readExcelData(){
int rows=sheet.getLastRowNum()-sheet.getFirstRowNum();
int cells
    }
}
