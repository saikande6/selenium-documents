package com.icici.BankingDomain;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class windowsHandle {

	public static void main(String[] args) throws Exception {
		

		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
		  WebDriverWait wait=new WebDriverWait(driver, 60);
		  driver.get("http://www.hdfcbank.com/");
		  
		 // driver.findElement(By.id("div-close")).click();
		 // Thread.sleep(25000);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@alt='Close']")))).click();	  
		  System.out.println(driver.getTitle());	  
		  String homeWindow=driver.getWindowHandle();
		  System.out.println("Parent Window is ... " + homeWindow);

		  Thread.sleep(2000);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginsubmit")))).click();
		  driver.findElement(By.id("loginsubmit")).click();
		  Set<String> cWindow=driver.getWindowHandles();
		  System.out.println("Child Window is... " + cWindow.size());
		  
		  
		  Iterator<String> itr=cWindow.iterator();
		  while(itr.hasNext())
		  {
			  String currentWindowId=itr.next();
			  System.out.println("Windows are...:" + currentWindowId);
			  if(!currentWindowId.equals(homeWindow))
			  {
				  driver.switchTo().window(currentWindowId);
				  System.out.println(driver.getTitle());
			  }
		  }
		  //Thread.sleep(6000);
	
		  driver.manage().window().maximize();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Continue to NetBanking'])[2]")))).click();
		  driver.findElement(By.xpath("(//a[text()='Continue to NetBanking'])[2]")).click();
		  //Thread.sleep(6000);
		  driver.close(); 
		  
		  driver.switchTo().window(homeWindow);
		  System.out.println(driver.getTitle());
		  
		 
	}
}
