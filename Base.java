package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base {

	public static WebDriver d;
	webDriverUtil wutil = new webDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	
	@BeforeSuite
	public void BS() 
	{
		System.out.println("Connect to Data Base");
		
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
		
		//@BeforeClass is used to launch appplication
		String URL = putil.getDataFromPropertyFile("Url");
		
		WebDriver d= new ChromeDriver();
	      
	    //To maximize the window
	    wutil.maximize(d);
	      
	    //To apply wait for findElement()
	    wutil.implicitwait(d);
	    
	    //To launch the application
	    d.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException
	{
		//@BeforeMethod is used to Login the application
		String USERNAME = putil.getDataFromPropertyFile("Username");
	    String PASSWORD = putil.getDataFromPropertyFile("Password");
	    
	    //Login the application
	    d.findElement(By.name("user_name")).sendKeys(USERNAME);
	    d.findElement(By.name("user_password")).sendKeys(PASSWORD);
        d.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AM() throws InterruptedException
	{
		//@AfterMethod is used to SignOut from the Application
		
		Thread.sleep(2000);
		
		//Mousehover on image
	    WebElement img = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	      
	    wutil.mouseHover(d, img);
	      
	    Thread.sleep(2000);
	  
	    d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void AC()
	{
		//@AfterClass is used to close the browser
		d.quit();
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Disconnect from Data Base");
	}
}
