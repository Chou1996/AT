package test;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.Base_test;
import pom.Create_new_typeOfWork;
import pom.HomePage;

public class Create_Type_of_work extends Base_test{
	@Test(dataProvider = "nameData")
	public void create_new_work() throws IOException {
	HomePage home=new HomePage(driver);
	home.settingsMethod();
	home.create_type_work();
	Create_new_typeOfWork cr=new Create_new_typeOfWork(driver);
	cr.create_work();
	
	}
}
