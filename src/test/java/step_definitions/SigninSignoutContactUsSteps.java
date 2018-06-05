package step_definitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import modules.ContactUsAction;
import modules.SignInAction;
import modules.SignoutAction;
import pageobjects.AutomationHomePage;
import pageobjects.ContactusPage;
import pageobjects.LoginPage;


public class SigninSignoutContactUsSteps {
    public WebDriver driver;
    public List<HashMap<String,String>> datamap;
    
    
    public SigninSignoutContactUsSteps()
    {
    	driver = Hooks.driver;
     	datamap = DataHelper.data();
    }
    
    @Given("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.get("http://automationpractice.com");
    }

    @When("^I sign in$")
    public void i_sign_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	PageFactory.initElements(driver, AutomationHomePage.class);
		PageFactory.initElements(driver, LoginPage.class);

		SignInAction.Execute(driver,datamap);
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	SignoutAction.Execute(driver,datamap);
    }
}