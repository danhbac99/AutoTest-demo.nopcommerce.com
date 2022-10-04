package pageUI;

public class MyAccountUI {
	public static final String MALE_RADIO = "//input[@id='gender-male']";
	public static final String FEMALE_RADIO = "//input[@id='gender-female']";

	//Dynamic Textbox Input
	public static final String TEXTBOX_INPUT = "//input[@id='%s']";
	
	//
	public static final String FIRST_NAME = "//input[@id='FirstName']";
	public static final String LAST_NAME = "//input[@id='LastName']";
	public static final String EMAIL = "//input[@id='Email']";
	public static final String COMPANY = "//input[@id='Company']";
	
	//Dynamic Select 
	public static final String SELECT = "//select[@name='DateOfBirth%s']";
	//
	public static final String SELECT_DATE = "//select[@name='DateOfBirthDay']";
	public static final String SELECT_MONTH = "//select[@name='DateOfBirthMonth']";
	public static final String SELECT_YEAR = "//select[@name='DateOfBirthYear']";
	
	public static final String OPTION_CHECKBOX = "//input[@type='checkbox']";
	public static final String SAVE_BTN = "//button[@id='save-info-button']";
	
	//Address Link
	public static final String ADDRESS_LINK = "//li[@class='customer-addresses inactive']/a";
	//Add new Address Button
	public static final String NEWADDRESS_BUTTON = "//button[@class='button-1 add-address-button']";
	
	//Dynamic Input Textbox Address
	//FirstName, LastName, Email, Company, City, Address1, Address2, ZipPostalCode, PhoneNumber, FaxNumber
	public static final String TEXTBOX_ADDRESS = "//input[@id='Address_%s']";
	//Select Address
	public static final String COUNTRY_ADDRESS = "//select[@id='Address_CountryId']";
	public static final String PROVIDE_ADDRESS = "//select[@id='Address_StateProvinceId']";
	
	//Save Address BTN
	public static final String SAVEADDRESS_BUTTON = "//button[@class='button-1 save-address-button']";
	
	//Verify Element Address
	public static final String ADDRESS_TITLE = "//div[@class='section address-item']/div[@class='title']/strong";
	//Dynamic Address Infor
	public static final String ADDRESS_INFO = "//li[@class='%s']";
	//Change Password
	public static final String CHANGEPASSWORDD_LINK = "//li[@class='change-password inactive']/a";
	public static final String OLD_PASSWORD = "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD = "//input[@id='NewPassword']";
	public static final String CONFIRMNEW_PASSWORD = "//input[@id='ConfirmNewPassword']";
	public static final String CHANGEPASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";
	
	//Close Notification Change Password
	public static final String CLOSE_NOTIF_BUTTON = "//span[@class='close']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";
	public static final String LOGIN_BUTTON = "//a[@class='ico-login']";
	
}
