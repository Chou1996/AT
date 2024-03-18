package test;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.Base_test;
import generics.ModuleCreater.Module;
import pom.HomePage;
import pom.LoginPage;

public class Actitime_login_logout extends Base_test{
	
	@Module("actual login logout")
 @Test(description = "Login and Logout from Application" ,testName = "abcddd",groups = "abc")
	public void login_logout() throws IOException, InterruptedException {
	
		LoginPage login=new LoginPage(driver);
		HomePage Home=login.loginMethod();
		Home.logoutMethod();
	
	}

}
 