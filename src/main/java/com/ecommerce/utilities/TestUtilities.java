/**
 * 
 */
package com.ecommerce.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtilities {
	
	// method takes screeshot 
	public static byte[] cpatureScreen(WebDriver driver) {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		byte[] sourceImg = scrShot.getScreenshotAs(OutputType.BYTES);
		
		return sourceImg;
	}

}
