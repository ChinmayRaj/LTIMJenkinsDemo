package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
     public static XSSFSheet sheet;
  public static XSSFWorkbook wb;
  public static XSSFRow row;
  public static XSSFCell cell;
     public static void setExcelFile(String excelpath,String SheetName)throws IOException{
        File file = new File(excelpath);
       FileInputStream fis=new FileInputStream(file);
       wb=new XSSFWorkbook(fis);
       sheet=wb.getSheet(SheetName);
      }
    
    public static String[][] readExcelData(){
        String[][] data=null;
int rows=sheet.getLastRowNum()-sheet.getFirstRowNum();
int cells=sheet.getRow(0).getLastCellNum();
data=new String[rows][cells];
for(int i=0;i<rows;i++){
    for(int j=0;j<cells;j++)
    {
       data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
    }
}
return data;
    }
}
