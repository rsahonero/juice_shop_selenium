@address
Feature: Address
  As a customer
  I want to register my address or addresses for shipping my product

  Background:
    Given User is logged in the system

  Scenario Outline: Add different addresses
    When User navigates to the Address page
    And User registers with "<country>", "<name>", "<mobileNumber>", "<zipCode>", "<address>", "<city>" and "<state>"
    Then A success message for the address at "<city>" should be displayed

    Examples:
      | country | name     | mobileNumber | zipCode | address                   | city       | state   |
      | Bolivia | Valeria  | 589552225    | 345     | Av. Tadeo Haenke 3465     | Cochabamba | cercado |
      | Bolivia | Fernanda | 856995266    | 564     | Av Blanco Edificio Torrez | Sucre      | cercado |


