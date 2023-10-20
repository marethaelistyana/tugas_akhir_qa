Feature: Log in to the application

  Scenario Outline: Login to application as valid user
    Given user is on SauceDemo login page
    When user input <username> as username
    And user input <password> as password
    And user click submit
    Then show page of <status> as stat
    Examples:
      | username      | password    | status |
      | standard_user | secret_sauce |  valid |
      | falsename     | secret_saucex | invalid |

#    Scenario: Login to application as Invalid user
#      When User enter the invalid credentials
#      And Click on Login
#      Then Error message should be displayed