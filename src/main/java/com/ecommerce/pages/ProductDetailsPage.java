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
public class ProductDetailsPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By searchtxtBox = By.id("search");
	private By searchBtn = By.xpath("//button[@title='Search']");
	private By sizes = By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']/div");
	private By colors = By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']/div");
	private By itemQunatity = By.id("qty");
	private By addToCartBtn = By.xpath("//span[normalize-space()='Add to Cart']");
	private By addCartConfirmation = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	private By shoppingCart = By.xpath("//a[normalize-space()='shopping cart']");
	

	// constructor
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// page action methods
	public void selectSweatshirtSizeColorQty(String size, String color, int quantity) {
		performSelectByAttributeValue(sizes, "aria-label", size);
		performSelectByAttributeValue(colors, "aria-label", color);
		performSendKey(itemQunatity, Integer.toString(quantity));
	}
	
	public void enterQtyOfBackpack(int quantity) {
		performSendKey(itemQunatity, Integer.toString(quantity));
	}

	public void clickOnAddTocart() {
		performClick(addToCartBtn);
	}

	public CartPage clickShoppingCart() {
		performClick(shoppingCart);
		return new CartPage(driver);
	}

	public boolean isItemAddedToCart(String expectedCartConfirmation) {
		boolean flag = false;
		if (getString(addCartConfirmation).contains(expectedCartConfirmation)) {
			flag = true;
		}
		return flag;
	}
	
	public SearchResultPage searchItem(String item) {
		performSendKey(searchtxtBox, item);
		performClick(searchBtn);
		return new SearchResultPage(driver);
	}

}
