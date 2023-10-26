/**
 * 
 */
package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Santosh Sharma
 *
 */
public class ConfigReader {

	private Properties pro;

	public ConfigReader() {
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/configurations/config.properties");
		try {
			FileInputStream ip = new FileInputStream(file);
			pro = new Properties();
			pro.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowserName() {
		return pro.getProperty("browser");
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
	public String getEmail() {
		return pro.getProperty("email");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getUserName() {
		return pro.getProperty("username");
	}
}