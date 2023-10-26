package com.ecommerce.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecommerce.pages.CustomerLoginPage;
import com.ecommerce.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TempTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(19));
//		
//		WebElement ele = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
//		System.out.println(ele.getText());
		
		HomePage hp = new HomePage(driver);
		CustomerLoginPage clp;
		
		
		clp = hp.clickOnSignIn();
		clp.userLoginWithInvalidCredentials("invalid@gmail.com", "shop@123");
		WebElement ele = driver.findElement(By.xpath("//div[@class='message-error error message']"));
		System.out.println("INNER TEXT IS = "    + ele.getText());
		driver.quit();
	}

}
