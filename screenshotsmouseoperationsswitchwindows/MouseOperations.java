package com.icici.BankingDomain;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOperations 
{

	WebDriver driver;
	Actions a ;
	
	
	@BeforeMethod
	
	public void setup() throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	
	@Test (priority =0,enabled=false)
	public void MoveToelement() throws InterruptedException
	{	
		//moveToElement(WebElement target)
		driver.get("https://aptransport.in/tgcfstonline");		
		a=new Actions(driver);
		
		
		a.moveToElement(driver.findElement(By.xpath("//a[text()='ALTERNATE ADDRESS ENTRY']"))).click(driver.findElement(By.xpath("//a[text()='License Alternate Address Entry']"))).build().perform();
		//a.moveToElement(driver.findElement(By.linkText("ALTERNATE ADDRESS ENTRY"))).perform();
		driver.findElement(By.linkText("License Alternate Address Entry")).click();
		Thread.sleep(3000);
	}
	
	
	
	
	@Test (priority =1,enabled=false)
	public void dragAnddrop() throws InterruptedException
	{
		
		//dragAndDrop(WebElement source, WebElement target)
				driver.get("http://jqueryui.com/droppable/");
				driver.switchTo().frame(0);
				WebElement drag = driver.findElement(By.id("draggable"));
				WebElement drop = driver.findElement(By.id("droppable"));
				
				a= new Actions(driver);
				a.dragAndDrop(drag, drop).perform();
				Thread.sleep(4000);
	}
	
	
	
	@Test (priority =2,enabled=false)
	public void clickAndHoldMethod() throws InterruptedException
	{
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		
		a = new Actions(driver);
		a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		Thread.sleep(4000);
	}
	

	@Test (priority =4,enabled=false)
	public void rightClickMethod() throws InterruptedException
	{
		driver.get("http://jqueryui.com/");
		
		
		WebElement drag = driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[4]/a"));
		
	
		//WebDriverWait wait=new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		
		a = new Actions(driver);
		a.contextClick(drag).perform();
		
		Thread.sleep(8000);
	}
	
	
	
	
	@Test (priority =5,enabled=false)
	public void slider() throws InterruptedException
	{		
				driver.get("http://jqueryui.com/slider/");
				driver.switchTo().frame(0);
				WebElement drag = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
				a = new Actions(driver);
				a.dragAndDropBy(drag, 300, 0).perform();
				Thread.sleep(4000);			
	}
	
	
	
	
	@Test (priority =6,enabled=false)
	public void Browserslider() throws InterruptedException
	{
		
		//Browser Scroll Method
		driver.get("http://www.seleniumhq.org/download/");	
		
		for(int i=0;i<10;i++)
		{
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
		}
	}
	
	
	
	@Test(priority =7,enabled=true)
	public void autoSuggestion()
	{
		driver.get("https://www.google.co.in/");
		driver.findElement(By.id("lst-ib")).sendKeys("hadoop tutorial");
		//driver.findElement(By.name("btnK")).click();
		String val = driver.findElement(By.id("lst-ib")).getAttribute("value");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='sbsb_b']/li/div/div[2]"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equals(val))
			{
				list.get(i).click();
				return;
			}
		}
	}
	
	
		
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
}
