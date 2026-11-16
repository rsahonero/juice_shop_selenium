@history
Feature: Order history
  As a registered customer
  I want to review my orders
  So that I can verify my completed purchases

  Background:
    Given User is logged in the system

  Scenario: Review completed orders in the history
    When User navigates to the Order History page
    Then The order history shows 2 orders
    And User takes a screenshot of the orders