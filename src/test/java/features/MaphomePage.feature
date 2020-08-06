Feature: TT Login Page

@Smoke
Scenario: Login to TT using valid user credentials
Given the user is on TT Maphome page
When user clicks on alerts tab
Then Alert panel should be displayed
