/**
 * 
 */
package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Santosh Sharma
 *
 */
public class SearchResultPage extends BasePage {
	
	// initialize webdriver
	private WebDriver driver;
	
	// page objects
	private By itemSweatshirt = By.xpath("//img[@alt='Grayson Crewneck Sweatshirt ']");
	private By searchedProductName = By.xpath("//a[normalize-space()='Grayson Crewneck Sweatshirt']");
	private By allProducts = By.xpath("//div[@class='products wrapper grid products-grid']//ol//li//div//strong//a");
	private By notFoundMsg = By.xpath("//div[contains(text(),'Your search returned no results.')]");
	private By colorDesc = By.xpath("//div[@class='products wrapper grid products-grid']//li[1]//div[contains(@class,'swatch-option color')]");
	private By itemBackpack = By.xpath("//img[@alt='Driven Backpack']");
	
	// constructor
	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// page action methods
	public boolean isProductDisplayed() {
		return performIsdisplay(itemSweatshirt);
	}
	
	public boolean isSearchResultContainKeyword(String expectedKeyword) {
		boolean flag = false;
		if(getString(searchedProductName).toLowerCase().contains(expectedKeyword)) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isSearchResultsNotContainKeyword(String expectedKeyword) {
		List<WebElement> elements = getListOfElements(allProducts);
		boolean flag = true;
		for(WebElement element:elements) {
			if(element.getText().toLowerCase().contains(expectedKeyword)) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public boolean isSearchResultContainMessage(String expectedMessage) {
		boolean flag = false;
		if(getString(notFoundMsg).contains(expectedMessage)) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isProductDescriptionContainsKeyword() {
		List<WebElement> colors = getListOfElements(colorDesc);
		boolean flag = false;
		for(WebElement color:colors) {
			String actualKeyword = color.getAttribute("option-label");
			if(actualKeyword.equalsIgnoreCase("blue")) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public ProductDetailsPage clickOnItemSweatshirt() {
		performClick(itemSweatshirt);
		return new ProductDetailsPage(driver);
	}
	
	public ProductDetailsPage clickOnItemBackpack() {
		performClick(itemBackpack);
		return new ProductDetailsPage(driver);
	}

}
