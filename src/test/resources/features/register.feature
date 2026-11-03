@register
Feature: User registration
  As a new visitor
  I want to create an account
  So that I can shop and manage my orders

  Scenario: Successful registration with valid data
    Given User navigates to the Create an Account page
    When User completes the registration form with valid information
    And The user account should be created successfully
    Then A success message “Thank you for registering” should be displayed
