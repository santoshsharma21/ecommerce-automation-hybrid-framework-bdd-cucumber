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
public class CustomerLoginPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;
	
	// page objects
	private By emailtxtBox = By.id("email");
	private By passwordtxtbox = By.id("pass");
	private By signinBtn = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
	private By errorMsg = By.xpath("//div[@class='message-error error message']");

	// constructor
	public CustomerLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// page action methods
	public HomePage userLoginWithValidCredentials(String email, String password) {
		performSendKey(emailtxtBox, email);
		performSendKey(passwordtxtbox, password);
		performClick(signinBtn);
		return new HomePage(driver);
	}
	
	public void userLoginWithInvalidCredentials(String email, String password) {
		performSendKey(emailtxtBox, email);
		performSendKey(passwordtxtbox, password);
		performClick(signinBtn);
	}
	
	public boolean validateLogin(String expectedTxt) {
		String actualTxt = getString(errorMsg);
		boolean flag = false;
		if (actualTxt.contains(expectedTxt)) {
			flag = true;
		}
		return flag;
	}
}
