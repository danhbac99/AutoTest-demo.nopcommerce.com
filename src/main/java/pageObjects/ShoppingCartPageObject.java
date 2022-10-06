package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.ShoppingCartPageUI;
import pageUI.WishListPageUI;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToShoppingCartLink() {
		waitForElementClickable(driver, WishListPageUI.SHOPPINGCART_LINK);
		clickToElement(driver, WishListPageUI.SHOPPINGCART_LINK);
	}
	
	public boolean checkPageTitle(String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.PAGE_TITLE);
		String title = getTextOfElement(driver, ShoppingCartPageUI.PAGE_TITLE);
		return title.equals(value);
	}
	
	public String getProductName() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME);
		String productName = getTextOfElement(driver, ShoppingCartPageUI.PRODUCT_NAME);
		return productName;
	}
	
	public void changeQuantity(String quantity) {
		String productName = getProductName();
		waitForElementClickable(driver, ShoppingCartPageUI.QUANTITY_INPUT, productName);
		clickToElement(driver, ShoppingCartPageUI.QUANTITY_INPUT, productName);
		sendKeysToElement(driver, ShoppingCartPageUI.QUANTITY_INPUT, quantity, productName);
	}
	
	public boolean checkValueQuantity(String value) {
		String productName = getProductName();
		waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_INPUT, productName);
		String quantityValue = getAttributes(driver, ShoppingCartPageUI.QUANTITY_INPUT, productName);
		return quantityValue.contains(value);
	}
	
	public void clickToUpdateCartButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.UPDATECART_BTN);
		clickToElement(driver, ShoppingCartPageUI.UPDATECART_BTN);
	}
	
	public void clickToRemoveProduct() {
		String productName = getProductName();
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVEFROMCART_BTN, productName);
		clickToElement(driver, ShoppingCartPageUI.REMOVEFROMCART_BTN, productName);
	}
	
	public boolean checkCartEmpty(String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.EMPTY_CART);
		String emptyCartMsg = getTextOfElement(driver, ShoppingCartPageUI.EMPTY_CART);
		return emptyCartMsg.contains(value);
	}
}
