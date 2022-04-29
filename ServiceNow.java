package week5.day2.assignment;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ServiceNow extends BaseClassService
{
	@Test(dataProvider = "fetchdata")
	public void servicenow(String filTxt,String calname,String desc) throws InterruptedException 
	{
		
		Actions builder = new Actions(driver); 
		
		//type incidents in filter
		driver.findElement(By.xpath("//input[@name='filter']")).sendKeys(filTxt);
		
		//click on Incidents
		builder.click(driver.findElement(By.xpath("(//div[text()='Incidents'])[1]"))).perform();
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//click on all using builder object
		builder.click(driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a/b"))).perform();
		
		//click on new
		driver.findElement(By.id("sysverb_new")).click();
		
		//get incident number to an variable
		String incNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		
		//click on caller input box and enter data
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("Abraham Lincoln");
		
		Thread.sleep(3000);
		
		//click on description box and enter data
		driver.findElement(By.id("incident.short_description")).sendKeys("issues with windows");
		
		//click on submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(3000);
		
		//search with the stored incident number
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input[@placeholder='Search']")).sendKeys(incNo,Keys.ENTER);
		
		//compare incident we search vs created
		if(driver.findElement(By.xpath("//a[@class='linked formlink']")).getText().equals(incNo))
		{
			//print success message with incident no
			System.out.println("The created incident is displayed in search,Here is the no: "+incNo);
		}
		else 
		{
			//print wrong incident message
			System.out.println("wrong incident is dispalyed");
		}
	}
		
		@DataProvider
		public String [][] fetchdata() throws IOException 
		{
				//static methods can be called using class name
				return ReadExcel.readData("ServiceNow"); 
		}
			
		
	}

