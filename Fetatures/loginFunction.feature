Feature: User able to login with valid username & password

Description: "User login orangehrm website & verify title"
 
#Background:   Contain common step     
@Smoke                                                 
Scenario: User login with valid username & verify the page title

#Given User can open any browser
#And User able to enter url
# Above steps in cucumber hooks
Given  User enter the userName and password 
When User click on the login button
Then User able to verify successfully login & verify the homepage title




