Feature: Exchange Rate

 
  Scenario: Verify response code for Latest Foreign Exchange rates
    Given Customer have API for Foreign Exchange rates
    When Coustomer hit API
    Then Status code will be 200
    

 