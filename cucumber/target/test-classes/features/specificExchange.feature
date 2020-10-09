Feature: Exchange Rate

 
  Scenario: Verify response code for specific date Foreign Exchange rates
    Given Customer have API for Specific date Foreign Exchange rates
    When Coustomer hit Specific date API
    Then Status code will be ok
    

 