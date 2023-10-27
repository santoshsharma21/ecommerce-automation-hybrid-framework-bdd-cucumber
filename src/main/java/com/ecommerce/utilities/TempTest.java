package com.ecommerce.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.SearchResultPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TempTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(19));

		
		HomePage hp = new HomePage(driver);
		SearchResultPage sp = new SearchResultPage(driver);
		sp = hp.searchItem("volleyball");
		boolean status = sp.isSearchResultContainMessage("Your search returned no results");
		System.out.println("Ans is = " + status);
		
		
	}

}
