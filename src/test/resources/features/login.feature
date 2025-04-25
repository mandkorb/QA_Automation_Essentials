Feature: User Login
  Scenario Outline: Successful login
    Given User navigate to the login page
    When User enter valid "<username>" and "<password>"
    And User submit login form
    Then User should be redirected to SecurePage

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |