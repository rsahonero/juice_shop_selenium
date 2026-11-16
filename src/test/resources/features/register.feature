@regression @register
Feature: User registration
  As a new customer
  I want to save payment methods
  So that I can shop and complete my order

  Scenario Outline: Register multiple customers
    When User navigates to the Create an Account page
    And User registers with "<email>", "<password>", "<repeatPassword>", "<securityQuestion>" and "<answer>"
    Then A success message “Thank you for registering” should be displayed

    Examples:
      | email              | password      | repeatPassword | securityQuestion                  | answer |
      | jhon388@user.com   | Password1!    | Password1!     | Your eldest siblings middle name? | Smith  |
      | vanesa389@user.com | Password2334! | Password2334!  | Your eldest siblings middle name? | Colby  |

