package modules;

import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.UpdatePersonalInfoPage;

public class UpdatePersonalinfoAction {
	
	private static void updateFirstName(String firstName) {
		WebElement firstnameTextbox = UpdatePersonalInfoPage.firstnameTextbox;
		
		firstnameTextbox.clear();
		firstnameTextbox.sendKeys(firstName);
	}
	
	private static void updateLastName(String lastName) {
		WebElement lastnameTextbox = UpdatePersonalInfoPage.lastnameTextbox;
		
		lastnameTextbox.clear();
		lastnameTextbox.sendKeys(lastName);
	}
	
	private static void updatePassword(String currentPwd, String newPwd) {
		UpdatePersonalInfoPage.currentPasswdTextbox.sendKeys(currentPwd);
		UpdatePersonalInfoPage.newPasswdTextbox.sendKeys(newPwd);
		UpdatePersonalInfoPage.confirmationPasswdTextbox.sendKeys(newPwd);
	}
	
	private static void enterPassword(String currentPwd) {
		UpdatePersonalInfoPage.currentPasswdTextbox.sendKeys(currentPwd);
	}
	
	private static void updateSocialTitle(String socialTitle) {
		WebElement socialTitleRadioButton = null;
		switch(socialTitle) {
			case "Mr.": socialTitleRadioButton = UpdatePersonalInfoPage.titleMr;
						socialTitleRadioButton.click(); break;
			case "Mrs.": socialTitleRadioButton = UpdatePersonalInfoPage.titleMrs;
						socialTitleRadioButton.click(); break;
			default: break;				
		}
	}
	
	public static void UpdateFirstName(WebDriver driver, List<HashMap<String, String>> map, String firstName)
			throws Exception {
		String currentPassword = map.get(0).get("password");
		updateFirstName(firstName);
		enterPassword(currentPassword);
		
		UpdatePersonalInfoPage.saveButton.click();
	}
	
	public static void UpdateSocialTitle(WebDriver driver, List<HashMap<String, String>> map, String socialTitle)
			throws Exception {
		updateSocialTitle(socialTitle);
		enterPassword(map.get(0).get("password"));
		UpdatePersonalInfoPage.saveButton.click();
	}
	
	public static void UpdateUserDetails(WebDriver driver, Map<String, String> rowAsMap)
			throws Exception {
		
		updateSocialTitle(rowAsMap.get("Title"));
		updateFirstName(rowAsMap.get("Firstname"));
		updateLastName(rowAsMap.get("Lastname"));
		enterPassword(rowAsMap.get("Password"));
		
		UpdatePersonalInfoPage.saveButton.click();
	}

	public static void VerifyFirstLastName(WebDriver driver, List<HashMap<String, String>> map, String expectedfirstLastName)
			throws Exception {
		String actualFirstNameLastName = UpdatePersonalInfoPage.personal_information.getText();
		
		System.out.println(" expectedfirstLastName : " + expectedfirstLastName);
		System.out.println(" actualFirstNameLastName : " + actualFirstNameLastName);
		assertEquals(expectedfirstLastName, actualFirstNameLastName);
	}
}