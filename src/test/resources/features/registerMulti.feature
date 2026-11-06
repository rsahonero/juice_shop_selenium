@register2
Feature: User registration
  As a new visitor
  I want to create an account
  So that I can shop and manage my orders

  Scenario: Register multiple customer
    Given User navigates to the Create an Account page
    When The following registration details are provided
      | email              | password      | repeatPassword | securityQuestion                  | answer |
      | jhon868@user.com   | Password1!    | Password1!     | Your eldest siblings middle name? | Smith  |
      | vanesa969@user.com | Password2334! | Password2334!  | Your eldest siblings middle name? | Colby  |
    Then A success message “Thank you for registering” should be displayed

