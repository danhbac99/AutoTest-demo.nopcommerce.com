package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.LoginPageObject;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPageObj;
	String email = "bac5@gmail.com";
	String passWord = "123456";

	@BeforeClass
	public void beforeClass() {
		String regisURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(regisURL);
		loginPageObj = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPageObj.clickToLoginButton();
		loginPageObj.checkErrorEmail("Please enter your email");
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
		
		loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again. No customer account found");
	}
	
	@Test
	public void TC_04_loginWithEmptyPassword() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(email);
		loginPageObj.clickToLoginButton();
		
		loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again. \n"
				+ "\n"
				+ "The credentials provided are incorrect ");
	}
	
	@Test
	public void TC_05_loginWithWrongPassword() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(email);
		loginPageObj.enterTextToEmailPasswordbox("111111");
		loginPageObj.clickToLoginButton();
		
		loginPageObj.checkLoginFail("Login was unsuccessful. Please correct the errors and try again. \n"
				+ "\n"
				+ "The credentials provided are incorrect ");
	}
	
	@Test
	public void TC_06_loginSuccess() {
		loginPageObj.refreshCurrentPage(driver);
		loginPageObj.enterTextToEmailTextbox(email);
		loginPageObj.enterTextToEmailPasswordbox(passWord);
		loginPageObj.clickToLoginButton();
	}

}
