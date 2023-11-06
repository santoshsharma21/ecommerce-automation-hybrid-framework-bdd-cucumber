/**
 * 
 */
package com.ecommerce.utilities;

import com.github.javafaker.Faker;

/**
 * @author Santosh Sharma
 *
 */
public class FakerUtils {

	private static Faker faker = new Faker();

	// return fake email
	public static String getFakeEmail() {
		return faker.internet().emailAddress();
	}

	// return fake password
	public static String getFakePassword() {
		return "password@" + faker.internet().password(2, 3);
	}

	// return fake first name and last name
	public static String getFakeFirstName() {
		return faker.name().firstName();
	}

	public static String getFakeLastName() {
		return faker.name().lastName();
	}

	public static String getFakeAddress() {
		return "House No. - " + faker.address().buildingNumber();
	}

	public static String getFakeCityName() {
		return "kanpur";
	}

	public static String getFakeStateName() {
		return "Uttar Pradesh";
	}

	public static String getFakeZipCode() {
		return "111223";
	}

	public static String getFakeCountryName() {
		return "India";
	}

	public static String getFakePhoneNum() {
		return "123456789";
	}	
}
