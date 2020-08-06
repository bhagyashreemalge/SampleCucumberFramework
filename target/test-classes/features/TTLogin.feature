Feature: TT Login Page

@Smoke
Scenario: Login to TT using valid user credentials
Given the user is on TT Login page
When user enters "samuel.mathi@internationalsos.com" and "Texas@123456"
Then TT homepage should be displayed

@Sanity
Scenario: Login to TT using valid username and password
Given the user is on TT Login page
When user enters following details
|samuel.mathi@internationalsos.com|Texas@123456|
Then TT homepage should be displayed

@Regression
Scenario Outline: Login to TT using mutliple credentials
Given the user is on TT Login page
When user enters user credentials <username> and <password>
Then TT homepage should be displayed

Examples:
|username|password|
|user1|pass1|
|samuel.mathi@internationalsos.com|Texas@123456|
|user2|pass2|