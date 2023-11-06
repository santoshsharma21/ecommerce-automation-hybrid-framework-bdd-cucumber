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
public class CartPage extends BasePage {

	// initialize webdriver
	private WebDriver driver;

	// page objects
	private By quantityBox = By.xpath("//input[@title='Qty']");
	private By unitPrice = By.xpath("//td[@class='col price']//span[@class='cart-price']");
	private By subTotal = By.xpath("//td[@class='col subtotal']//span[@class='cart-price']");
	private By updateCartBtn = By.xpath("//span[normalize-space()='Update Shopping Cart']");
	private By removeItemBtn = By.xpath("//a[@class='action action-delete']");
	private By removeItemConfirmMsg = By.xpath("//p[normalize-space()='You have no items in your shopping cart.']");
	private By totalItemsIncart = By.xpath("//div[@class='cart table-wrapper']//table//tbody");
	private By proceedToCheckoutBtn = By.xpath("//button[@title='Proceed to Checkout']//span");

	// constructor
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// page action methods
	public boolean verifyItemQunatityInCart(String expectedQty) {
		boolean flag = false;
		if (getAttributeValue(quantityBox, "value").equals(expectedQty)) {
			flag = true;
		}
		return flag;
	}

	public boolean isCartDispalyItemPrice() {
		double price = Double.parseDouble(getString(unitPrice).split("\\$", 2)[1]);
		boolean flag = false;
		if (price > 0.0) {
			flag = true;
		}
		return flag;
	}

	public void clickUpdateCartBtn() {
		performClick(updateCartBtn);
	}

	public void clickRemoveItemBtn() {
		performClick(removeItemBtn);
	}

	public boolean isItemRemovedFromCart(String expectedMsg) {
		boolean flag = false;
		if (getString(removeItemConfirmMsg).contains(expectedMsg)) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isCartContainMultipleItem() {
		boolean flag = false;
		if(getListOfElements(totalItemsIncart).size() >= 2) {
			flag = true;
		}
		return flag;
	}
	
	public void changeItemQuantity(String qty) {
		performSendKey(quantityBox, qty);
		performClick(updateCartBtn);
	}
	
	public boolean verifyTotalPrice() throws InterruptedException {
		Thread.sleep(10000);
		double unitprice = Double.parseDouble(getString(unitPrice).split("\\$", 2)[1]);
		double subtotal = Double.parseDouble(getString(subTotal).split("\\$", 2)[1]);
		boolean flag = false;
		if((unitprice*2) == subtotal) {
			flag = true;
		}
		return flag;
	}
	
	public CheckoutPage clickCheckoutButton() throws InterruptedException {
		Thread.sleep(15000);
		performClick(proceedToCheckoutBtn);
		return new CheckoutPage(driver);
	}
}
