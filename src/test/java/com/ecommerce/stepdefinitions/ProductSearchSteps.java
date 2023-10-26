/**
 * 
 */
package com.ecommerce.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.SearchResultPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Santosh Sharma
 *
 */
public class ProductSearchSteps {
	
	private WebDriver driver = DriverManager.getDriver();
	private HomePage homePage;
	private SearchResultPage searchResultPage;

	@When("user enters keyword {string} in the search bar and submits the search")
	public void user_enters_keyword_in_the_search_bar_and_submits_the_search(String keyword) {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem(keyword);
	}

	@Then("the search result page should display product")
	public void the_search_result_page_should_display_product() {
		boolean status = searchResultPage.isProductDisplayed();
		assertTrue(status);
	}

	@Then("the displayed product should have entered keyword {string} in the name")
	public void the_displayed_product_should_have_entered_keyword_in_the_name(String expectedKeyword) {
		boolean status = searchResultPage.isSearchResultContainKeyword(expectedKeyword);
		assertTrue(status);
	}

	@When("user enters partial keyword {string} in the search bar and submits the search")
	public void user_enters_partial_keyword_in_the_search_bar_and_submits_the_search(String partialKeyword) {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem(partialKeyword);
	}

	@Then("the search result page should display the products with keyword {string} in the name")
	public void the_search_result_page_should_display_the_products_with_keyword_in_the_name(String partialKeyword) {
		boolean status = searchResultPage.isSearchResultContainKeyword(partialKeyword);
		assertTrue(status);
	}

	@Then("search result page should not contain products that do not have partial keyword {string} in the name")
	public void search_result_page_should_not_contain_products_that_do_not_have_partial_keyword_in_the_name(
			String partialKeyword) {
		boolean status = searchResultPage.isSearchResultsNotContainKeyword(partialKeyword);
		assertTrue(status);
	}

	@When("user enters keyword with mixed case {string} in the search bar and submits the search")
	public void user_enters_keyword_with_mixed_case_in_the_search_bar_and_submits_the_search(String mixedCaseKeyword) {
		homePage = new HomePage(driver);
		searchResultPage = homePage.searchItem(mixedCaseKeyword);
	}

	@Then("the search result page should display the products regardless of keyword case")
	public void the_search_result_page_should_display_the_products_regardless_of_keyword_case() {
		boolean status = searchResultPage.isProductDisplayed();
		assertTrue(status);
	}
}