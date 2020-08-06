Feature: TT Login Page

Background:
Given the user have browser
When user clicks on browser
Then browser should be opened

@Smoke
Scenario: Login to Amazon using valid user credentials
Given the user is on Amazon home page
When user clicks on signin link
And enters valid user credentials
Then Amazon homepage should be displayed
And logged in profile should be displayed

