#Author: santosh sharma

Feature: Checkout process feature
 
  Scenario: Successful checkout process
    Given user is on the application home page
    When user seraches for "sweatshirt" and click on the item from search results
    And user selects size as "M" color as "Orange" and quantity as 1 
    And user adds product to shopping cart
    And user navigates to checkout page
    And user enters shipping details 
    And user clicks on the place order button
    Then system should display confirmation message "Thank you for your purchase!"
 