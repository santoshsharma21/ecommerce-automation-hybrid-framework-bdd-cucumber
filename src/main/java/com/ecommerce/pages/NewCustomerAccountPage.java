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
public class NewCustomerAccountPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By fnametxtBox = By.id("firstname");
	private By lnametxtBox = By.id("lastname");
	private By emailIdtxtBox = By.id("email_address");
	private By passwordtxtBox = By.id("password");
	private By passwordConfirmtxtBox = By.id("password-confirmation");
	private By createAccountBtn = By.xpath("//button[@title='Create an Account']");

	// constructor
	public NewCustomerAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// page action methods
	public void addUserPersonalDetails(String fname, String lname) {
		performSendKey(fnametxtBox, fname);
		performSendKey(lnametxtBox, lname);
	}

	public MyAccountPage addUserSigninDetails(String email, String password) {
		performSendKey(emailIdtxtBox, email);
		performSendKey(passwordtxtBox, password);
		performSendKey(passwordConfirmtxtBox, password);
		performClick(createAccountBtn);
		return new MyAccountPage(driver);
	}
}
