@Filter-feature
Feature: Verify Filter Features

  Background: Open Home Page
    Given I open Home Page
    Then I verify Home Page loaded successfully

  @FilterPage-SortFirstNameDescending-Scenarios
  Scenario Outline: Verify sorting of First Name column in Descending order
    When I enter User Email is "$validUserEmail"
    And I enter User Password is "$validPassword"
    And I click Sign-In button to go to Filter Page
    And I click "<ColumnName>" header column
    Then I verify "<ColumnName>" column is sorted in Descending order
    Examples:
      | ColumnName |
      | First Name |

  @FilterPage-SortFirstNameAscending-Scenarios
  Scenario Outline: Verify sorting of First Name column in Ascending order
    When I enter User Email is "$validUserEmail"
    And I enter User Password is "$validPassword"
    And I click Sign-In button to go to Filter Page
    And I click "<ColumnName>" header column
    And I click "<ColumnName>" header column
    Then I verify "<ColumnName>" column is sorted in Ascending order
    Examples:
      | ColumnName |
      | First Name |

  @FilterPage-RequestStatusInactive-Scenarios
  Scenario Outline: Verify filter Student Access Request with INACTIVE
    When I enter User Email is "$validUserEmail"
    And I enter User Password is "$validPassword"
    And I click Sign-In button to go to Filter Page
    And I click on Filter Search button on top of page
    And I select Request Status on Filter popup is "<Condition>"
    Then I verify filter Student for "<ColumnName>" column with status "<Condition>" are displayed properly
    Examples:
      | ColumnName     | Condition |
      | Request Status | Inactive  |

