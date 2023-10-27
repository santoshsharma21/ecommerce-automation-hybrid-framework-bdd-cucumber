#Author: santosh sharma

Feature: Product search feature

	Background: upto application home page
		Given user is on the application home page

  Scenario: Product search using valid keyword
    When user enters keyword "sweatshirt" in the search bar and submits the search
    Then the search result page should display product
    And the displayed product should have entered keyword "sweatshirt" in the name
    
  Scenario: Product search using partial keyword
  	When user enters partial keyword "sweat" in the search bar and submits the search
  	Then the search result page should display the products with keyword "sweat" in the name
  	And search result page should not contain products that do not have partial keyword "sweat" in the name 
  	
  Scenario: Product search using case-insensitive keyword
  	When user enters keyword with mixed case "sWeaTshiRT" in the search bar and submits the search
  	Then the search result page should display the products regardless of keyword case
  	
  Scenario: Product search with valid keyword for no matching product
  	When user enters valid keyword "volleyball" that does not match any products and submits the search
  	Then a message should displayed indicating "Your search returned no results"
  	
  Scenario: Product search with multiple keywords
  	When user enters multiple keywords "blue jacket" in the search bar and submits the search
  	Then the search result page should display products contain any of the entered keyword in name or description
  