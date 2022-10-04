package pageUI;

public class HomePageUI {
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String SEARCH_LINK = "//a[text()='Search']";
	
	//Dynamic Products Menu List
	// Computers, Electronics, Apparel, Digital downloads, Books, Jewelry, Gift Cards
	public static final String PRODUCT_NAME = "//ul[@class='top-menu notmobile']/li/a[text()='%s ']";
	
	//Computer List
	// Desktops, Notebooks, SoftWare
	public static final String COMPUTER_PRODUCT = "//div[@class='sub-category-item']/h2[@class='title']/a[text()=' %s ']";
	
	//Electronics List
	// Camera & photo, Cell phones, Others 
	public static final String ELECTRONICS_PRODUCT = "//div[@class='sub-category-item']/h2[@class='title']/a[text()=' %s ']";
	
	//Apparel List
	// Shoes, Clothing, Accessories
	public static final String APPAREL_PRODUCT = "//div[@class='sub-category-item']/h2[@class='title']/a[text()=' %s ']";
}
