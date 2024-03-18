package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_test extends Excel_librarary implements Constant {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void executionstart() {
		System.out.println("execution started");
		Reporter.log("started execution 1st time");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\KIIT\\Desktop\\Atnmm\\AT\\Files\\Data.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setup() {
		String Name = prop.getProperty("browser");
		if (Name.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.logfile", "./log_File/New.txt");
		
			//System.setProperty("webdriver.chrome.silentOutput", "true");
			// ChromeOptions options = new ChromeOptions();
			// options.setBinary("C:\\Users\\KIIT\\Downloads\\chrome-win64\\chrome.exe");
			// a.setHeadless(true);
			// a.addArguments("headless");
		      //  options.addArguments("disable-notification");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		} else if (Name.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
			System.setProperty("webdriver.firefox.silentOutput", "true");
			FirefoxOptions a = new FirefoxOptions();
			// a.setHeadless(true);
			// a.addArguments("headless");
			a.addArguments("disable-notification");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		driver.get("https://demo.actitime.com");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void captureScreenshotOnFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			TakesScreenshot ts = (TakesScreenshot) Base_test.driver;
			File source_file = ts.getScreenshotAs(OutputType.FILE);

			String name = result.getName();

			Date today = Calendar.getInstance().getTime();
			String date = today.toString().replaceAll(":", "");
			System.out.println(today);

			// LocalTime l=LocalTime.now();

			File destfile = new File("./Screenshot/" + name + date + "failed" + ".png");

			try {
				FileUtils.copyFile(source_file, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
