@homePage
Feature: Verify Home page contents
					This will verify all the home page elements are working fine. 

  @headers
  Scenario: Verify Headers
    Given User is on Home page
    And Validates App logo
    And Validate Flight + Hotel menu
    And Validate Hotels + Homes menu
    And Validate Transport menu
    And Validate Activities menu
    And Validate Coupons and Deals menu
    And Validate language menu
    Then Validate currency menu

