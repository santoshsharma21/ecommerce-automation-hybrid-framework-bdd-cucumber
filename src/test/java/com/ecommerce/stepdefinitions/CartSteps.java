/**
 * 
 */
package com.ecommerce.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.SearchResultPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Santosh Sharma
 *
 */
public class CartSteps {

	private WebDriver driver = DriverManager.getDriver();

	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private CartPage cartPage;

	@When("user enters item in search bar and submits")
	public void user_enters_item_in_search_bar_and_submits() {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem("sweatshirt");
	}

	@When("user clicks the item")
	public void user_clicks_the_item() {
		productDetailsPage = searchResultPage.clickOnItemSweatshirt();
	}

	@When("user is on the product details page and select color, size for item")
	public void user_is_on_the_product_details_page_and_select_color_size_for_item() {
		productDetailsPage.selectSweatshirtSizeColorQty("M", "Orange", 1);
	}

	@When("user clicks the add to cart button")
	public void user_clicks_the_add_to_cart_button() {
		productDetailsPage.clickOnAddTocart();
	}

	@Then("the product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		boolean status = productDetailsPage
				.isItemAddedToCart("You added Grayson Crewneck Sweatshirt to your shopping cart.");
		assertTrue(status);
	}

	@Then("the cart should display correct quantity of the added product as {string}")
	public void the_cart_should_display_correct_quantity_of_the_added_product_as(String expectedQty) {
		cartPage = productDetailsPage.clickShoppingCart();
		boolean status = cartPage.verifyItemQunatityInCart(expectedQty);
		assertTrue(status);
	}

	@Then("the cart should show the price of the product")
	public void the_cart_should_show_the_price_of_the_product() {
		boolean status = cartPage.isCartDispalyItemPrice();
		assertTrue(status);
	}

	@When("user add product to the cart and navigates to the cart page")
	public void user_add_product_to_the_cart_and_navigates_to_the_cart_page() {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem("sweatshirt");
		productDetailsPage = searchResultPage.clickOnItemSweatshirt();
		productDetailsPage.selectSweatshirtSizeColorQty("M", "Orange", 1);
		productDetailsPage.clickOnAddTocart();
		cartPage = productDetailsPage.clickShoppingCart();
	}

	@When("user clicks the item remove button")
	public void user_clicks_the_item_remove_button() {
		cartPage.clickRemoveItemBtn();
	}

	@Then("the cart page should display message {string}")
	public void the_cart_page_should_display_message(String expectedMsg) {
		boolean status = cartPage.isItemRemovedFromCart(expectedMsg);
		assertTrue(status);
	}

	@When("user add first product sweatshirt to the cart")
	public void user_add_first_product_sweatshirt_to_the_cart() {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem("sweatshirt");
		productDetailsPage = searchResultPage.clickOnItemSweatshirt();
		productDetailsPage.selectSweatshirtSizeColorQty("M", "Orange", 1);
		productDetailsPage.clickOnAddTocart();
	}

	@When("user adds second product backpack to the cart")
	public void user_adds_second_product_backpack_to_the_cart() {
		searchResultPage = productDetailsPage.searchItem("backpack");
		productDetailsPage = searchResultPage.clickOnItemBackpack();
		productDetailsPage.enterQtyOfBackpack(1);
		productDetailsPage.clickOnAddTocart();
		cartPage = productDetailsPage.clickShoppingCart();
	}

	@Then("cart should have multiple product")
	public void cart_should_have_multiple_product() {
		boolean status = cartPage.isCartContainMultipleItem();
		assertTrue(status);
	}

	@When("user is on the cart page")
	public void user_is_on_the_cart_page() {
		productDetailsPage.selectSweatshirtSizeColorQty("M", "Orange", 1);
		productDetailsPage.clickOnAddTocart();
		cartPage = productDetailsPage.clickShoppingCart();
	}

	@When("user changes the quantity to {string} of the product in the cart")
	public void user_changes_the_quantity_to_of_the_product_in_the_cart(String qty) {
		cartPage.changeItemQuantity(qty);
	}

	@Then("the cart should display the correct quantity of the updated product")
	public void the_cart_should_display_the_correct_quantity_of_the_updated_product() {
		boolean status = cartPage.verifyItemQunatityInCart("2");
		assertTrue(status);
	}

	@Then("the cart should update the total price based on the new quantity")
	public void the_cart_should_update_the_total_price_based_on_the_new_quantity() throws InterruptedException {
		boolean status = cartPage.verifyTotalPrice();
		assertTrue(status);
	}
}
