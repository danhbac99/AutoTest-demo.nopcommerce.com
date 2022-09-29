package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public void enterTextToEmailTextbox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void enterTextToEmailPasswordbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public boolean checkErrorEmail(String value) {
		String errorMessage = getTextOfElement(driver, LoginPageUI.ERROR_EMAIL_MSG);
		return errorMessage.equals(value);
	}
	
	public boolean checkLoginFail(String value) {
		String errorMessage = getTextOfElement(driver, LoginPageUI.LOGIN_FAIL_MSG);
		return errorMessage.equals(value);
	}
}
