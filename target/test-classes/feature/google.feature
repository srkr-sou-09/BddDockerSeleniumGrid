Feature: google Search

  Background: 
    Given I am on the Google search page

  Scenario: Finding some cheese
    When I search for "Cheese!"
    Then the page title should start with "cheese"

  Scenario: Finding cucumber BDD
    When I search for "cucucmber"
    Then I validate that the page title should start with "cucucmber"

  Scenario Outline: Finding cucucmber bdd scenario
    When I search for "<keyword>"
    Then I validate that the page title should start with "<keyword>"

    Examples: 
      | keyword  |
      | Selenium |
      | Postman  |

  Scenario: Google Search using dataTables
    Then I search for below keywords
      | keyword1 | keyword2  |
      | Cucumber | BDD       |
      | Selenium | Cucumber	 |	
