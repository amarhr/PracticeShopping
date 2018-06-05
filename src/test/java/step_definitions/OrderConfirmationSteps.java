package step_definitions;

import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.OrderConfirmationAction;
import modules.OrderSummaryAction;
import modules.PaymentAction;
import modules.SelectAndCheckout;
import modules.VerifyAddressProceed;
import modules.VerifyShippingAddressProceed;
import modules.VerifyShoppingCartSummaryAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.AddressPage;
import pageobjects.AutomationHomePage;
import pageobjects.OrderConfirmationPage;
import pageobjects.OrderSummaryPage;
import pageobjects.PaymentMethodPage;
import pageobjects.ShippingAddressPage;
import pageobjects.ShoppingCartSummaryPage;
import pageobjects.SummerDressesCatalogPage;

import java.util.HashMap;
import java.util.List;

public class OrderConfirmationSteps {

	public WebDriver driver;
	public List<HashMap<String, String>> datamap;

	public OrderConfirmationSteps() {
		driver = Hooks.driver;
		datamap = DataHelper.data();
	}

	@Then("^I verify order confirmation page details and verify success message$")
	public void i_verify_order_confirmation_page_details_and_verify_success_message() throws Throwable {
		PageFactory.initElements(driver, OrderConfirmationPage.class);
		OrderConfirmationAction.Execute(driver, datamap);
	}

	@Then("^I verify address and proceed$")
	public void i_verify_address_and_proceed() throws Throwable {
		PageFactory.initElements(driver, AddressPage.class);
		VerifyAddressProceed.Execute(driver, datamap);

	}

	@Then("^I verify order summary page and proceed$")
	public void i_verify_order_summary_page_and_proceed() throws Throwable {
		PageFactory.initElements(driver, OrderSummaryPage.class);
		OrderSummaryAction.Execute(driver, datamap);

	}

	@Then("^I verify payment details page and proceed$")
	public void i_verify_payment_details_page_and_proceed() throws Throwable {
		PageFactory.initElements(driver, PaymentMethodPage.class);
		PaymentAction.Execute(driver, datamap);

	}

	@Then("^I select a dress and proceed to checkout$")
	public void i_select_a_dress_and_proceed_to_checkout() throws Throwable {

		PageFactory.initElements(driver, AutomationHomePage.HeaderPage.class);
		PageFactory.initElements(driver, AutomationHomePage.HeaderPage.WomenPage.class);
		PageFactory.initElements(driver, AutomationHomePage.HeaderPage.WomenPage.DressesPage.class);
		PageFactory.initElements(driver, SummerDressesCatalogPage.class);
		PageFactory.initElements(driver, SummerDressesCatalogPage.PrintedSummerDress1.class);
		PageFactory.initElements(driver, SummerDressesCatalogPage.CartPopup.class);

		SelectAndCheckout.Execute(driver, datamap);

	}
	

    @Then("^I verify shipping details and proceed$")
    public void i_verify_shipping_details_and_proceed() throws Throwable {
        PageFactory.initElements(driver, ShippingAddressPage.class);
        VerifyShippingAddressProceed.Execute(driver,datamap);

    }
    

    @Then("^I verify details on shoppingCart summary page$")
    public void i_verify_details_on_shoppingCart_summary_page() throws Throwable {

        PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
        VerifyShoppingCartSummaryAction.Execute(driver,datamap);

    }
}
