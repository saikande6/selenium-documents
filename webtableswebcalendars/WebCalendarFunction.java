package com.icici.BankingDomain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCalendarFunction {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//CheckIn
		driver.get("https://www.tripadvisor.in/");
		//driver.findElement(By.xpath("//span[text()='Check In']")).click();
		driver.findElement(By.xpath("//span[@class='picker-label target ui_picker_arrow_target']")).click();
		Thread.sleep(8000);
		String date="1-Nov 2018";
		String splitter[]=date.split("-");
		String checkInday=splitter[0];
		String checkInMonth =splitter[1];
		
		selectDate(checkInMonth,checkInday);
		
		Thread.sleep(6000);
		//CheckOut
		//driver.findElement(By.xpath("//span[text()='Check Out']")).click();
		driver.findElement(By.xpath(".//*[@id='taplc_trip_search_home_default_0']/div[2]/div[2]/div/span[3]/span[2]/span")).click();
		String date1="6-Nov 2018";
		String splitter1[]=date1.split("-");
		String checkOutday=splitter1[0];
		String checkOutMonth =splitter1[1];
		
		selectDate(checkOutMonth,checkOutday);
		
		
	}
	
	
		public static void selectDate(String month_year,String day) throws InterruptedException
		{
			
			List<WebElement> elements= driver.findElements(By.xpath("//div[@class='rsdc-months']/span/span[1]"));
			System.out.println(elements.size());
			for(int i=0;i<elements.size();i++)
			{
				System.out.println(elements.get(i).getText());
				if(elements.get(i).getText().equals(month_year))
				{
					
					List<WebElement> days=driver.findElements(By.xpath("//div[@class='rsdc-months']/span["+(i+1)+"]/span"));
					for(WebElement d: days)
					{
						System.out.println(d.getText());
						if(d.getText().equals(day))
						{
							d.click();
							return;
						}
					}
				}
			}
			
			
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".rsdc-next.rsdc-nav.ui_icon.single-chevron-right-circle")))).click();
			//Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".rsdc-next.rsdc-nav.ui_icon.single-chevron-right-circle")))).click();

			
			Thread.sleep(2000);
			selectDate(month_year,day);
		}
}
