package pom;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Constant;
import generics.Base_page;
import generics.Excel_librarary;

public class HomePage extends Base_page implements Constant
{   public static WebDriver driver;

	@FindBy(xpath ="//a[@href='/logout.do']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//a[@class='item active']")
	private WebElement View_Time_Track;
	@FindBy(xpath = "//a[@class='item active']")
	private WebElement Lock_Time_Track;
	@FindBy(xpath = "//a[.='Approve Time-Track']")
	private WebElement Approve_Time_Track;
	
	@FindBy(xpath = "(//div[@class='menu_icon'])[2]")
	private WebElement settingsLink;
	@FindBy(xpath ="//a[.='Types of Work']")
	private WebElement Type_of_work;
	@FindBy(xpath = "//span[.='Create Type of Work']")
	private WebElement CreateWork;
	
	
	@FindBy(xpath = "//div[@id='container_tasks']")
	private WebElement tasksLink;
	@FindBy(xpath="//div[.='Add New']")
	private WebElement AddnewCustomer;
	@FindBy(xpath="//div[@class='item createNewCustomer']")
	private WebElement New_Customer;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement Customer_name;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement Customer_description;
	
	@FindBy(xpath ="(//div[@class='dropdownButton'])[15]")
	private WebElement Copy_project;
	
	@FindBy(xpath="//div[@class='itemRow cpItemRow ']")
	public List<WebElement> Copy_Projects;
	@FindBy(xpath="(//div[@class='components_button_label'])[17]")
	private WebElement Create_Submit;
	
	
	

	
	public HomePage(WebDriver driver)
	{ this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	public void logoutMethod()
	{
		javascriptclick(logoutLink);
		
	}
	public void taskMethod() throws IOException, InterruptedException, AWTException
	{
		javascriptclick(tasksLink);
		Thread.sleep(3000);
		javascriptclick(AddnewCustomer);
		javascriptclick(New_Customer);
		Customer_name.sendKeys(Excel_librarary.getcellvalue(Create_customer, 1, 0));
		Customer_description.sendKeys(Excel_librarary.getcellvalue(Create_customer, 1, 1));
		click_to_element(Copy_project);
		robotB();
		Thread.sleep(3000);
		selectbtvisibletext(Copy_Projects,project_real);
		Thread.sleep(3000);
	   javascriptclick(Create_Submit);
	   Thread.sleep(3000);
	
		for(int i=0;i<Copy_Projects.size();i++)
		 { 
			 if(Copy_Projects.get(i).getText().equals("Reebok T Shirts")) {
				 Copy_Projects.get(i).click();
				 break;
			 }
		 }
		
	}
	public void view_Time_Track() {
		View_Time_Track.click();
	}
	public void lock_time_track() {
		Lock_Time_Track.click();
	}
	public void approve_time_track(){
		Approve_Time_Track.click();
	}
	
	
	public void settingsMethod(){
		settingsLink.click();}	
	public void create_type_work() throws IOException {
		Type_of_work.click();
		click_to_element(CreateWork);
}}