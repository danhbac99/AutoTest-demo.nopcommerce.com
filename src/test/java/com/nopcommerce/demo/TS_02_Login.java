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

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPageObj;
	String email = "bac5@gmail.com";
	String passWord = "123456";

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String regisURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(regisURL, browserName);
		loginPageObj = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPageObj.clickToLoginButton();
		Assert.assertTrue(loginPageObj.checkErrorEmail("Please enter your email"));
	}
	
	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox("danhb");
		loginPageObj.enterTextToEmailPasswordbox("123456");
		loginPageObj.clickToLoginButton();
	}
	
	@Test
	public void TC_03_LoginWithWrongEmail() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox("danhb@gmail.com");
		loginPageObj.enterTextToEmailPasswordbox("123456");
		loginPageObj.clickToLoginButton();
		
		Assert.assertTrue(loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPageObj.checkLoginFail("No customer account found"));
	}
	
	@Test
	public void TC_04_loginWithEmptyPassword() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(email);
		loginPageObj.clickToLoginButton();
		
		Assert.assertTrue(loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPageObj.checkLoginFail("No customer account found"));
	}
	
	@Test
	public void TC_05_loginWithWrongPassword() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(email);
		loginPageObj.enterTextToEmailPasswordbox("111111");
		loginPageObj.clickToLoginButton();
		
		Assert.assertTrue(loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPageObj.checkLoginFail("No customer account found"));
	}
	
	@Test
	public void TC_06_loginSuccess() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(GlobalConstant.username);
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.password);
		loginPageObj.clickToLoginButton();
		
		Assert.assertTrue(loginPageObj.checkLoginSuccess("https://demo.nopcommerce.com/"));
	}

}
