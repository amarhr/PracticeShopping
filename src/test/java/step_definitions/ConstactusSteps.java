package step_definitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.ContactUsAction;
import pageobjects.AutomationHomePage;
import pageobjects.ContactusPage;

public class ConstactusSteps {
	public WebDriver driver;
	public List<HashMap<String, String>> datamap;

	public ConstactusSteps() {
		driver = Hooks.driver;
		datamap = DataHelper.data();
	}
	
	@Then("^I verify sending message with wrong email id fails$")
    public void I_perform_contact_us_actions() throws Throwable {
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, ContactusPage.class);
        ContactUsAction.ExecuteSendingMessageFails(driver,datamap);
    }
	
	@Then("^I verify sending message works$")
    public void I_verify_sending_message_works() throws Throwable {
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, ContactusPage.class);
        ContactUsAction.ExecuteSendingMessageWorks(driver,datamap);
    }
}
