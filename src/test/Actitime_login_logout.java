package test;

import java.io.IOException;
import org.testng.annotations.Test;
import generics.Base_test;
import generics.Base_test_with_for_crossBrowser_testing;
import pom.HomePage;
import pom.LoginPage;

public class Actitime_login_logout extends Base_test{
 @Test(testName = "LogInOUT11")
	public void login_logout() throws IOException, InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.loginMethod();
		
		System.out.println("executing the script");
		
		HomePage Home=new HomePage(driver);
		Home.logoutMethod();
	
	}

}
 