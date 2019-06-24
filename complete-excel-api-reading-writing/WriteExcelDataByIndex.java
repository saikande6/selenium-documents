package com.automation.excelreader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByIndex 
{

	
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Ravi Kanth\\Desktop\\testdata.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row=null;
		XSSFCell cell=null;
		XSSFFont font=workbook.createFont();
		XSSFCellStyle style=workbook.createCellStyle();
		
		row=sheet.getRow(4);
		//if(row==null)
			//row=sheet.createRow(3);
		
		cell=row.getCell(4);
		//if(cell==null)
			//cell=row.createCell(4);
		
		font.setFontName("Algerian");
		font.setFontHeight(10.0);
		font.setBold(true);
		
		
		//font.setColor(HSSFColor.ROSE);
		//font.setColor(XSSFColor.toXSSFColor((org.apache.poi.ss.usermodel.Color) Color.red));

		
		
		style.setFont(font);
		
		cell.setCellStyle(style);
		cell.setCellValue("Stop");
		
		
		fos=new FileOutputStream("C:\\Users\\Ravi Kanth\\Desktop\\testdata.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
