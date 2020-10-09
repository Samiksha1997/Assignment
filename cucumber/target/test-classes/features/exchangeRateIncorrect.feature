Feature: Exchange Rate

 
  Scenario: Verify response code for incorrect url for Latest Foreign Exchange rates
    Given Customer have provided incorrect API for Foreign Exchange rates
    When Coustomer hit incorrect API
    Then response will be bad request
    

 