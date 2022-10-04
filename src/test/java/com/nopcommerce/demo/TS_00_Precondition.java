package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstant;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_00_Precondition extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPageObj;
	HomePageObject homePageObj;

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
	public void TC_00_CreateAccountForTesting() {
		registerPageObj.refreshCurrentPage(driver);
		registerPageObj.enterTextToTextbox("FirstName", "Bac");;
		registerPageObj.enterTextToTextbox("LastName", "Nguyen");
		registerPageObj.enterTextToTextbox("Email", GlobalConstant.username);
		registerPageObj.enterTextToTextbox("Password", GlobalConstant.password);
		registerPageObj.enterTextToTextbox("ConfirmPassword", GlobalConstant.password);
		registerPageObj.clickToRegisterButton();

		Assert.assertTrue(registerPageObj.checkRegisterSuccess("Your registration completed"));
		
		registerPageObj.clickToLogoutLink();
		homePageObj.clickToRegisterLink();
	}
}
