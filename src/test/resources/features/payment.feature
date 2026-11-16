@regression @payment
Feature: User payment
  As a new visitor
  I want to create an account
  So that I can shop and manage my orders

  Background:
    Given User is logged in the system

  Scenario Outline: Add different payments
    When User navigates to the Payment page
    And User registers with "<name>", "<cardNumber>", "<expiryMonth>" and "<expiryYear>"
    Then A success message for the card ending with "<cardNumber>" should be displayed

    Examples:
      | name  | cardNumber       | expiryMonth | expiryYear |
      | Smith | 2222420000001113 | 10          | 2084       |
      | Colby | 2223000048410010 | 11          | 2085       |

