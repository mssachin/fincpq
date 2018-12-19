Feature: Apply Uplift as a M B&RA profile + CS Sys Admin  User
  As a Billing user
  I should be able to apply uplift on the Subscription or Quote Line Items
  So that I can adjust the amount to bill depending on market movement

  Background:
    Given I have launched salesforce test sandbox url
    And I have logged in to salesforce as the below user
      | username | sachin.mylavarapu@finastra.com.sit.mbra |
      | password | Finastra!23                             |
      | profile  | M B&RA profile + CS Sys Admin           |

  @Regression
  Scenario Outline: Apply CPI Uplift to a Non Transactional Subscription Advance and Arrears Billing
    Given I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I set the Billing Type on subscription to a "<billing type>"
    And I set the Billing Frequency on subscription to a "<frequency>"
    And I capture the current fair value on the Subscription
    And I capture the current net price on the Subscription
    And I search for a record of below id and type
      | key | Uplift-05413 |
    And I drill down on the record to be navigated to its details
    And I set the override field to a "<factor>"
    And I capture the Uplift Factor
    And I set the Uplift Annual Effective Date to todays date
    And I set the Uplift Application Date to todays date
    And I set the Billing Type to a "<billing type>"
    And I set the Billing Frequency to a "<frequency>"
    And I set the CPI Uplift Type to an "<uplift type>"
    And I set the Uplift Calc Type to a "<calc type>"
    And I set the Uplift Advance field to a "<advance value>"
    And I set the Hold Billing Flag to a "<flag>"
    And I capture the current uplift calc type
    And I capture the uplift annual effective date before uplift
    And I click on Apply Uplift Button
    And I validate the new Uplift Annual Effective Date
    And I validate the new Uplift Application Date
    Then I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I validate that fair value on the subscription is uplifted by the uplift factor
    And I validate that net price on the subscription is uplifted by the uplift factor
    And I logout of the application

    Examples:
      | factor | billing type | frequency | uplift type | calc type | advance value | flag  |
      | 10     | Advance      | Annual    | Anniversary | Full Year | 60            | false |
      | 10     | Arrears      | Annual    | Anniversary | Full Year | 60            | false |


  @Regression
  Scenario Outline: Apply CPI Uplift to a Transactional Subscription Advance and Arrears Billing
    Given I search for a record of below id and type
      | key | SUB-0012722 |
    And I drill down on the record to be navigated to its details
    And I set the Billing Type on subscription to a "<billing type>"
    And I set the Billing Frequency on subscription to a "<frequency>"
    And I validate that the Subscription record is Transactional
    And I extract the quote line item ids associated to subscription
    And search for each quote line item and extract the current values of price and unit price and minimum price
      | type | initial |
    And I search for a record of below id and type
      | key | Uplift-05420 |
    And I drill down on the record to be navigated to its details
    And I set the override field to a "<factor>"
    And I capture the Uplift Factor
    And I set the Uplift Annual Effective Date to todays date
    And I set the Uplift Application Date to todays date
    And I set the Billing Type to a "<billing type>"
    And I set the Billing Frequency to a "<frequency>"
    And I set the CPI Uplift Type to an "<uplift type>"
    And I set the Uplift Calc Type to a "<calc type>"
    And I set the Uplift Advance field to a "<advance value>"
    And I set the Hold Billing Flag to a "<flag>"
    And I capture the current uplift calc type
    And I capture the uplift annual effective date before uplift
    And I click on Apply Uplift Button
    And I validate the new Uplift Annual Effective Date
    And I validate the new Uplift Application Date
    And search for each quote line item and extract the current values of price and unit price and minimum price
      | type | postUplift |
    Then I validate the values of price and unit price and minimum price are uplift by the factor
    And I logout of the application

    Examples:
      | factor | billing type | frequency |uplift type | calc type | advance value |flag  |
      | 10     | Advance      | Annual    |Anniversary | Full Year |  60           |false |
      | 10     | Arrears      | Annual    | Anniversary | Full Year | 60            | false |


  @Regression @InDev
  Scenario Outline: Apply CPI Uplift on Pro-Rata and Interim basis for <billing type> billing and <frequency> frequency
    Given I search for a record of below id and type
      | key | CN139501 |
    And I drill down on the record to be navigated to its details
    And I set the contract start date to the date below
      | startDate | 01/01/2018 |
    Given I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I set the Billing Type on subscription to a "<billing type>"
    And I set the Billing Frequency on subscription to a "<frequency>"
    And I set the quote line on subscription to below value
      | quoteLineItemId | QL-0009173 |
    And I capture the current fair value on the Subscription
    And I capture the current net price on the Subscription
    And I search for a record of below id and type
      | key | Uplift-05413 |
    And I drill down on the record to be navigated to its details
    And I set the override field to a "<factor>"
    And I capture the value in Net Customer Uplift field
    And I capture the Uplift Factor
    And I set the Billing Type to a "<billing type>"
    And I set the Billing Frequency to a "<frequency>"
    And I set the CPI Uplift Type to an "<uplift type>"
    And I set the Uplift Calc Type to a "<calc type>"
    And I set the Uplift Advance field to a "<advance value>"
    And I set the Hold Billing Flag to a "<flag>"
    And I set the Uplift Start Date to a "<start date>"
    And I set the Uplift Annual Effective Date to a "<annual effective date>"
    And I set the Uplift Application Date to a "<application date>"
    And I capture the Uplift Factor
    And I capture the current uplift calc type
    And I compute the expected uplift factor value and validate it against the value from salesforce
    And I capture the uplift annual effective date before uplift
    And I click on Apply Uplift Button
    And I validate the new Uplift Annual Effective Date
    And I validate the new Uplift Application Date
    And I validate that the Uplift Calc Type is changed to below value
      | upliftCalcType | Interim |
    And I capture the current uplift calc type
    And I validate the Interim Uplift Percentage field is changed to a Net Customer Uplift value
    Then I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I validate that fair value on the subscription is uplifted by the uplift factor
    And I validate that net price on the subscription is uplifted by the uplift factor
    And I drill down on the Quote Item to be navigated to its details page
      | quoteLineItemId | QL-0009173 |
    And I set the "<net unit price>" on quote to a value
    And I search for a record of below id and type
      | key | Uplift-05413 |
    And I drill down on the record to be navigated to its details
    And I capture the uplift annual effective date before uplift
    And I click on Apply Uplift Button
    And I validate the new Uplift Annual Effective Date
    And I validate the new Uplift Application Date
    And I validate that the Uplift Calc Type is changed to below value
      | upliftCalcType | Full Year |
    And I capture the current uplift calc type
    And I validate uplift factor is changed to net customer uplift value as a decimal
    Then I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I validate that net price on the subscription is uplifted by the interim uplift factor based on the quote net price
    And I logout of the application

    Examples:
      | factor | billing type | frequency | uplift type | calc type | advance value | flag  | net unit price | start date | annual effective date | application date |
      | 3.9    | Advance      | Monthly   | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/06/2018 | 01/06/2018            | 02/04/2018       |
      | 3.9    | Advance      | Quarterly  | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/08/2018 | 01/07/2018            | 02/05/2018       |
      | 3.9    | Arrears      | Monthly    | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/06/2018 | 01/06/2018            | 31/07/2018       |
      | 3.9    | Arrears      | Quarterly  | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/08/2018 | 01/07/2018            | 30/08/2018       |
      | 3.9    | Advance      | Semiannual | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/04/2018 | 01/01/2018            | 02/11/2017       |
      | 3.9    | Arrears      | Semiannual | Calendar    | Pro-Rata  | 60            | false | 100.00         | 12/04/2018 | 01/01/2018            | 02/03/2018       |


  @Regression @InDev
  Scenario Outline: Apply CPI Uplift on Pro-Rata and Interim basis for <billing type> billing and <frequency> frequency
    Given I search for a record of below id and type
      | key | CN139501 |
    And I drill down on the record to be navigated to its details
    And I set the contract start date to the date below
      | startDate | 01/01/2018 |
    Given I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I set the Billing Type on subscription to a "<billing type>"
    And I set the Billing Frequency on subscription to a "<frequency>"
    And I capture the current fair value on the Subscription
    And I capture the current net price on the Subscription
    And I search for a record of below id and type
      | key | Uplift-05413 |
    And I drill down on the record to be navigated to its details
    And I set the override field to a "<factor>"
    And I capture the value in Net Customer Uplift field
    And I capture the Uplift Factor
    And I set the Billing Type to a "<billing type>"
    And I set the Billing Frequency to a "<frequency>"
    And I set the CPI Uplift Type to an "<uplift type>"
    And I set the Uplift Calc Type to a "<calc type>"
    And I set the Uplift Advance field to a "<advance value>"
    And I set the Hold Billing Flag to a "<flag>"
    And I set the Uplift Start Date to a "<start date>"
    And I set the Uplift Annual Effective Date to a "<annual effective date>"
    And I set the Uplift Application Date to a "<application date>"
    And I capture the Uplift Factor
    And I capture the current uplift calc type
    And I compute the expected uplift factor value and validate it against the value from salesforce
    And I capture the uplift annual effective date before uplift
    And I click on Apply Uplift Button
    And I validate the new Uplift Annual Effective Date
    And I validate the new Uplift Application Date
    And I validate that the Uplift Calc Type is changed to below value
      | upliftCalcType | Full Year |
    And I capture the current uplift calc type
    And I validate uplift factor is changed to net customer uplift value as a decimal
    Then I search for a record of below id and type
      | key | SUB-0013202 |
    And I drill down on the record to be navigated to its details
    And I validate that fair value on the subscription is uplifted by the uplift factor
    And I validate that net price on the subscription is uplifted by the uplift factor
    And I logout of the application

    Examples:
      | factor | billing type | frequency | uplift type | calc type | advance value | flag  | start date | annual effective date | application date |
      | 3.9    | Advance      | Annual    | Calendar    | Pro-Rata  | 60            | false | 12/04/2018 | 01/01/2018            | 02/11/2017       |
      | 3.9    | Arrears      | Annual    | Calendar    | Pro-Rata  | 60            | false | 12/06/2018 | 01/01/2018            | 02/03/2018       |
