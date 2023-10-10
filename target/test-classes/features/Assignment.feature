Feature: Check product name and quantity in cart

  Background: user is logged in homepage
    Given user is on homepage

  # Invalid Credentials
  Scenario: Check if user is unable to login
    When User enters invalid credentials
      | tomsmith              | password        |
      | mituldotcom@gmail.com | Harekrishna2023 |
    Then User does not login
    Then Check the error message

  Scenario: Search a product and verify in cart
    When user enters username and password
      | mituldotcom@gmail.com | Hareram2023 |
    Then user is navigated to homepage
    Then Search for a product
    Then Add the product to cart
    Then Verify if product in cart is correct
    And Verify if quantity is correct
