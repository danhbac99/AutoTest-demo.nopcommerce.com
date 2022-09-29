package pageObjects;

import org.openqa.selenium.WebDriver;


import common.BasePage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public void clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}
	
	public boolean checkErrorMessage(String textboxName, String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.ERROR_MSG, textboxName);
		return errorMessage.equals(value);
	}
	
//	public boolean checkFirstnameErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkLastnameErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkEmailErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkPasswordErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
//	public boolean checkConfirmPasswordErrorMessage(String value) {
//		String errorMessage = getTextOfElement(driver, RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
//		return errorMessage.equals(value);
//	}
//	
	public boolean checkRegisterSuccess(String value) {
		String successMessage = getTextOfElement(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
		return successMessage.equals(value);
	}
	
	public boolean checkExistsEmail(String value) {
		String existsEmail = getTextOfElement(driver, RegisterPageUI.EMAIL_EXISTS_MSG);
		return existsEmail.equals(value);
	}
	
	public void enterTextToTextbox(String textboxName, String value) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_INPUT, textboxName);
		sendKeysToElement(driver, RegisterPageUI.TEXTBOX_INPUT, value, textboxName);
	}
	
//	public void enterTextToEmailBox(String email) {
//		waitForElementVisible(driver, RegisterPageUI.EMAIL_INPUT);
//		sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, email);
//	}
//	
//	public void enterTextToFirstName(String firstName) {
//		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_INPUT);
//		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_INPUT, firstName);
//	}
//	
//	public void enterTextToLastName(String lastName) {
//		waitForElementVisible(driver, RegisterPageUI.LASTNAME_INPUT);
//		sendKeysToElement(driver, RegisterPageUI.LASTNAME_INPUT, lastName);
//	}
//	
//	public void enterTextToPassWord(String passWord) {
//		waitForElementVisible(driver, RegisterPageUI.PASS_INPUT);
//		sendKeysToElement(driver, RegisterPageUI.PASS_INPUT, passWord);
//	}
//	
//	public void enterTextToConfirmPassWord(String confirmPassWord) {
//		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASS_INPUT);
//		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASS_INPUT, confirmPassWord);
//	}

}
