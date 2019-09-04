Login

Meta:
@tag login

Narrative:
  In order to use app functionality
  As a user
  I want to be able to login

Scenario: Successful user login
Meta:
@tag login01
Given I open Landing Page
When I click on 'Sign in' button
Then I should be on Login page
When I sign In with '<email>' , '<password>'
Then I should be on Main page

Examples:
|email                          |password|
|arhiv_@ukr.net                 |Eks,rf321|

Scenario: Unsuccessfull user login in order to remain on Login page
Meta:
@tag login02
Given I open Landing Page
When I click on 'Sign in' button
Then I should be on Login page
When I sign In with '<email>' , '<password>'
Then I should remain on Login page and receive the error "This is wrong password.."

Examples:
|email                          |password|
|arhiv_@ukr.net                 |dwfewfewrfe13|