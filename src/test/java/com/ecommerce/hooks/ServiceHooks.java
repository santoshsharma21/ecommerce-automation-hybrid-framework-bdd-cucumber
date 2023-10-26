/**
 * 
 */
package com.ecommerce.hooks;

import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.utilities.ConfigReader;
import com.ecommerce.utilities.TestUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author Santosh Sharma
 *
 */
public class ServiceHooks {
	public WebDriver driver;
	private ConfigReader cfg;
	private DriverManager driverManager;
	
	@Before(order = 0)
	public void launchBrowser() {
		cfg = new ConfigReader();
		driverManager = new DriverManager();
		driver = driverManager.initBrowser(cfg.getBrowserName());
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			String scrName = scenario.getName().replaceAll(" ", "_");
			byte[] img = TestUtilities.cpatureScreen(driver);
			scenario.attach(img, "image/png", scrName);
		}
	}
}