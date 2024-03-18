package generics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base_test extends Excel_librarary implements Constant{
	public static WebDriver driver;

	@BeforeSuite
	public void executionstart()
	{  
		System.out.println("execution started");
		Reporter.log("started execution 1st time");
	}

	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "./log_File/New.txt");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeOptions a=new ChromeOptions();
	    //a.setHeadless(true);
		//a.addArguments("headless");
		a.addArguments("disable-notification");
		
		driver=new ChromeDriver(a);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demo.actitime.com");
		
	}

	

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void captureScreenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE) {
        	

        	TakesScreenshot ts= (TakesScreenshot)Base_test.driver;
    		File source_file=ts.getScreenshotAs(OutputType.FILE);


    		String name=result.getName();
    		
    		Date today=Calendar.getInstance().getTime();
    		String date=today.toString().replaceAll(":", "");
    		System.out.println(today);


    		//LocalTime l=LocalTime.now();

    		File destfile=new File("./Screenshot/"+name+date+"failed"+".png");
    		
    		
    		try {
    			FileUtils.copyFile(source_file, destfile);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
        }
        	
        }
}
