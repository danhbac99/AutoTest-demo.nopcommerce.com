package pageUI;

public class WishListPageUI {

	//Product ID
	public static final String PRODUCT_ID = "//div[@class='item-box']/div[@data-productid='%s']";
	public static final String WISHLIST_BTN = "//button[@id='add-to-wishlist-button-%s']";
	
	public static final String ADD_WISHLIST_SUCCESS_MSG = "//p[@class='content']";
	public static final String CLOSE_WISHLIST_MSG_BTN = "//span[@class='close']";
	public static final String WISHLIST_LINK = "//a[@class='ico-wishlist']";
	public static final String PRODUCT_NAME = "//a[@class='product-name']";
	
	public static final String ADDTOCART_CHECKBOX = "//a[text()='%s']/preceding::td[@class='add-to-cart']//input";
	public static final String ADDTOCART_BTN = "//button[@name='addtocartbutton']";
	public static final String SHOPPINGCART_LINK = "//a[@class='ico-cart']";
}
