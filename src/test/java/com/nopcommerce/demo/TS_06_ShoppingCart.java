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
import pageObjects.LoginPageObject;
import pageObjects.ShoppingCartPageObject;

public class TS_06_ShoppingCart extends BaseTest {
	WebDriver driver;
	ShoppingCartPageObject shoppingCartObj;
	LoginPageObject loginPageObj;
	HomePageObject homePageObj;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String pageUrl = "https://demo.nopcommerce.com";
		driver = getBrowserDriver(pageUrl, browserName);
		shoppingCartObj = new ShoppingCartPageObject(driver);
		loginPageObj = new LoginPageObject(driver);
		homePageObj = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_00_Precondition() {
		homePageObj.clickToLoginLink();

		loginPageObj.enterTextToEmailTextbox(GlobalConstant.username);
		loginPageObj.enterTextToEmailPasswordbox(GlobalConstant.password);
		loginPageObj.clickToLoginButton();
		shoppingCartObj.clickToShoppingCartLink();
	}
	
	@Test
	public void TC_01_UpdateShoppingCart() {
		shoppingCartObj.changeQuantity("5");
		sleep(3);
		shoppingCartObj.clickToUpdateCartButton();
		sleep(3);
		Assert.assertTrue(shoppingCartObj.checkPageTitle("Shopping cart"));
		Assert.assertTrue(shoppingCartObj.checkValueQuantity("5"));
	}
	
	@Test
	public void TC_02_RemoveFromCart() {
		shoppingCartObj.clickToRemoveProduct();
		sleep(3);
		
		Assert.assertTrue(shoppingCartObj.checkCartEmpty("Your Shopping Cart is empty!"));
	}
}
