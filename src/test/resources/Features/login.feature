Feature: Checkout Process on SauceDemo

  Scenario: User completes the checkout flow successfully
    Given the user has logged in to the SauceDemo platform
    And the user has added a product to their shopping cart
    When the user navigates to the checkout page
    And the user provides their checkout information
    And the user proceeds to the next checkout step
    And the user confirms the order details
    Then the order confirmation should be displayed
