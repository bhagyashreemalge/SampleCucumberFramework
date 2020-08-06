Feature: Place order on Greenkart


@Smoke
Scenario Outline:: Select multiple items and place the order
Given user is on greenkart landin page
When user searches for <item> in search textbox
And places the item in the cart
Then user should be able to place order for selected items

Examples:
|item|
|Beetroot|
|Capsicum|
|Potato|