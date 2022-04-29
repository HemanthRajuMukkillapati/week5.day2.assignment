package week5.day2.assignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass {
	
	@Test(dataProvider = "fetchdata")
	public void createLead(String cname,String Fname,String Lname) {
		
				
		// click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//createLeadForm_companyName
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		
		//createLeadForm_firstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
		
		//createLeadForm_lastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);

		//click in source drop-down
		WebElement elesource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//object for Select class  
		Select sourcedd = new Select(elesource);
		
		//select by visible text 'Employee'
		sourcedd.selectByVisibleText("Employee");
			
		//click on Create lead
		driver.findElement(By.className("smallSubmit")).click();
		
		//verify source drop down value
		String verifySourcevalue=driver.findElement(By.id("viewLead_dataSources_sp")).getText();
		
		//print source drop down value
		System.out.println(verifySourcevalue);
		
		//get the page title and print
		System.out.println(driver.getTitle());	
		

	}
	
	@DataProvider
	public String [][] fetchdata() throws IOException {
		return ReadExcel.readData("CreateLead"); //static methods can be called using class name
	}
	
	

}
