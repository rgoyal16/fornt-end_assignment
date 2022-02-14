Feature: Login Functionality for chrome browser


  Scenario: Login Successful
    Given I am in the login page of the demo site
    When Take data from excel sheet
    Then Browser close automatically

  Scenario: Login Successful
    Given I am in the login page of the demo site for automate firefox browser
    When Take data from excel sheet for firefox  browser
    Then Browser close automatically for firefox  browser

  Scenario: Login Successful
    Given I am in the login page of the demo site for automate Headless browser
    When Take data from excel sheet for Headless browser
    Then Browser close automatically for Headless browser
