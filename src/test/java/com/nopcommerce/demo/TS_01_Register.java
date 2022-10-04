package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPageObj;
	HomePageObject homePageObj;
	String firstName = "Bac";
	String lastName = "Nguyen";
	String email = "bac7@gmail.com";
	String passWord = "123456";
	String confirmPassWord = "123456";

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		registerPageObj = new RegisterPageObject(driver);
		homePageObj = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPageObj.clickToRegisterButton();
//		Assert.assertTrue(registerPageObj.checkFirstnameErrorMessage("First name is required."));
//		Assert.assertTrue(registerPageObj.checkLastnameErrorMessage("Last name is required."));
//		Assert.assertTrue(registerPageObj.checkEmailErrorMessage("Email is required."));
//		Assert.assertTrue(registerPageObj.checkPasswordErrorMessage("Password is required."));
//		Assert.assertTrue(registerPageObj.checkConfirmPasswordErrorMessage("Password is required."));
//		sleep(3);
		
		Assert.assertTrue(registerPageObj.checkErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPageObj.checkErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPageObj.checkErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPageObj.checkErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPageObj.checkErrorMessage("ConfirmPassword", "Password is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("Email", "danhb");
		registerPageObj.clickToRegisterButton();
		Assert.assertTrue(registerPageObj.checkErrorMessage("Email","Wrong email"));
	}

	@Test
	public void TC_03_RegisterSuccess() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("FirstName", firstName);;
		registerPageObj.enterTextToTextbox("LastName", lastName);
		registerPageObj.enterTextToTextbox("Email", email);
		registerPageObj.enterTextToTextbox("Password", passWord);
		registerPageObj.enterTextToTextbox("ConfirmPassword", confirmPassWord);
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkRegisterSuccess("Your registration completed"));
		
		registerPageObj.clickToLogoutLink();
		homePageObj.clickToRegisterLink();
		
	}

	@Test
	public void TC_04_RegisterWithExistsEmail() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("FirstName", firstName);;
		registerPageObj.enterTextToTextbox("LastName", lastName);
		registerPageObj.enterTextToTextbox("Email", email);
		registerPageObj.enterTextToTextbox("Password", passWord);
		registerPageObj.enterTextToTextbox("ConfirmPassword", confirmPassWord);
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkExistsEmail("The specified email already exists"));
	}

	@Test
	public void TC_05_RegisterWithErrorPass() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("FirstName", firstName);;
		registerPageObj.enterTextToTextbox("LastName", lastName);
		registerPageObj.enterTextToTextbox("Email", email);
		registerPageObj.enterTextToTextbox("Password", "123");
		registerPageObj.enterTextToTextbox("ConfirmPassword", confirmPassWord);
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkErrorMessage("Password", "Password must meet the following rules:\n"
				+ "must have at least 6 characters"));
	}
	
	@Test
	public void TC_06_RegisterWithErrorConfirmPass() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("FirstName", firstName);;
		registerPageObj.enterTextToTextbox("LastName", lastName);
		registerPageObj.enterTextToTextbox("Email", email);
		registerPageObj.enterTextToTextbox("Password", passWord);
		registerPageObj.enterTextToTextbox("ConfirmPassword", "123");
		registerPageObj.clickToRegisterButton();
		
		Assert.assertTrue(registerPageObj.checkErrorMessage("ConfirmPassword", "The password and confirmation password do not match."));
	}
}
