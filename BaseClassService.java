package week5.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassService {
	
	
	public  ChromeDriver driver;
	
	@Parameters({"URL","UserName","Password"})
	@BeforeMethod
	public void login(String url,String uname,String pwd) {
		
		//setup driver--static
		WebDriverManager.chromedriver().setup();
				
		//launch the browser
		driver=new ChromeDriver(); 	

		// launch below URL
		driver.get(url);

		// maximize window
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//enter user name
		driver.findElement(By.id("user_name")).sendKeys(uname);
		
		//enter password
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		
		//click on login button 
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
