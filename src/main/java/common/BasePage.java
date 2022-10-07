package common;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUI.MyAccountUI;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public void openUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	//Get Dynamic Locator
	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	//Get Dynamic Element
	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}
	
	public String getTextOfElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	//Get Dynamic Text Element
	public String getTextOfElement(WebDriver driver, String locator, String... params) {
		return getElement(driver, locator, params).getText();
	}
	
	public String getAttribute(WebDriver driver, String locator) {
		return getElement(driver, locator).getAttribute("value");
	}
	
	//Get dynamic Attributes
	public String getAttributes(WebDriver driver, String locator, String... params) {
		return getElement(driver, locator, params).getAttribute("value");
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...params) {
		getElement(driver, locator, params).click();
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(valueInput);
	}
	
	//Dynamic send keys
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput, String... params) {
		getElement(driver, locator, params).clear();
		getElement(driver, locator, params).sendKeys(valueInput);
	}
	
	public void sendEnterToElement(WebDriver driver, String locator) {
		getElement(driver, locator).sendKeys(Keys.ENTER);
	}
	
	//////////////////////////////////////////////////
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void selectByValue(WebDriver driver, String locator, String value) {
		waitForElementClickable(driver, locator);
		Select select = new Select(getElement(driver, locator));
		select.selectByValue(value);
	}
	
	public void selectByText(WebDriver driver, String locator, String text) {
		waitForElementClickable(driver, locator);
		Select select = new Select(getElement(driver, locator));
		select.selectByVisibleText(text);
	}
	
	public void clickCheckbox(WebDriver driver, String locator) {
		waitForElementClickable(driver, locator);
		WebElement checkBox = getElement(driver, locator);
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}
	
	public void unClickCheckbox(WebDriver driver, String locator) {
		waitForElementClickable(driver, locator);
		WebElement checkBox = getElement(driver, locator);
		if (checkBox.isSelected()) {
			checkBox.click();
		}
	}
	
	public boolean checkSelectValue(WebDriver driver, String locator ,String value) {
		waitForElementClickable(driver, locator);
		Select select = new Select(getElement(driver, locator));
		WebElement options = select.getFirstSelectedOption();
		String selected = options.getText();
		return selected.equals(value);
	}
	
	public boolean verifyCheckboxChecked(WebDriver driver, String locator) {
		boolean checked = true;
		WebElement checkedBox = getElement(driver, locator);
		if(!checkedBox.isSelected()) {
			return false;
		}
		return checked;
	}
	
	public boolean isTitleDisplayedOnPage(WebDriver driver, String locator, String value) {
        boolean result = true;
        List<WebElement> elementList = driver.findElements(By.xpath(locator));
        for(WebElement element:elementList) {
            String productTitle = element.getText();
            if(!StringUtils.containsIgnoreCase(productTitle, value)) {
                System.out.println("Break at Value = " + productTitle);
                result = false;
                break;
            }
        }
        return result;
    }
}
