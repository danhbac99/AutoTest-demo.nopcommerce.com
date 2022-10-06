package pageUI;

public class ShoppingCartPageUI {
	public static final String PAGE_TITLE = "//div[@class='page-title']";
	public static final String QUANTITY_INPUT = "//a[text()='%s']/following::td[@class='quantity']/input[@class='qty-input']";
	public static final String UPDATECART_BTN = "//button[@id='updatecart']";
	
	public static final String PRODUCT_NAME = "//a[@class='product-name']";
	public static final String REMOVEFROMCART_BTN = "//a[text()='%s']/following::td[@class='remove-from-cart']/button[@class='remove-btn']";
	public static final String EMPTY_CART = "//div[@class='no-data']";
	
}
