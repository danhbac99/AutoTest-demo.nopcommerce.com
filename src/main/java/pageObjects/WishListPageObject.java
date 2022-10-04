package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.WishListPageUI;

public class WishListPageObject extends BasePage {
	WebDriver driver;

	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToProduct(String id) {
		waitForElementClickable(driver, WishListPageUI.PRODUCT_ID, id);
		clickToElement(driver, WishListPageUI.PRODUCT_ID, id);
	}
	
	public void clickToAddWishListButton(String id) {
		waitForElementClickable(driver, WishListPageUI.WISHLIST_BTN, id);
		clickToElement(driver, WishListPageUI.WISHLIST_BTN, id);
	}
	
	public void clickToCloseNotification() {
		waitForElementClickable(driver, WishListPageUI.CLOSE_WISHLIST_MSG_BTN);
		clickToElement(driver, WishListPageUI.CLOSE_WISHLIST_MSG_BTN);
	}
	
	public boolean checkAddWishListSuccesMsg(String value) {
		waitForElementVisible(driver, WishListPageUI.ADD_WISHLIST_SUCCESS_MSG);
		String successMessage = getTextOfElement(driver, WishListPageUI.ADD_WISHLIST_SUCCESS_MSG);
		return successMessage.contains(value);
	}
	
	public void clickToWishListLink() {
		waitForElementClickable(driver, WishListPageUI.WISHLIST_LINK);
		clickToElement(driver, WishListPageUI.WISHLIST_LINK);
	}
	
	public String getProductName() {
		waitForElementVisible(driver, WishListPageUI.PRODUCT_NAME);
		String productName = getTextOfElement(driver, WishListPageUI.PRODUCT_NAME);
		return productName;
	}
	
	public boolean checkProductAdded(String value) {
		waitForElementVisible(driver, WishListPageUI.PRODUCT_NAME);
		String successMessage = getTextOfElement(driver, WishListPageUI.PRODUCT_NAME);
		
		return successMessage.equals(value);
		
	}
	
	public void clickToAddCartCheckbox() {
		String productName = getProductName();
		waitForElementClickable(driver, WishListPageUI.ADDTOCART_CHECKBOX, productName);
		clickToElement(driver, WishListPageUI.ADDTOCART_CHECKBOX, productName);
	}
	
	public void clickToAddCartButton() {
		waitForElementClickable(driver, WishListPageUI.ADDTOCART_BTN);
		clickToElement(driver, WishListPageUI.ADDTOCART_BTN);
	}
	
	public void clickToShoppingCartLink() {
		waitForElementClickable(driver, WishListPageUI.SHOPPINGCART_LINK);
		clickToElement(driver, WishListPageUI.SHOPPINGCART_LINK);
	}
	
	public boolean checkProductInShoppingCart(String value) {
		waitForElementVisible(driver, WishListPageUI.PRODUCT_NAME);
		String successMessage = getTextOfElement(driver, WishListPageUI.PRODUCT_NAME);
		
		return successMessage.equals(value);
	}
	
	public boolean checkProductRemovedWishList() {
		String removed = getTextOfElement(driver, WishListPageUI.PRODUCT_NAME);
		String productName = getProductName();
		if (removed != productName) {
			return true;
		}
		return false;
	}
}
