Feature: Test contact us    
@VerifyWrongEmailValidationWorksInContactUs
Scenario: Contact Us with wrong email id fails
 		When I open automationpractice website
    And I sign in
    Then I verify sending message with wrong email id fails

@VerifySendingMessage
Scenario: Sending message works in Contact Us 
 		When I open automationpractice website
    And I sign in
    Then I verify sending message works