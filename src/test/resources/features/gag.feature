Feature: Gag

  Scenario Outline: Search for computer and header presence
    Given The chrome browser is launched
    When The 9gag web page is opened
    Then Search for "<element>"
    Then Validate the header presence
    And Close browser

    Examples:
      | element  |
      | computer |