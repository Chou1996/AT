package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Base_page;
import generics.Excel_librarary;

public class Create_new_typeOfWork extends Base_page{
	@FindBy(  xpath="//input[@name='name']")
	private WebElement Text;
	@FindBy(xpath="//select[@name='active']")
	private WebElement status;
	@FindBy(xpath="//input[@id='billingRate_input']")
	private WebElement billing_rate;
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement catagory;
	@FindBy(xpath = "(//input[@type='submit'])")
	private WebElement Submit;
	
	
	public Create_new_typeOfWork(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void create_work() throws IOException {
		click_to_element(Text);
		Text.sendKeys(Excel_librarary.getcellvalue(TypeofWork, 1, 0));
		select_text(status, "archived");
		click_to_element(billing_rate);
		billing_rate.sendKeys(Excel_librarary.getcellvalue(TypeofWork, 1, 2));
		click_to_element(catagory);
		click_to_element(Submit);
	}

	

}
