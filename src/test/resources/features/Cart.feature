#Author: santosh sharma

Feature: Shopping cart feature

	Background: user performs search and click item
		Given user is on the application home page
		When user enters item in search bar and submits
		And user clicks the item
		
  Scenario: Add product to cart
    When user is on the product details page and select color, size for item
    And user clicks the add to cart button
    Then the product should be added to the cart
    And the cart should display correct quantity of the added product as "1"
    And the cart should show the price of the product
    
  Scenario: Remove product from the cart
  	When user add product to the cart and navigates to the cart page
  	And user clicks the item remove button
  	Then the cart page should display message "You have no items in your shopping cart."
  
  Scenario: Add multiple products to the cart
  	When user add first product sweatshirt to the cart
  	And user adds second product backpack to the cart
  	Then cart should have multiple product
  	
  Scenario: Update quantity of product
  	When user is on the cart page
		And user changes the quantity to "2" of the product in the cart
		Then the cart should display the correct quantity of the updated product
		And the cart should update the total price based on the new quantity
		