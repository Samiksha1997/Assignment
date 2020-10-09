Feature: Exchange Rate

 
  Scenario: Verify response for future date Foreign Exchange rates
    Given Customer have API for future date Foreign Exchange rate
    When Coustomer hit Specific date Exchange rate API for future date
    Then verify date for specific date exchange rate API
    

 