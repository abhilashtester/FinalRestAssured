Feature: verift suscess response2323
  Scenario Outline:: User calls web service to get a book by its ISBN
	Given user enter baseURL
	#When a user retrieves the book by isbn
	When a user enter query perameter the details with "<Permeter1>" and "<Permeter2>"
	Then the status code is 200
	And response includes the following
	| results.artistName[1] 	 		| Jack Johnson 					|
	| results.artistId[1]					| 909253			|
 
Examples:
        |Permeter1|Permeter2|
       | jack+johnson|musicVideo|


  Scenario Outline:: User calls web service to get a book by its ISBN
	Given user enter baseURL
	When a user enter query perameter the details with "<Permeter1>" and "<Permeter2>"
	Then the status code is 200
	And response includes the following
	| results.artistName[1] 	 		| Jack Johnson 					|
	| results.artistId[1]					| 909253			|
 
Examples:
        |Permeter1|Permeter2|
       | !!!!!!!!|musicVideo|


