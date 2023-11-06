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
public class HomePage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By signinLinkTxt = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
	private By createaccountLinkTxt = By
			.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");
	private By searchtxtBox = By.id("search");
	//private By searchBtn = By.xpath("//button[@title='Search']");
	//private By searchBtn = By.cssSelector("button[title='Search']");
	private By welcomeTxt = By
			.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, sony sharma!']");
	private By cartBtn = By.xpath("//a[@class='action showcart']");
	private By viewCartLinkTxt = By.xpath("//span[normalize-space()='View and Edit Cart']");

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// page action methods
	public CustomerLoginPage clickOnSignIn() {
		performClick(signinLinkTxt);
		return new CustomerLoginPage(driver);
	}

	public NewCustomerAccountPage clickOnCreateAccount() {
		performClick(createaccountLinkTxt);
		return new NewCustomerAccountPage(driver);
	}

	public SearchResultPage searchItem(String item) {
		performSendKeyAndEnter(searchtxtBox, item);
		//performClick(searchBtn);
		//performMouseHoverClick(searchBtn);
		return new SearchResultPage(driver);
	}

	public boolean validateLogin(String expectedTxt) {
		String actualTxt = getString(welcomeTxt);
		boolean flag = false;
		if (actualTxt.contains(expectedTxt)) {
			flag = true;
		}
		return flag;
	}
	
	public CartPage goToCartPage() {
		performClick(cartBtn);
		performClick(viewCartLinkTxt);
		return new CartPage(driver);
	}
}
