
Feature: Update my perosnal information
@FirstName
Scenario: Update first name
 		When I open automationpractice website
    And I sign in
    And I update firstname as "Selenium"
    Then I verify the user displayed name as "Selenium Practice"
    And I sign out
  
@SocialTitleToMrs
Scenario: Update social title
 		When I open automationpractice website
    And I sign in
    And I update social title as "Mrs."
    And I sign out
    
@UpdateUserDetails
Scenario: Update user details
 		When I open automationpractice website
    And I sign in
    Then I verify the user displayed name as "Selenium Practice"
    
    #Update first name to Amar and verify first name and last name
    When I update user details
    	|Title |Firstname| Lastname | Password    |
    	|Mr.	 |Amar		 | H R 		  | Framework1! |
    	
    Then I verify the user displayed name as "Amar H R"
    And I sign out
    
    #Logout and login. Verify first name and last name is Amar.
    When I sign in
   	Then I verify the user displayed name as "Amar H R"
    And I sign out
    
    #Update first name to Selenium and verify first name and last name
    When I sign in
    And I update user details
    	|Title |Firstname    | Lastname 	| Password    |
    	|Mrs.	 |Selenium		 | Practice		| Framework1! |
    	
    Then I verify the user displayed name as "Selenium Practice"
    And I sign out
    
    #Logout and login. Verify first name and last name is Selenium.
    When I sign in
   	Then I verify the user displayed name as "Selenium Practice"
    And I sign out
