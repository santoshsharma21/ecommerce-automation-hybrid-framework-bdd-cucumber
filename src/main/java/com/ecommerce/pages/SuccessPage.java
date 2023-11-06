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
public class SuccessPage extends BasePage {

	// page objects
	private By checkoutsuccessMsg = By.xpath("//span[@class='base']");

	// constructor
	public SuccessPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyPurchaseCheckout(String expectedMsg) throws InterruptedException {
		Thread.sleep(10000);
		boolean flag = false;
		if (getString(checkoutsuccessMsg).contains(expectedMsg)) {
			flag = true;
		}
		return flag;
	}
}
