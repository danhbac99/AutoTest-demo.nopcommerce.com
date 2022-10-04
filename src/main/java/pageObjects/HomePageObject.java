package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	
	public void clickToLoginLink() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
		clickToElement(driver, LoginPageUI.LOGIN_LINK);
	}
	
	public void clickToSearchLink() {
		waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
		clickToElement(driver, HomePageUI.SEARCH_LINK);
	}
	
	public void clickToProduct(String product) {
		waitForElementClickable(driver, HomePageUI.PRODUCT_NAME, product);
		clickToElement(driver, HomePageUI.PRODUCT_NAME, product);
	}
	
	public void clickToComputerProduct(String computer) {
		waitForElementClickable(driver, HomePageUI.COMPUTER_PRODUCT, computer);
		clickToElement(driver, HomePageUI.COMPUTER_PRODUCT, computer);
	}
	
	public void clickToElectronicsProduct(String electronics) {
		waitForElementClickable(driver, HomePageUI.ELECTRONICS_PRODUCT, electronics);
		clickToElement(driver, HomePageUI.ELECTRONICS_PRODUCT, electronics);
	}
	
	public void clickToApparelProduct(String apparel) {
		waitForElementClickable(driver, HomePageUI.APPAREL_PRODUCT, apparel);
		clickToElement(driver, HomePageUI.APPAREL_PRODUCT, apparel);
	}

}
