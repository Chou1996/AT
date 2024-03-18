package test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generics.Base_test;
import pom.HomePage;
import pom.LoginPage;
import pom.Task_Page;

public class Create_Customer extends Base_test{
	
	@Test(description = "Creating and deleting a Customer")
	public void create__customner_() throws IOException, InterruptedException, AWTException {
		
		LoginPage login=new LoginPage(driver);
		login.loginMethod();
		
		HomePage home=new HomePage(driver);
		home.taskMethod();
		
		Task_Page tsk=new Task_Page(driver);
		tsk.search_name();
		tsk.delete_customer();	
	}
	
}