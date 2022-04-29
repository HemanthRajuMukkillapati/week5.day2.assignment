package week5.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	
	public ChromeDriver driver;
	
	@Parameters({"URL","UserName","Password"})
	@BeforeMethod
	public void login(String url,String uname,String pwd) 
	{
		
		//setup driver--static
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		
		driver=new ChromeDriver(); 	
		
		//Load the URl (get)--string input so in double quotes 	
		driver.get(url);
		//maximize the window
		driver.manage().window().maximize();
		
		//enter user name
		driver.findElement(By.id("username")).sendKeys(uname);
		
		//enter password
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		//click on submit button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//print title
		String title = driver.getTitle();
		System.out.println(title);
		
		//click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
