package generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_page implements Constant{
	
	public WebDriver driver;
	
	
	
	public void selectbtvisibletext(List<WebElement> Suggestion, String project_real){
		for(int i=0;i<Suggestion.size();i++){
		 if(Suggestion.get(i).getText().equals(project_real)) {
				 Suggestion.get(i).click();
				 break;
			 }}}
	
	public void select_text(WebElement ele,String txt) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(txt);	
		// sel.selectByIndex( num);
		// sel.selectByVisibleText("");
	}	 

	public void click_to_element(WebElement ele  )
	{
		ele.click();
	}

	public void movetoelement(WebElement ele)
	{   
		Actions act=new Actions(driver);
		Actions bh=act.moveToElement(ele);
		bh.click().perform();
	}
	
	public void javascriptclick(WebDriver driver , WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		js.executeScript("arguments[0].value='abc';", ele);
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("windows.ScrollBy(0,200)");
	}
		
	public void robenter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void alertaccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
		alt.dismiss();
	
	}
	public void sendkey_to_element(WebElement ele, String Data) {
		ele.sendKeys(Data);
		
	}
	public void javascript() {
		JavascriptExecutor d=(JavascriptExecutor)Base_test.driver;
		d.executeScript("arguments[0],value='Big'");
	}
	public void robotB() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_B);
	}
	public void javascriptclick(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)Base_test.driver;
		js.executeScript("arguments[0].click();",ele);
	}
	public void scrolToElement(WebElement ele) {
         //Scroll the page to bring the element into view
		JavascriptExecutor js = (JavascriptExecutor)Base_test.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();", ele);
		js.executeScript("arguments[0].value='abc';", ele);
	}
}
