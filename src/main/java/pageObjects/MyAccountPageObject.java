package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUI.MyAccountUI;

public class MyAccountPageObject extends BasePage {

	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMaleRadioButton() {
		waitForElementClickable(driver, MyAccountUI.MALE_RADIO);
		clickToElement(driver, MyAccountUI.MALE_RADIO);
	}

	public void clickToFeMaleRadioButton() {
		waitForElementClickable(driver, MyAccountUI.FEMALE_RADIO);
		clickToElement(driver, MyAccountUI.FEMALE_RADIO);
	}

	public void enterTextToTextbox(String textboxName, String value) {
		waitForElementVisible(driver, MyAccountUI.TEXTBOX_INPUT, textboxName);
		sendKeysToElement(driver, MyAccountUI.TEXTBOX_INPUT, value, textboxName);
	}

	public void selectDate(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_DATE);
		selectByValue(driver, MyAccountUI.SELECT_DATE, value);
	}

	public void selectMonth(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_MONTH);
		selectByValue(driver, MyAccountUI.SELECT_MONTH, value);
	}

	public void selectYear(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_YEAR);
		selectByValue(driver, MyAccountUI.SELECT_YEAR, value);
	}

	public void enterTextToCompanyName(String value) {
		waitForElementVisible(driver, MyAccountUI.COMPANY);
		sendKeysToElement(driver, MyAccountUI.COMPANY, value);
	}

	public void clickCheckboxOption() {
		waitForElementClickable(driver, MyAccountUI.OPTION_CHECKBOX);
		clickCheckbox(driver, MyAccountUI.OPTION_CHECKBOX);
	}

	public void unClickCheckboxOption() {
		waitForElementClickable(driver, MyAccountUI.OPTION_CHECKBOX);
		unClickCheckbox(driver, MyAccountUI.OPTION_CHECKBOX);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_BTN);
		clickToElement(driver, MyAccountUI.SAVE_BTN);
	}

	public boolean checkValueTextbox(String textboxName, String value) {
		waitForElementVisible(driver, MyAccountUI.TEXTBOX_INPUT, textboxName);
		String textboxValue = getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, textboxName);
		return textboxValue.contains(value);
	}

	public boolean checkCompanyName(String value) {
		String companyName = getAttribute(driver, MyAccountUI.COMPANY);
		return companyName.equals(value);
	}

	public boolean verifyChecked() {
		return verifyCheckboxChecked(driver, MyAccountUI.OPTION_CHECKBOX);
	}

	public boolean verifyMaleChecked() {
		return verifyCheckboxChecked(driver, MyAccountUI.MALE_RADIO);
	}

	public boolean verifyFemaleChecked() {
		return verifyCheckboxChecked(driver, MyAccountUI.FEMALE_RADIO);
	}

	public boolean checkDate(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_DATE);
		return checkSelectValue(driver, MyAccountUI.SELECT_DATE, value);
	}

	public boolean checkMonth(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_MONTH);
		return checkSelectValue(driver, MyAccountUI.SELECT_MONTH, value);
	}

	public boolean checkYear(String value) {
		waitForElementClickable(driver, MyAccountUI.SELECT_YEAR);
		return checkSelectValue(driver, MyAccountUI.SELECT_YEAR, value);
	}

	//////
	public void clickToAddressLink() {
		waitForElementClickable(driver, MyAccountUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountUI.ADDRESS_LINK);
	}

	public void clickToAddNewAddress() {
		waitForElementClickable(driver, MyAccountUI.NEWADDRESS_BUTTON);
		clickToElement(driver, MyAccountUI.NEWADDRESS_BUTTON);
	}

	public void enterTextToAddressTextbox(String textboxName, String value) {
		waitForElementVisible(driver, MyAccountUI.TEXTBOX_ADDRESS, textboxName);
		sendKeysToElement(driver, MyAccountUI.TEXTBOX_ADDRESS, value, textboxName);
	}

	public void selectAddressCountry(String value) {
//		waitForElementClickable(driver, MyAccountUI.COUNTRY_ADDRESS);
//		Select selectCountry = new Select(getElement(driver, MyAccountUI.COUNTRY_ADDRESS));
//		selectCountry.selectByVisibleText(value);
		selectByText(driver, MyAccountUI.COUNTRY_ADDRESS, value);
	}

	public void selectAddressProvide(String value) {
//		waitForElementClickable(driver, MyAccountUI.PROVIDE_ADDRESS);
//		Select selectCountry = new Select(getElement(driver, MyAccountUI.PROVIDE_ADDRESS));
//		selectCountry.selectByVisibleText(value);
		selectByText(driver, MyAccountUI.PROVIDE_ADDRESS, value);
	}

	public void clickToSaveAddress() {
		waitForElementClickable(driver, MyAccountUI.SAVEADDRESS_BUTTON);
		clickToElement(driver, MyAccountUI.SAVEADDRESS_BUTTON);
	}

	public boolean checkAddressTitle(String value) {
		String addressTitle = getTextOfElement(driver, MyAccountUI.ADDRESS_TITLE);
		return addressTitle.equals(value);
	}

	public boolean checkAddressInfo(String infoName, String value) {
		String info = getTextOfElement(driver, MyAccountUI.ADDRESS_INFO, infoName);
		return info.equals(value);
	}

	public void clickToChangePassword() {
		waitForElementClickable(driver, MyAccountUI.CHANGEPASSWORDD_LINK);
		clickToElement(driver, MyAccountUI.CHANGEPASSWORDD_LINK);
	}

	public void enterTextToOldPassword(String value) {
		waitForElementVisible(driver, MyAccountUI.OLD_PASSWORD);
		sendKeysToElement(driver, MyAccountUI.OLD_PASSWORD, value);
	}

	public void enterTextToNewPassword(String value) {
		waitForElementVisible(driver, MyAccountUI.NEW_PASSWORD);
		sendKeysToElement(driver, MyAccountUI.NEW_PASSWORD, value);
	}

	public void enterTextToConfirmNewPassword(String value) {
		waitForElementVisible(driver, MyAccountUI.CONFIRMNEW_PASSWORD);
		sendKeysToElement(driver, MyAccountUI.CONFIRMNEW_PASSWORD, value);
	}

	public void clickToSaveNewPassword() {
		waitForElementClickable(driver, MyAccountUI.CHANGEPASSWORD_BUTTON);
		clickToElement(driver, MyAccountUI.CHANGEPASSWORD_BUTTON);
	}

	public void clickToCloseNotification() {
		waitForElementClickable(driver, MyAccountUI.CLOSE_NOTIF_BUTTON);
		clickToElement(driver, MyAccountUI.CLOSE_NOTIF_BUTTON);
	}

	public void clickToLogout() {
		waitForElementClickable(driver, MyAccountUI.LOGOUT_BUTTON);
		clickToElement(driver, MyAccountUI.LOGOUT_BUTTON);
	}

	public void clickToLogin() {
		waitForElementClickable(driver, MyAccountUI.LOGIN_BUTTON);
		clickToElement(driver, MyAccountUI.LOGIN_BUTTON);
	}
}
