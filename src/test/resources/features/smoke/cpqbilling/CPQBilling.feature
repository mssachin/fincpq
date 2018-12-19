Feature: Create RLF as a M Finance User - NS  User
  As a Finance user
  I should be able to create a Sales order on a Billing Group
  So that I can track the revenue associated to the deal


  Background:
    Given I have launched salesforce test sandbox url


  @Regression
  Scenario Outline: Create a recurring sales order on a billing group with <billingType> billing and <billingFrequency> frequency
    Given I have logged in to salesforce as the below user
      | username | sachin.mylavarapu@finastra.com.sit.fin.user |
      | password | Finastra!23                                 |
      | profile  | M Finance User - NS                         |
    And I search for a record of below id and type
      | key | SUB-0013578 |
    And I drill down on the record to be navigated to its details
    And I set the Billing Type on subscription to a "<billingType>"
    And I set the Billing Frequency on subscription to a "<billingFrequency>"
    And I set the SO Generation Advance field on subscription to a "<soGenerationAdvance>"
    And I set the Next SO Generation Date on Subscription to Date Today
    And I set the Billing Date on Subscription to Date Today
    And I capture the current net amount on the Subscription
    And I search for a record of below id and type
      | key | BG0030261 |
    And I drill down on the record to be navigated to its details
    And I set the Next SO Generation Date on the Billing Group to date today
    And I set the Earliest Next Billing Date on the Billing Group to date today
   #TODO
    And I query for all the sales orders associated to a billing group
      | parentRecordId | a163E00000258LB                                                                                  |
      | query          | SELECT Order_Type__c,Total_Amount__c,Order_Status__c From Sales_Order__c Where Billing_Group__c= |
    And I get the initial count of sales orders on billing group
    And I search for a record of below id and type
      | key | BG0030261 |
    And I drill down on the record to be navigated to its details
    And I click on Create RLF button
    And I query for all the sales orders associated to a billing group
      | parentRecordId | a163E00000258LB                                                                                  |
      | query          | SELECT Order_Type__c,Total_Amount__c,Order_Status__c From Sales_Order__c Where Billing_Group__c= |
    And I validate that the sales order count is increased by one
    And I validate the amount on the Sales Order to match with the amount on subscription
    And I search for a record of below id and type
      | key | SUB-0013578 |
    And I drill down on the record to be navigated to its details
    And I validate that Next SO Generation Date on the subscription record
    And I validate the Next Billing Date on the subscription record
    And I query for all the subscription records associated to a billing group
      | parentRecordId | a163E00000258LB                                                                                                                                              |
      | query          | SELECT Next_Billing_Date__c,Next_SO_generation_Date__c,Recurring_NS_Item__c,Recurring_Sales_Order_Type__c From SBQQ__Subscription__c Where Billing_Group__c= |
    And I capture the earliest Next SO Generation  Date from all Subscription records
    And I capture the earliest Next Billing Date from all Subscription records
    And I search for a record of below id and type
      | key | BG0030261 |
    And I drill down on the record to be navigated to its details
    And I validate that Next SO Generation Date on the billing group record
    And I validate the Next Billing Date on the billing group record
    And I logout of the application


    Examples:
      | billingType | billingFrequency | soGenerationAdvance |
      | Advance     | Monthly          | 30                  |
      | Advance     | Quarterly        | 30                  |
      | Advance     | Semiannual       | 30                  |
      | Advance     | Annual           | 30                  |
      | Arrears     | Monthly          | 30                  |
      | Arrears     | Quarterly        | 30                  |
      | Arrears     | Semiannual       | 30                  |
      | Arrears     | Annual           | 30                  |






