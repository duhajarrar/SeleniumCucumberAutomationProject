Feature: Search for correct values

  @TestCaseKey=JT-T38
  Scenario Outline: Search for correct values
    Given A user navigate to home page.
    And A user enters "<text>" in search text.
    And A user selects the search option "<option>".
    Then A user clicks on the search button.

    Examples: 
      | text              | option |
      | software engineer | jobs   |
      | Asal Technologies | companies |
      | قانون العمل | articles |
