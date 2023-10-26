/**
 * 
 */
package com.ecommerce.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverManager;
import com.ecommerce.pages.CustomerLoginPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.MyAccountPage;
import com.ecommerce.pages.NewCustomerAccountPage;
import com.ecommerce.utilities.ConfigReader;
import com.ecommerce.utilities.FakerUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Santosh Sharma
 *
 */
public class UserLoginAndRegistrationSteps {
	
	private WebDriver driver;
	private ConfigReader cfg;
	private HomePage homePage;
	private CustomerLoginPage customerLoginPage;
	private MyAccountPage myAccountPage;
	private NewCustomerAccountPage newCustomerAccountPage;
	
	@Given("user is on the application home page")
	public void user_is_on_the_application_home_page() {
		cfg = new ConfigReader();
		driver = DriverManager.getDriver();
		driver.get(cfg.getUrl());
	}

	@When("user navigates to login page")
	public void user_navigates_to_login_page() {
		homePage = new HomePage(driver);
		customerLoginPage = homePage.clickOnSignIn();
	}

	@When("user login with valid email and password")
	public void user_login_with_valid_email_and_password() {
		homePage = customerLoginPage.userLoginWithValidCredentials(cfg.getEmail(), cfg.getPassword());
	}

	@Then("user should able to login")
	public void user_should_able_to_login() {
		boolean status = homePage.validateLogin("Welcome, sony sharma!");
		assertTrue(status);
	}

	@When("user login with invalid email and password")
	public void user_login_with_invalid_email_and_password() {
		customerLoginPage.userLoginWithInvalidCredentials(FakerUtils.getFakeEmail(), FakerUtils.getFakePassword());
	}

	@Then("user should not able to login")
	public void user_should_not_able_to_login() {
		boolean status = customerLoginPage.validateLogin("The account sign-in was incorrect");
		assertTrue(status);
	}

	@When("user navigates to new customer account page")
	public void user_navigates_to_new_customer_account_page() {
		homePage = new HomePage(driver);
		newCustomerAccountPage = homePage.clickOnCreateAccount();
	}

	@When("user enter personal information")
	public void user_enter_personal_information() {
		newCustomerAccountPage.addUserPersonalDetails(FakerUtils.getFakeFirstName(), FakerUtils.getFakeLastName());
	}

	@When("user enter sign-in information")
	public void user_enter_sign_in_information() {
		myAccountPage = newCustomerAccountPage.addUserSigninDetails(FakerUtils.getFakeEmail(), "pass@12345");
	}

	@Then("user should land on my account page and page title should be {string}")
	public void user_should_land_on_my_account_page_and_page_title_should_be(String expectedTitle) {
		boolean status = myAccountPage.validatePageTitle(expectedTitle);
		assertTrue(status);
	}

	@Then("user account should be created with message {string}")
	public void user_account_should_be_created_with_message(String expectedMsg) {
		boolean status = myAccountPage.isUserAccountCreated(expectedMsg);
		assertTrue(status);
	}
}