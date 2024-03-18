package pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Base_page;

public class Task_Page extends Base_page {


	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]")
	private WebElement start_typing_name;
	@FindBy(xpath="//span[.='Jiban']/../../..//div[@class='editButton']")
	private WebElement setting;
	@FindBy(xpath="(//div[@class='action'])[1]")
	private WebElement actions;
	@FindBy(xpath = "(//div[.='Delete'])[2]")
	private WebElement dlt;
	@FindBy(xpath="//span[.='Delete permanently']")
	private WebElement delete_permanently;



	public Task_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void search_name() throws InterruptedException {
		start_typing_name.sendKeys("Jiban");
		Thread.sleep(2000);
	}
	public void delete_customer() throws InterruptedException {
		//movetoelement(setting);
		click_to_element(setting);
		Thread.sleep(2000);
		click_to_element(actions);
		click_to_element(dlt);
		click_to_element(delete_permanently);
		Thread.sleep(2000);
	}

}
