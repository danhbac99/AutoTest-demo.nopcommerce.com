package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstant;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageUI.MyAccountUI;

public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	MyAccountPageObject myAccountPageObj;
	LoginPageObject loginPageObj;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String pageUrl = "https://demo.nopcommerce.com/customer/info";
		driver = getBrowserDriver(pageUrl, browserName);
		myAccountPageObj = new MyAccountPageObject(driver);
		loginPageObj = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_00_Login() {
		loginPageObj.enterTextToEmailTextbox(GlobalConstant.username);
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.password);
		loginPageObj.clickToLoginButton();
	}
	
	@Test
	public void TC_01_UpdateInfo() {
		myAccountPageObj.clickToFeMaleRadioButton();
		myAccountPageObj.enterTextToTextbox("FirstName", "Hoang");
		myAccountPageObj.enterTextToTextbox("LastName", "Pham");
		myAccountPageObj.selectDate("12");
		myAccountPageObj.selectMonth("4");
		myAccountPageObj.selectYear("1999");
		myAccountPageObj.enterTextToTextbox("Email", "hoang21@gmail.com");
		myAccountPageObj.enterTextToCompanyName("Azure");
		myAccountPageObj.clickCheckboxOption();
		myAccountPageObj.clickToSaveButton();
		sleep(2);
		
		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "FirstName"));
		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "LastName"));
		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "Email"));
		System.out.println(myAccountPageObj.getAttribute(driver, MyAccountUI.COMPANY));
		System.out.println("date: " + myAccountPageObj.checkDate("12"));
		System.out.println("Check: " + myAccountPageObj.verifyChecked().isSelected());
		
		
		Assert.assertTrue(myAccountPageObj.verifyFemaleChecked().isDisplayed());
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("FirstName", "Hoang"));
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("LastName", "Pham"));
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("Email", "hoang21@gmail.com"));
		Assert.assertTrue(myAccountPageObj.checkCompanyName("Azure"));
		Assert.assertTrue(myAccountPageObj.verifyChecked().isSelected());
		Assert.assertTrue(myAccountPageObj.checkDate("12"));
		Assert.assertTrue(myAccountPageObj.checkMonth("April"));
		Assert.assertTrue(myAccountPageObj.checkYear("1999"));
	}
	
	@Test
	public void TC_02_UpdateAddress() {
		myAccountPageObj.clickToAddressLink();
		myAccountPageObj.clickToAddNewAddress();
		myAccountPageObj.enterTextToAddressTextbox("FirstName", "Kha");
		myAccountPageObj.enterTextToAddressTextbox("LastName", "Nguyen");
		myAccountPageObj.enterTextToAddressTextbox("Email", "kha@gmail.com");
		myAccountPageObj.enterTextToAddressTextbox("Company", "TDT");
		myAccountPageObj.selectAddressCountry("123");
//		sleep(5);
		myAccountPageObj.selectAddressProvide("0");
//		sleep(5);
		myAccountPageObj.enterTextToAddressTextbox("City", "HCMC");
		myAccountPageObj.enterTextToAddressTextbox("Address1", "District 1");
		myAccountPageObj.enterTextToAddressTextbox("Address2", "District 2");
		myAccountPageObj.enterTextToAddressTextbox("ZipPostalCode", "01234");
		myAccountPageObj.enterTextToAddressTextbox("PhoneNumber", "0987654321");
		myAccountPageObj.enterTextToAddressTextbox("FaxNumber", "0987654321");
		myAccountPageObj.clickToSaveAddress();
		sleep(3);
		System.out.println(myAccountPageObj.getTextOfElement(driver, MyAccountUI.ADDRESS_INFO, "name"));
		Assert.assertTrue(myAccountPageObj.checkAddressTitle("Kha Nguyen"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("name", "Kha Nguyen"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("email", "Email: kha@gmail.com"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("phone", "Phone number: 0987654321"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("fax", "Fax number: 0987654321"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("company", "TDT"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("address1", "District 1"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("address2", "District 2"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("city-state-zip", "HCMC, 01234"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("country", "Egypt"));
	}
	
//	@Test
	public void TC_03_ChangePassword() {
		myAccountPageObj.clickToChangePassword();
		myAccountPageObj.enterTextToOldPassword(GlobalConstant.password);
		myAccountPageObj.enterTextToNewPassword(GlobalConstant.newpassword);
		myAccountPageObj.enterTextToConfirmNewPassword(GlobalConstant.newpassword);
		myAccountPageObj.clickToSaveNewPassword();
		sleep(3);
		
		myAccountPageObj.clickToCloseNotification();
		sleep(3);
		myAccountPageObj.clickToLogout();
		sleep(3);
		myAccountPageObj.clickToLogin();
		sleep(3);
		loginPageObj.enterTextToEmailTextbox(GlobalConstant.username);
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.password);
		loginPageObj.clickToLoginButton();
		Assert.assertTrue(loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPageObj.checkLoginFail("The credentials provided are incorrect"));
		
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.newpassword);
		loginPageObj.clickToLoginButton();
		loginPageObj.checkLoginSuccess("https://demo.nopcommerce.com/");
	}
}
