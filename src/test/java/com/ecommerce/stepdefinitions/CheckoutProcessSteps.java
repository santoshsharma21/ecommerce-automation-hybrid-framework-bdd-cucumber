/**
 * 
 */
package com.ecommerce.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.PaymentPage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.SearchResultPage;
import com.ecommerce.pages.SuccessPage;
import com.ecommerce.utilities.FakerUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Santosh Sharma
 *
 */
public class CheckoutProcessSteps {

	private WebDriver driver = DriverManager.getDriver();

	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private PaymentPage paymentPage;
	private SuccessPage successPage;


	@When("user seraches for {string} and click on the item from search results")
	public void user_seraches_for_and_click_on_the_item_from_search_results(String productName) {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem(productName);
		productDetailsPage = searchResultPage.clickOnItemSweatshirt();
	}

	@When("user selects size as {string} color as {string} and quantity as {int}")
	public void user_selects_size_as_color_as_and_quantity_as(String size, String color, Integer qty) {
		productDetailsPage.selectSweatshirtSizeColorQty(size, color, qty);
	}

	@When("user adds product to shopping cart")
	public void user_adds_product_to_shopping_cart() {
		productDetailsPage.clickOnAddTocart();
		cartPage = productDetailsPage.clickShoppingCart();
	}

	@When("user navigates to checkout page")
	public void user_navigates_to_checkout_page() throws InterruptedException {
		checkoutPage = cartPage.clickCheckoutButton();
	}

	@When("user enters shipping details")
	public void user_enters_shipping_details() throws InterruptedException {
		checkoutPage.addEmailId(FakerUtils.getFakeEmail());
		checkoutPage.addFirstAndLastName(FakerUtils.getFakeFirstName(), FakerUtils.getFakeLastName());
		checkoutPage.addShippingDetails(FakerUtils.getFakeAddress(), FakerUtils.getFakeCountryName(), FakerUtils.getFakeStateName(), FakerUtils.getFakeCityName(), FakerUtils.getFakeZipCode(), FakerUtils.getFakePhoneNum());
		paymentPage = checkoutPage.clickNextButton();
	}

	@When("user clicks on the place order button")
	public void user_clicks_on_the_place_order_button() throws InterruptedException {
		successPage = paymentPage.clickPlaceOrder();
	}

	@Then("system should display confirmation message {string}")
	public void system_should_display_confirmation_message(String expectedMsg) throws InterruptedException {
		boolean status = successPage.verifyPurchaseCheckout(expectedMsg);
		assertTrue(status);
	}
}
