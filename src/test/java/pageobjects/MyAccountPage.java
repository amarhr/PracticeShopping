package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends BaseClass{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//a[@title='Information']/span[text()='My personal information']")
	public static WebElement myPersonalInformation;
	
}
