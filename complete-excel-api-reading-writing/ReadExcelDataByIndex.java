package com.automation.excelreader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataByIndex 
{

	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Ravi Kanth\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row = sheet.getRow(3);
		XSSFCell cell = row.getCell(1);
		
		//String value=String.valueOf(cell.getStringCellValue());
		String value=cell.getStringCellValue();
		//double value=cell.getNumericCellValue();
		//Date value=cell.getDateCellValue();
		//String value = String.valueOf(cell.getNumericCellValue());
		
		
		
		System.out.println("value of exel cell is :" + value);	
		workbook.close();
		fis.close();

	}

}
