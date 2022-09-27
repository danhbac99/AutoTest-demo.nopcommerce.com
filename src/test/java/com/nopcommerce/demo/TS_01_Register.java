package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.RegisterPageObject;
import pageUI.RegisterPageUI;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPageObj;
	RegisterPageUI registerPageUI;

	@BeforeClass
	public void beforeClass() {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage);
		registerPageObj = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPageObj.clickToRegisterButton();
		Assert.assertTrue(registerPageObj.checkFirstnameErrorMessage("First name is required."));
		Assert.assertTrue(registerPageObj.checkLastnameErrorMessage("Last name is required."));
		Assert.assertTrue(registerPageObj.checkEmailErrorMessage("Email is required."));
		Assert.assertTrue(registerPageObj.checkPasswordErrorMessage("Password is required."));
		Assert.assertTrue(registerPageObj.checkConfirmPasswordErrorMessage("Password is required."));
		sleep(3);
	}

//	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, "danhb");
		registerPageObj.clickToRegisterButton();
		Assert.assertTrue(registerPageObj.checkEmailErrorMessage("Wrong email"));
	}

//	@Test
	public void TC_03_RegisterSuccess() {
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_INPUT, "Bac");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.LASTNAME_INPUT, "Nguyen");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, "bac1@gmail.com");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.PASS_INPUT, "123456");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASS_INPUT, "123456");
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkRegisterSuccess("Your registration completed"));
		sleep(3);
	}

//	@Test
	public void TC_04_RegisterWithExistsEmail() {
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_INPUT, "Bac");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.LASTNAME_INPUT, "Nguyen");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, "bac1@gmail.com");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.PASS_INPUT, "123456");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASS_INPUT, "123456");
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkExistsEmail("The specified email already exists"));
	}

//	@Test
	public void TC_05_RegisterWithErrorPass() {
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_INPUT, "Bac");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.LASTNAME_INPUT, "Nguyen");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, "bac1@gmail.com");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.PASS_INPUT, "123");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASS_INPUT, "123");

		Assert.assertTrue(registerPageObj.checkPasswordErrorMessage("Password must meet the following rules:\n"
				+ "must have at least 6 characters"));
	}
	
	@Test
	public void TC_06_RegisterWithErrorConfirmPass() {
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_INPUT, "Bac");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.LASTNAME_INPUT, "Nguyen");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.EMAIL_INPUT, "bac1@gmail.com");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.PASS_INPUT, "123456");
		registerPageObj.sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASS_INPUT, "123");
		registerPageObj.clickToRegisterButton();
		
		Assert.assertTrue(registerPageObj.checkConfirmPasswordErrorMessage("The password and confirmation password do not match."));
	}
}
