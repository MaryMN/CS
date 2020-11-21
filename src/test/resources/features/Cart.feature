Feature: Cart

  Scenario: Validate that user can add item to the cart
    When The web page is opened
    Then Choose a product
    And Click Add to Cart Button
    Then Validate that product appears on cart