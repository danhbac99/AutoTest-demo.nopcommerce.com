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
	
	public boolean checkFirstnameErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkLastnameErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkEmailErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkPasswordErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.PASS_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkConfirmPasswordErrorMessage(String value) {
		String errorMessage = getTextOfElement(driver, RegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
		return errorMessage.equals(value);
	}
	
	public boolean checkRegisterSuccess(String value) {
		String successMessage = getTextOfElement(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
		return successMessage.equals(value);
	}
	
	public boolean checkExistsEmail(String value) {
		String existsEmail = getTextOfElement(driver, RegisterPageUI.EMAIL_EXISTS_MSG);
		return existsEmail.equals(value);
	}

}
