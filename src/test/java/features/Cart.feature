Feature: Verify product in cart
#Verify once item is added in cart
Scenario: Search a product and verify in cart
Given User has logged in application
When Search for a product
Then Add the product to cart
Then Verify if product in cart is correct
And Verify if quantity is correct