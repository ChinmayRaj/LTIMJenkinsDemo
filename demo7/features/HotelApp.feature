Feature: HotelAppLogin

Scenario: Successfull Login
Given User is on HotelAppLogin Page
When User Enters Valid UserName
And User Enters Valid Password
And User Clicks on Login Button
Then User is Successfully Logged In