package generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screen_Shot extends Base_test implements ITestListener{
	public void onTestFailure(ITestResult result) {
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
		}}
	public void onTestSuccess(ITestResult result) {
		TakesScreenshot ts= (TakesScreenshot)Base_test.driver;
		File source_file=ts.getScreenshotAs(OutputType.FILE);


		String name=result.getName();
		Date today=Calendar.getInstance().getTime();
		String date=today.toString().replaceAll(":", "");
		System.out.println(today);


		//LocalTime l=LocalTime.now();

		File destfile=new File("./Screenshot/"+name+date+".png");
		try {
			FileUtils.copyFile(source_file, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}





	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
