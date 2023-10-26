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
		sp = hp.searchItem("sweat");
		boolean status = sp.isSearchResultsNotContainKeyword("sweat");
		System.out.println("Ans is = " + status);
		
		
//		String s = "Grayson Crewneck Sweatshirt";
//		String s2 = "Rapha Sports Short";
//		if(s2.toLowerCase().contains("sports")) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
	}

}
