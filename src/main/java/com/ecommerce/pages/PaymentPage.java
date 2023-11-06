/**
 * 
 */
package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class PaymentPage extends BasePage {

	// webdriver
	private WebDriver driver;

	// page objects
	private By placeOrderBtn = By.xpath("//span[contains(text(),'Place Order')]");

	// constructor
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// action methods
	public SuccessPage clickPlaceOrder() throws InterruptedException {
		Thread.sleep(10000);
		performClick(placeOrderBtn);
		return new SuccessPage(driver);
	}
}
