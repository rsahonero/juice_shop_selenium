@regression
Feature: basket
  As a registered customer
  I want to review the products on the basket
  So that I can complete my order

  Background:
    Given User is logged in the system

@basket
  Scenario Outline: Complete an order adding products with the search option
    Given User adds the products "<products>" to the basket using the search option
    When User navigates to the Basket page
    And User selects the address number <addressIndex>
    And User selects the payment method number <paymentIndex>
    And User places the order
    Then The order confirmation message "Thank you for your purchase!" is displayed

    Examples:
      | products            | addressIndex | paymentIndex |
      | apple,banana,shirt  | 2            | 1            |

@catalog
  Scenario Outline: Complete an order adding products from the catalog
    Given User adds <quantity> random products from the catalog to the basket
    When User navigates to the Basket page
    And User selects the address number <addressIndex>
    And User selects the payment method number <paymentIndex>
    And User places the order
    Then The order confirmation message "Thank you for your purchase!" is displayed

    Examples:
      | quantity | addressIndex | paymentIndex |
      | 2        | 2            | 1            |