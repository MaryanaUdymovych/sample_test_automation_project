Feature: Home page

  @home_page @home_page_display
  Scenario: Check UBS site display
    Given user navigates to UBS site
    And user confirms Privacy Settings
    Then UBS logo is displayed
    And search bar is displayed


  @home_page @home_page_title
  Scenario: Check title
    Given user navigates to UBS site
    And user confirms Privacy Settings
    Then page title is "UBS financial services around the globe | Global topics"

  @search
  Scenario Outline: Search data
    Given user navigates to UBS site
    And user confirms Privacy Settings
    When user searches for "<Title>"
    Then "<Title>" is displayed in the result

    Examples:
       | Title                      |
       | Fund Management Services   |
