Feature: User should be able to search the flight 

@Test123wqwqwqw
Scenario Outline: Free CRM Login Test Scenario

Given user enter baseURL
When a user enter query perameter the details with "<perametr1>" and "<perametr2>"
Then the status code is 200


Examples:
       |perametr1|perametr2|
       |jack+johnson|musicVideo|
       
       
Scenario Outline: with incorrect URL
When a user enter query perameter the details with "<perametr1>" and "<perametr2>"
Then the status code is 200
Then response includes the following
|resultCount|0|
|results|null|


Examples:
       |perametr1|perametr2|
       |@@@@@@@|#####|
       
 Scenario Outline: with incorrect URL
When a user enter query perameter the details with "<perametr1>" and "<perametr2>"
And Perform Put Operation
Then the status code is 501


Examples:
       |perametr1|perametr2|
       |jack+johnson|musicVideo|
