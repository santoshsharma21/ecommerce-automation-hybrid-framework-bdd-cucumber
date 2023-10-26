#Author: santosh sharma


Feature: User login and registration feature

	Background: upto application home page
		Given user is on the application home page
		
  Scenario: Test user login with valid credentials
  	When user navigates to login page
  	And user login with valid email and password
  	Then user should able to login
  	
  Scenario: Test user login with invalid credentials
  	When user navigates to login page
  	And user login with invalid email and password
  	Then user should not able to login
  	
  Scenario: Test user register new account
  	When user navigates to new customer account page
  	And user enter personal information
  	And user enter sign-in information
  	Then user should land on my account page and page title should be "My Account"
  	And user account should be created with message "Thank you for registering with Main Website Store."
    