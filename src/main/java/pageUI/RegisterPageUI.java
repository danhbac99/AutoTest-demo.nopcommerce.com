package pageUI;

public class RegisterPageUI {
	//Register button
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	
	//Logout button
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	
	//Error msg
//	public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
//	public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
//	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
//	public static final String PASS_ERROR_MESSAGE = "//span[@id='Password-error']";
//	public static final String CONFIRM_PASS_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	
	public static final String ERROR_MSG = "//span[@id='%s-error']";
	
	//Input button
//	public static final String FIRSTNAME_INPUT = "//input[@id='FirstName']";
//	public static final String LASTNAME_INPUT = "//input[@id='LastName']";
//	public static final String EMAIL_INPUT = "//input[@id='Email']";
//	public static final String PASS_INPUT = "//input[@id='Password']";
//	public static final String CONFIRM_PASS_INPUT = "//input[@id='ConfirmPassword']";
	
	public static final String TEXTBOX_INPUT = "//input[@id='%s']";
	
	//Success msg
	public static final String REGISTER_SUCCESS_MSG = "//div[@class='result']";
	
	//Exists email
	public static final String EMAIL_EXISTS_MSG = "//div[@class='message-error validation-summary-errors']";
	
}
