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
	private By searchedProduct = By.xpath("//img[@alt='Grayson Crewneck Sweatshirt ']");
	private By searchedProductName = By.xpath("//a[normalize-space()='Grayson Crewneck Sweatshirt']");
	private By allProducts = By.xpath("//div[@class='products wrapper grid products-grid']//ol//li//div//strong//a");
	
	// constructor
	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// page action methods
	public boolean isProductDisplayed() {
		return performIsdisplay(searchedProduct);
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

}
