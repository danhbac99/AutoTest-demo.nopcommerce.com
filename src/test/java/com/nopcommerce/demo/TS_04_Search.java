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
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	SearchPageObject searchPageObj;
	LoginPageObject loginPageObj;
	HomePageObject homePageObj;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String pageUrl = "https://demo.nopcommerce.com";
		driver = getBrowserDriver(pageUrl, browserName);
		searchPageObj = new SearchPageObject(driver);
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
		
		homePageObj.clickToSearchLink();
	}
	
	@Test
	public void TC_01_SearchWithEmptyData() {
		searchPageObj.enterTextToSearchTextbox("");
		searchPageObj.clickToSearchButton();
		sleep(3);
		
		Assert.assertTrue(searchPageObj.checkSearchError("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_SearchWithInvalidData() {
		searchPageObj.enterTextToSearchTextbox("Macbook Pro 2040");
		searchPageObj.clickToSearchButton();
		sleep(3);
		
		Assert.assertTrue(searchPageObj.checkSearchNoResult("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_SearchWithValidData() {
		searchPageObj.enterTextToSearchTextbox("Lenovo");
		searchPageObj.clickToSearchButton();
		sleep(3);
		
		Assert.assertTrue(searchPageObj.checkResults("Lenovo"));
	}
	
	@Test
	public void TC_04_SearchWithAdvance() {
		searchPageObj.enterTextToSearchTextbox("Apple Macbook Pro");
		searchPageObj.clickToAdvanceSearch();
		searchPageObj.selectCategory("Computers");
		searchPageObj.clickToSearchButton();
		sleep(3);
		
		Assert.assertTrue(searchPageObj.checkSearchNoResult("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_05_SearchWithCategory() {
		searchPageObj.enterTextToSearchTextbox("Apple Macbook Pro");
		searchPageObj.clickToAdvanceSearch();
		searchPageObj.selectCategory("Computers");
		searchPageObj.clickToAutoSearch();
		searchPageObj.clickToSearchInDesc();
		searchPageObj.clickToSearchButton();
		sleep(3);
		
		Assert.assertTrue(searchPageObj.checkResult("Apple MacBook Pro 13-inch"));
	}
}
