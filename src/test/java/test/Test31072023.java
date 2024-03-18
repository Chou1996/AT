package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test31072023 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.setBinary("C:\\Users\\KIIT\\Downloads\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(c);
		driver.get("https://www.google.com/");
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
