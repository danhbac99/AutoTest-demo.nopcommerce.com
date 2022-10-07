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
import util.DataHelper;

public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	MyAccountPageObject myAccountPageObj;
	LoginPageObject loginPageObj;

	// Info
	String firstName = DataHelper.getData().getFirstName();
	String lastName = DataHelper.getData().getLastName();
	String email = DataHelper.getData().getEmail();

	// Address
	String addressFirstName = DataHelper.getData().getFirstName();
	String addressLastName = DataHelper.getData().getLastName();
	String addressEmail = DataHelper.getData().getEmail();

	@Parameters({ "browser" })
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
		myAccountPageObj.enterTextToTextbox("FirstName", firstName);
		myAccountPageObj.enterTextToTextbox("LastName", lastName);
		myAccountPageObj.selectDate("12");
		myAccountPageObj.selectMonth("4");
		myAccountPageObj.selectYear("1999");
		myAccountPageObj.enterTextToTextbox("Email", email);
		myAccountPageObj.enterTextToCompanyName("Azure");
		myAccountPageObj.clickCheckboxOption();
		myAccountPageObj.clickToSaveButton();

		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "FirstName"));
		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "LastName"));
		System.out.println(myAccountPageObj.getAttributes(driver, MyAccountUI.TEXTBOX_INPUT, "Email"));
		System.out.println(myAccountPageObj.getAttribute(driver, MyAccountUI.COMPANY));
		System.out.println("date: " + myAccountPageObj.checkDate("12"));
		System.out.println("Check: " + myAccountPageObj.verifyChecked());

		Assert.assertTrue(myAccountPageObj.verifyFemaleChecked());
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("FirstName", firstName));
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("LastName", lastName));
		Assert.assertTrue(myAccountPageObj.checkValueTextbox("Email", email));
		Assert.assertTrue(myAccountPageObj.checkCompanyName("Azure"));
		Assert.assertTrue(myAccountPageObj.verifyChecked());
		Assert.assertTrue(myAccountPageObj.checkDate("12"));
		Assert.assertTrue(myAccountPageObj.checkMonth("April"));
		Assert.assertTrue(myAccountPageObj.checkYear("1999"));
	}

	@Test
	public void TC_02_UpdateAddress() {
		myAccountPageObj.clickToAddressLink();
		myAccountPageObj.clickToAddNewAddress();
		myAccountPageObj.enterTextToAddressTextbox("FirstName", addressFirstName);
		myAccountPageObj.enterTextToAddressTextbox("LastName", addressLastName);
		myAccountPageObj.enterTextToAddressTextbox("Email", addressEmail);
		myAccountPageObj.enterTextToAddressTextbox("Company", "TDT");
		myAccountPageObj.selectAddressCountry("United States");
//		sleep(2);
		myAccountPageObj.selectAddressProvide("California");
//		sleep(2);
		myAccountPageObj.enterTextToAddressTextbox("City", "HCMC");
		myAccountPageObj.enterTextToAddressTextbox("Address1", "District 1");
		myAccountPageObj.enterTextToAddressTextbox("Address2", "District 2");
		myAccountPageObj.enterTextToAddressTextbox("ZipPostalCode", "01234");
		myAccountPageObj.enterTextToAddressTextbox("PhoneNumber", "0987654321");
		myAccountPageObj.enterTextToAddressTextbox("FaxNumber", "0987654321");
		myAccountPageObj.clickToSaveAddress();
		sleep(2);

		Assert.assertTrue(myAccountPageObj.checkAddressTitle(addressFirstName + " " + addressLastName));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("name", addressFirstName + " " + addressLastName));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("email", "Email: " + addressEmail));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("phone", "Phone number: 0987654321"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("fax", "Fax number: 0987654321"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("company", "TDT"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("address1", "District 1"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("address2", "District 2"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("city-state-zip", "HCMC, " + "California, " + "01234"));
		Assert.assertTrue(myAccountPageObj.checkAddressInfo("country", "United States"));
	}

	@Test
	public void TC_03_ChangePassword() {
		myAccountPageObj.clickToChangePassword();
		myAccountPageObj.enterTextToOldPassword(GlobalConstant.password);
		myAccountPageObj.enterTextToNewPassword(GlobalConstant.newpassword);
		myAccountPageObj.enterTextToConfirmNewPassword(GlobalConstant.newpassword);
		myAccountPageObj.clickToSaveNewPassword();

		myAccountPageObj.clickToCloseNotification();
		sleep(2);
		myAccountPageObj.clickToLogout();
		sleep(2);
		myAccountPageObj.clickToLogin();

		loginPageObj.enterTextToEmailTextbox(GlobalConstant.username);
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.password);
		loginPageObj.clickToLoginButton();
		sleep(2);
		Assert.assertTrue(loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPageObj.checkLoginFail("The credentials provided are incorrect"));

		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.newpassword);
		loginPageObj.clickToLoginButton();
		sleep(2);
		loginPageObj.checkLoginSuccess("https://demo.nopcommerce.com/");
	}
}
