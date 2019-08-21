Login

Meta:
@tag product:login

Narrative:
  In order to use app functionality
  As a user
  I want to be able to login

Scenario: Successful user login
Given I open Landing Page
Given I go to Login page
When I submit authentication data
Then Main page is loaded
