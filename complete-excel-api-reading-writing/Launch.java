package com.automation.excelreader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e=new ExcelAPI("C:\\Users\\Ravi Kanth\\Desktop\\testdata.xlsx");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		int rcnt = e.getRowCount("login");
		
		for(int i=1;i<rcnt;i++)
		{
			//driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			
		}
		
	}

}
