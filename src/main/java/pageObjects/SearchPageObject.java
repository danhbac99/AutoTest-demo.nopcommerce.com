package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUI.SearchUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTextToSearchTextbox(String value) {
		waitForElementVisible(driver, SearchUI.SEARCH_TEXTBOX);
		sendKeysToElement(driver, SearchUI.SEARCH_TEXTBOX, value);
	}
	
	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchUI.SEARCH_BUTTON);
		clickToElement(driver, SearchUI.SEARCH_BUTTON);
	}
	
	public boolean checkSearchError(String value) {
		String errorMessage = getTextOfElement(driver, SearchUI.SEARCH_ERROR_MSG);
		return errorMessage.equals(value);
	}
	
	public boolean checkSearchNoResult(String value) {
		String errorMessage = getTextOfElement(driver, SearchUI.NO_RESULT_MSG);
		return errorMessage.equals(value);
	}
	
	public boolean checkResult(String value) {
		String result = getTextOfElement(driver, SearchUI.PRODUCTS_NAME);
		return result.contains(value);
	}
	
	public boolean checkResults(String value) {
		List<WebElement> products = getElements(driver, SearchUI.PRODUCTS_NAME);
		for(WebElement product: products) {
			if(product.getText().contains(value)) {
				return true;
			}
		}
		return false;
	}
	
	public void clickToAdvanceSearch() {
		waitForElementClickable(driver, SearchUI.ADVANCE_SEARCH_CHECKBOX);
		WebElement advanceCheckBox = getElement(driver, SearchUI.ADVANCE_SEARCH_CHECKBOX);
		if(!advanceCheckBox.isSelected()) {
			advanceCheckBox.click();
		}
	}
	
	public void unclickToAdvanceSearch() {
		waitForElementClickable(driver, SearchUI.ADVANCE_SEARCH_CHECKBOX);
		WebElement advanceCheckBox = getElement(driver, SearchUI.ADVANCE_SEARCH_CHECKBOX);
		if(advanceCheckBox.isSelected()) {
			advanceCheckBox.click();
		}
	}
	
	public void clickToAutoSearch() {
		waitForElementClickable(driver, SearchUI.AUTO_SEARCH_CHECKBOX);
		WebElement autoCheckBox = getElement(driver, SearchUI.AUTO_SEARCH_CHECKBOX);
		if(!autoCheckBox.isSelected()) {
			autoCheckBox.click();
		}
	}
	
	public void unclickToAutoSearch() {
		waitForElementClickable(driver, SearchUI.AUTO_SEARCH_CHECKBOX);
		WebElement autoCheckBox = getElement(driver, SearchUI.AUTO_SEARCH_CHECKBOX);
		if(autoCheckBox.isSelected()) {
			autoCheckBox.click();
		}
	}
	
	public void clickToSearchInDesc() {
		waitForElementClickable(driver, SearchUI.SEARCH_IN_DESC_CHECKBOX);
		WebElement searchDescCheckBox = getElement(driver, SearchUI.SEARCH_IN_DESC_CHECKBOX);
		if(!searchDescCheckBox.isSelected()) {
			searchDescCheckBox.click();
		}
	}
	
	public void unclickToSearchInDesc() {
		waitForElementClickable(driver, SearchUI.SEARCH_IN_DESC_CHECKBOX);
		WebElement searchDescCheckBox = getElement(driver, SearchUI.SEARCH_IN_DESC_CHECKBOX);
		if(searchDescCheckBox.isSelected()) {
			searchDescCheckBox.click();
		}
	}
	
	public void selectCategory(String value) {
		waitForElementClickable(driver, SearchUI.SELECT_CATEGORY);
		Select selectCategory = new Select(getElement(driver, SearchUI.SELECT_CATEGORY));
		selectCategory.selectByVisibleText(value);
	}
}
