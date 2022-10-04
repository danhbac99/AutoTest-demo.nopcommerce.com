package com.nopcommerce.demo.excel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import util.ExcelUtil;

public class TS_01_LoginWithDataExcel extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		String urlPage = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(urlPage, browserName);
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC00() throws IOException {
		// Không chạy vòng lặp, chỉ duyệt record đầu tiên trong Sheet
		ExcelUtil.setExcelFile("Sheet1");
		for (int i = 1; i <= ExcelUtil.getRowCountInSheet(); i++) {
				String excelUserName = ExcelUtil.getCellData(i, 1);
				String excelPassword = ExcelUtil.getCellData(i, 2);
				System.out.println("Account using: " + excelUserName + "," + excelPassword);
				loginPage.refreshCurrentPage(driver);
				loginPage.enterTextToEmailTextbox(excelUserName);
				loginPage.enterTextToEmailPasswordbox(excelPassword);
				loginPage.clickToLoginButton();
				
				String homePageUrl = homePage.getPageUrl(driver);
				if (homePageUrl.equals("https://demo.nopcommerce.com/")) {
					ExcelUtil.setCellData("Pass", i, 3);
				} else {
					ExcelUtil.setCellData("Fail", i, 3);
				}
			}
		}

//	    Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");

		
	}


