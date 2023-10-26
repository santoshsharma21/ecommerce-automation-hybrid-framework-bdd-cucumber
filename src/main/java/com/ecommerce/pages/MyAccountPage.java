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
public class MyAccountPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By accountRegisterStatus = By.xpath("//div[@class='message-success success message']");
	
	
	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// page action methods
	public boolean validatePageTitle(String expectedTitle) {
		return checkPageTitle(expectedTitle);
	}
	
	public boolean isUserAccountCreated(String expectedMsg) {
		boolean flag = false;
		if(getString(accountRegisterStatus).contains(expectedMsg)) {
			flag = true;
		}
		return flag;
	}
}
