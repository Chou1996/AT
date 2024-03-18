package generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pom.HomePage;

public class Base_test_with_for_crossBrowser_testing implements Constant {
public  static WebDriver driver;
	
	@BeforeSuite
	public void executionstart()
	{
		System.out.println("execution started");
	}
	@Parameters("BRS")
	@BeforeMethod
	public void setup(String BRS) throws IOException, InterruptedException 
	{   
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.logfile", "./log_File/chromelog.txt");

		if(BRS.equalsIgnoreCase("chrome"))
		{
			System.setProperty(chrome_key, chrome_value);
		driver=new ChromeDriver();
		}
		else if(BRS.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.silentOutput", "true");
			System.setProperty(gecko_key, gecko_value);
			driver=new FirefoxDriver();
}
			else {
				System.setProperty("webdriver.edge.silentOutput", "true");
				System.setProperty(edge_key, edge_value);	
			    driver=new EdgeDriver();
				
			}	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@AfterMethod
	public void logoutfromapp()
	{
		HomePage home=new HomePage(driver);
		home.logoutMethod();
		driver.close();
	}
	
	
	
	@AfterSuite
	public void executioncomplete()
	{
		System.out.println("exceution completed");
	}


}
