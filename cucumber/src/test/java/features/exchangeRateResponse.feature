Feature: Exchange Rate

 
  Scenario: Verify response for Latest Foreign Exchange rates
    Given API for Foreign Exchange rates
    When Coustomer hit latest rate API
    Then verify the body as base
    

 