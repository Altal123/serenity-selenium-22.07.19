Login

Meta:
@tag product:login

Narrative:
  In order to use app functionality
  As a user
  I want to be able to login

Scenario: Successful user login
Given I open Landing Page
When I click on 'Sign in' button
Then I should be on Login page
When I sign In as registered user
Then I should be on Main page
