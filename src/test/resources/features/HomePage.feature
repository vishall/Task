@smoke
Feature: To test summer dresses can be added to cart

  Scenario: Verify summer dresses can be added into the cart
    Given user on the home page
    And user select summer dresses from the sub menu
    And user should be able to see summer dresses
    When user click on add to the cart for summer dresses
    Then verify summer dresses should be added into the basket respectively
    And user should be able to navigate to sign in page
