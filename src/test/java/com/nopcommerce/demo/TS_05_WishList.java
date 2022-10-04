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
import pageObjects.WishListPageObject;
import pageUI.WishListPageUI;

public class TS_05_WishList extends BaseTest {

	WebDriver driver;
	WishListPageObject wishListPageObj;
	LoginPageObject loginPageObj;
	HomePageObject homePageObj;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String pageUrl = "https://demo.nopcommerce.com";
		driver = getBrowserDriver(pageUrl, browserName);
		wishListPageObj = new WishListPageObject(driver);
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
	}
	
	@Test
	public void TC_01_AddProductToWishList() {
		homePageObj.clickToProduct("Computers");
		sleep(3);
		homePageObj.clickToComputerProduct("Desktops");
		sleep(3);
		wishListPageObj.clickToProduct("3");
		sleep(3);
		wishListPageObj.clickToAddWishListButton("3");
		sleep(3);
		Assert.assertTrue(wishListPageObj.checkAddWishListSuccesMsg("The product has been added to your wishlist"));
		System.out.println(wishListPageObj.getTextOfElement(driver, WishListPageUI.ADD_WISHLIST_SUCCESS_MSG));
		wishListPageObj.clickToCloseNotification();
		sleep(3);
		wishListPageObj.clickToWishListLink();
		sleep(3);
		Assert.assertTrue(wishListPageObj.checkProductAdded(wishListPageObj.getProductName()));
		System.out.println(wishListPageObj.getProductName());
	}
	
	@Test
	public void TC_02_AddProductToCart() {
		wishListPageObj.clickToWishListLink();
		sleep(3);
		wishListPageObj.clickToAddCartCheckbox();
		sleep(3);
		wishListPageObj.clickToAddCartButton();
		sleep(3);
		wishListPageObj.clickToShoppingCartLink();
		sleep(3);
		
		Assert.assertTrue(wishListPageObj.checkProductInShoppingCart(wishListPageObj.getProductName()));
		Assert.assertTrue(wishListPageObj.checkProductRemovedWishList());
		
	}
}
