package step_definitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import modules.UpdatePersonalinfoAction;
import pageobjects.AutomationHomePage;
import pageobjects.MyAccountPage;
import pageobjects.UpdatePersonalInfoPage;

public class UpdatePersonalInfoSteps {
	public WebDriver driver;
	public List<HashMap<String, String>> datamap;

	public UpdatePersonalInfoSteps() {
		driver = Hooks.driver;
		datamap = DataHelper.data();
	}

	@When("^I update firstname as \"(.*?)\"$")
	public void iUpdateFirstNameAs(String firstName) throws Throwable {
		PageFactory.initElements(driver, MyAccountPage.class);
		AutomationHomePage.personal_information.click();
		MyAccountPage.myPersonalInformation.click();

		// Thread.sleep(5000);
		PageFactory.initElements(driver, UpdatePersonalInfoPage.class);
		UpdatePersonalinfoAction.UpdateFirstName(driver, datamap, firstName);
	}
	
	@When("^I update social title as \"(.*?)\"$")
	public void iUpdateSocialTitleAs(String socialTitle) throws Throwable {
		PageFactory.initElements(driver, MyAccountPage.class);
		AutomationHomePage.personal_information.click();
		MyAccountPage.myPersonalInformation.click();

		PageFactory.initElements(driver, UpdatePersonalInfoPage.class);
		UpdatePersonalinfoAction.UpdateSocialTitle(driver, datamap, socialTitle);
	}
	
	@When("^I update user details$")
	public void iUpdateSocialTitleAs(DataTable userDetailsTable) throws Throwable {
		List<Map<String,String>> listofDataMapRows = userDetailsTable.asMaps(String.class,String.class);
		Map<String,String> rowAsMap = listofDataMapRows.get(0);
		
		PageFactory.initElements(driver, MyAccountPage.class);
		AutomationHomePage.personal_information.click();
		MyAccountPage.myPersonalInformation.click();

		PageFactory.initElements(driver, UpdatePersonalInfoPage.class);
		UpdatePersonalinfoAction.UpdateUserDetails(driver, rowAsMap);
	}
	
	@Then("^I verify the user displayed name as \"(.*?)\"$")
	public void i_verify_the_user_displayed_name_as(String firstLastName) throws Throwable {
		PageFactory.initElements(driver, UpdatePersonalInfoPage.class);
		
		UpdatePersonalinfoAction.VerifyFirstLastName(driver, datamap, firstLastName);
	}
}
