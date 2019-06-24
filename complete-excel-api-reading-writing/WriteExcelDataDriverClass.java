package com.automation.excelreader;

public class WriteExcelDataDriverClass 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e=new ExcelAPI("C:\\Users\\Ravi Kanth\\Desktop\\testdata.xlsx");
		
		System.out.println("------Writing cell data to Excel by using Column Number--------");
		e.setCellData("login", 4, 4, "ravi");
		
		
		System.out.println("*********************************************");
		
		
		/*System.out.println("------Writing cell data to Excel by using Column Name--------");
		e.setCellData("login", "Result", 3, "Failed");*/
	}

}
