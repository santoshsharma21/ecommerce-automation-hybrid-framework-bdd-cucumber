/**
 * 
 */
package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Santosh Sharma
 *
 */
public class BasePage {

	private WebDriverWait wait;
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		this.driver = driver;
	}

	// useful methods

	// to click
	public void performClick(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
	}

	// to send value
	public void performSendKey(By locator, String key) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(key);
	}
	
	public void performSendKeyAndEnter(By locator, String key) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(key);
		element.sendKeys(Keys.ENTER);
	}

	// selct value from drop-down
	public void performSelectByVisibleText(By locator, String txt, boolean withSelectTag) {
		if (withSelectTag == true) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Select select = new Select(element);
			select.selectByVisibleText(txt);
		} else if (withSelectTag == false) {
			List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			for (WebElement element : elements) {
				if (element.getText().equals(txt)) {
					element.click();
					break;
				}
			}
		}
	}

	// checks page title
	public boolean checkPageTitle(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}

	// return text from element
	public String getString(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element.getText();
	}

	// to check element is displayed
	public boolean performIsdisplay(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.isDisplayed();
	}

	// return list of web-elements
	public List<WebElement> getListOfElements(By locator) {
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return elements;
	}

	// method select given value from the list
	public void performSelectByAttributeValue(By locator, String attribute, String key) {
		List<WebElement> elements = getListOfElements(locator);
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(key)) {
				element.click();
				break;
			}
		}
	}

	// return attribute value
	public String getAttributeValue(By locator, String attribute) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element.getAttribute(attribute);
	}
	
	// mouse hover click
	public void performMouseHoverClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
}
