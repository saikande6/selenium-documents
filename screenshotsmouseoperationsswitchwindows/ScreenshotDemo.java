package com.icici.BankingDomain;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotDemo {

WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testMultiFrame() throws InterruptedException, IOException
	{
		Date dt=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//FileUtils is a predefined class in java & copyFile is a predefined method
		FileUtils.copyFile(scrFile,new File("C:\\Users\\Ravi Kanth\\Desktop\\"+dateFormat.format(dt)+".png"));
	}
	
	@AfterMethod
	public void teradown()
	{
		driver.quit();
	}
	
}
