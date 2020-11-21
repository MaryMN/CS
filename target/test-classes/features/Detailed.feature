Feature: Quick View of a product

  Scenario: Validate that user can view detailed info about selected product
    When The main page is opened
    Then Choose a product from list
    And Click Quick View Button
    Then Validate that page with details about product appears