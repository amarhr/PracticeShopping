package modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageobjects.AutomationHomePage;
import pageobjects.ContactusPage;


public class ContactUsAction {

	public static void ExecuteSendingMessageFails(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		AutomationHomePage.contact_us.click();
		// WebDriverWait wait = new WebDriverWait(driver,10);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(10,0)");
		ContactusPage.email.sendKeys((String)map.get(0).get("email"));
		ContactusPage.message.sendKeys(map.get(0).get("message"));
		ContactusPage.submit.click();
		Assert.assertTrue(ContactusPage.error_message.getText().contains("There is 1 error"));
	}
	
	public static void ExecuteSendingMessageWorks(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		AutomationHomePage.contact_us.click();
		// WebDriverWait wait = new WebDriverWait(driver,10);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(10,0)");
		// ContactusPage.email.sendKeys((String)map.get(0).get("email"));
		
		Select subjectDropDown = new Select(ContactusPage.subject_heading);
		subjectDropDown.selectByVisibleText("Customer service");
		
		Select orderDropDown = new Select(ContactusPage.order_reference); 
		orderDropDown.selectByIndex(1);
		
		Select productDropDown = new Select(ContactusPage.product);
		productDropDown.selectByIndex(1);
		
		ContactusPage.message.sendKeys(map.get(0).get("message"));
		ContactusPage.submit.click();
		//Assert.assertTrue(ContactusPage.error_message.getText().contains("There is 1 error"));
	}
}