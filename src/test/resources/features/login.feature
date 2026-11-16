@login
Feature: Login functionality on fruit juice
  As a registered customer
  I want to log in and log out securely
  So that I can access my account and shop with confidence

  Scenario Outline: Login attempts with different credentials
    Given User navigates to the Login page
    When User enters "<username>" and "<password>" on the Login Page
    Then The system displays the message "<message>"

    Examples: Successful logins
      | username         | password   | message          |
      | jhon168@user.com | Password1! | OWASP Juice Shop |

    Examples: Unsuccessful logins
      | username          | password     | message                    |
      | rachel01          | Password1!   | Invalid email or password. |
      | rachel01@user.com | Failpassword | Invalid email or password. |