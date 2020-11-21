Feature: Search

  Scenario Outline: Validate that user can Search for an element
    When The web page EliteShop is opened
    Then Search for element "<element>"
    And Validate that product is returned
    Examples:
      |element|
      |shirt|