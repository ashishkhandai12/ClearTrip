package com.Cleartrip.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Cleartrip.init.Iconstants;

public class excelLib {
	
	public static String getData(String sheet,int row,int cell,String filepath) 
	{
		String data="";
		
		try {
			FileInputStream fin = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fin);
	Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
	
	data = c.getStringCellValue();

			} catch (Exception e) {
			

	

			}
		return data;
		
	}
	public static String SetData(String OrderNO,long time) throws IOException
	{

		String path=excelLib.getData("Sheet1",1,0,Iconstants.path);

		 FileInputStream file1 = new FileInputStream("D:\\UBM\\HD_Eommerce_Web\\src\\test\\resources\\excel\\test_ecom_OrderDetails.xlsx");



         XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
         XSSFSheet sheet1 = workbook1.getSheetAt(0);
         
    
         
 
         Row row = sheet1.createRow(sheet1.getLastRowNum()+1);
        
        Cell cell=row.createCell(0);
        cell.setCellValue(OrderNO);	   
        cell=row.createCell(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        cell.setCellValue(dtf.format(now));
        cell=row.createCell(2);
        cell.setCellValue(time);	
          
     /*    if(row.getCell(0).getStringCellValue()!=null)
         {
        	 sheet1.shiftRows(1,rowTotal,1);
        	 cell.setCellValue(OrderNO);
        	 
         }
         else {
        	 cell.setCellValue(OrderNO);
         }*/
         
         
         
        /* Row row=sheet1.createRow(1);
         cell1=row.createCell(0);
         
       /*  Row row = sheet1.createRow((short)0);
         Cell cell = row.createCell(0);
        */
         // Create a cell and put a value in it.
        
 
      
         file1.close();

         FileOutputStream outFile1 =new FileOutputStream(new File("D:\\UBM\\HD_Eommerce_Web\\src\\test\\resources\\excel\\test_ecom_OrderDetails.xlsx"));

//           workbook1 = new XSSFWorkbook(outFile1);
         workbook1.write(outFile1);
         outFile1.close();
     
        
         
        
         
	return OrderNO; 
		
		
	}
	
}
