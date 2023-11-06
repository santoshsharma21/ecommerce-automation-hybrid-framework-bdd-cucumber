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
public class CheckoutPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By emailIdTxtBox = By.xpath("//input[contains(@data-bind,'textInput: email,')]");
	private By fnameTxtBox = By.xpath("//input[contains(@name,'firstname')]");
	private By lnameTxtBox = By.xpath("//input[@name='lastname']");
	private By addressTxtBox = By.xpath("//input[@name='street[0]']");
	private By cityTxtBox = By.xpath("//input[@name='city']");
	private By stateDrpDwn = By.xpath("//select[@name='region_id']");
	private By zipCodeTxtBox = By.xpath("//input[@name='postcode']");
	private By countryDrpDwn = By.xpath("//select[@name='country_id']");
	private By phoneNumTxtBox = By.xpath("//input[@name='telephone']");
	private By nextBtn = By.xpath("//span[contains(text(),'Next')]");

	// constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// action methods
	public void addEmailId(String email) {
		performSendKey(emailIdTxtBox, email);
	}

	public void addFirstAndLastName(String firstName, String lastName) {
		performSendKey(fnameTxtBox, firstName);
		performSendKey(lnameTxtBox, lastName);
	}

	public void addShippingDetails(String address, String country, String state, String city, String zipCode,
			String phoneNo) {
		performSendKey(addressTxtBox, address);
		performSelectByVisibleText(countryDrpDwn, country, true);
		performSelectByVisibleText(stateDrpDwn, state, true);
		performSendKey(cityTxtBox, city);
		performSendKey(zipCodeTxtBox, zipCode);
		performSendKey(phoneNumTxtBox, phoneNo);
	}

	public PaymentPage clickNextButton() throws InterruptedException {
		Thread.sleep(15000);
		performClick(nextBtn);
		return new PaymentPage(driver);
	}
}
