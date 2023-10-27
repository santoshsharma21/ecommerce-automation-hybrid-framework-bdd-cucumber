/**
 * 
 */
package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Santosh Sharma
 *
 */
public class BasePage {

	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// useful methods

	// to click
	public void performClick(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	// to send value
	public void performSendKey(By locator, String key) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(key);
	}

	// selct value from drop-down
	public void performSelectByVisibleText(By locator, String txt, boolean withSelectTag) {
		if (withSelectTag == true) {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Select select = new Select(element);
			select.deselectByVisibleText(txt);
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
}
