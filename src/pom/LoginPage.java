package pom;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Constant;
import generics.Base_page;
import generics.Excel_librarary;

public class LoginPage extends Base_page implements Constant 
{       
	public static WebDriver driver;
	
	@FindBy(xpath ="//input[@name='username']")
	private WebElement usernameTextfield;

	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement passwordtextfield;

	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;

	@FindBy(id="loginButton")
	private WebElement loginButton;

	@FindBy(xpath = "//a[.='Forgot your password?']")
	private WebElement forgotyourpasswordLink;

	@FindBy(xpath = "//a[.='actiTIME Inc.']")
	private WebElement actitimeincLink;

	public LoginPage(WebDriver driver)
	{ this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	public void loginMethod() throws IOException, InterruptedException 
	{
		usernameTextfield.sendKeys(Excel_librarary.getcellvalue(sheet_name, 1, 0));
		passwordtextfield.sendKeys(Excel_librarary.getcellvalue(sheet_name, 1, 1));
		keepmeloggedinCheckbox.click();
		loginButton.click();
		Thread.sleep(3000);

	}

	public void forgotyourpasswordMethod()
	{
		forgotyourpasswordLink.click();
	}

	public void actitimeincMethod()
	{
		actitimeincLink.click();
	}
}
