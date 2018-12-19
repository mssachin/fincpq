Feature:  Validate CAT Profile
  As a Billing user
  I should have access to Objects and fields
  In order to billing functions


  @Profiles
  Scenario: Test Scenario
    Given I have launched salesforce test sandbox url
    And I have logged in to salesforce as the below user
      | username | sachin.mylavarapu@finastra.com.sit.mbra |
      | password | Finastra!23                             |
      | profile  | M B&RA profile + CS Sys Admin           |
    Given I search for a record of below id and type
      | key | CN139500 |
    And I drill down on the record to be navigated to its details
    And I validate all the fields in the Pre-Log section on the contracts page as below
      | columnName                        | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Contract Number                   | false             | false           | 0         | 0            |
      | Contract 18chr Id                 | false             | false           | 0         | 2            |
      | Misys Opportunity                 | true              | true            | 1         | 0            |
      | Contract Record Type              | true              | true            | 1         | 2            |
      | Opportunity Number (ON)           | true              | false           | 2         | 0            |
      | Logging Stage                     | true              | true            | 2         | 2            |
      | Opportunity Total Amount          | true              | false           | 3         | 0            |
      | Contract Total Amount             | true              | true            | 3         | 2            |
      | Opportunity Licence Amount        | true              | false           | 4         | 0            |
      | Contract Licence Amount           | true              | true            | 4         | 2            |
      | Opportunity Recurring Fees Amount | true              | false           | 5         | 0            |
      | Contract Recurring Fees Amount    | true              | true            | 5         | 2            |
      | Opportunity Services Amount       | true              | false           | 6         | 0            |
      | Contract Services Amount          | true              | true            | 6         | 2            |
      | Services Amount Variance          | false             | false           | 7         | 0            |
      | Within Tolerance                  | false             | false           | 7         | 2            |
      | Opportunity CLD/HOS/SUB ACV       | true              | false           | 8         | 0            |
      | Contract CLD/HOS/SUB ACV          | true              | true            | 8         | 2            |
      | Opportunity Stage                 | true              | false           | 9         | 0            |
      | No New Contract                   | true              | true            | 9         | 2            |
      | Opportunity Type                  | true              | false           | 10        | 0            |
      | Commercial Manager                | true              | false           | 10        | 2            |
      | Opportunity Billing Schedule      | false             | true            | 11        | 0            |
      | Opp_Currency                      | false             | false           | 11        | 2            |
      | Finastra Entity                   | true              | true            | 12        | 0            |
      | Billing Currency                  | false             | true            | 12        | 2            |
      | Primary Billing Customer          | false             | true            | 13        | 0            |
      | Sales Order Type                  | false             | true            | 13        | 2            |
      | Account By Sub                    | false             | true            | 14        | 0            |
      | Memo                              | false             | true            | 14        | 2            |
      | PO required                       | true              | false           | 15        | 0            |
      |                                   | false             | false           | 15        | 2            |
      | Order                             | false             | true            | 16        | 0            |
      |                                   | false             | false           | 16        | 2            |
      | Special Terms                     | true              | true            | 17        | 0            |
      |                                   | false             | false           | 17        | 2            |
      | Transactions                      | false             | true            | 18        | 0            |
      |                                   | false             | false           | 18        | 2            |
#      | Description                       | true            | true              | 19        | 0            |
#      | Terms - Image Extract             | true            | true              | 20        | 0            |
    And I validate all the fields in the ReachOut section on the contracts page as below
      | columnName      | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Reachout Reason | false             | true            | 0         | 0            |
      |                 | false             | false           | 0         | 2            |
      | Reachout Notes  | true              | true            | 1         | 0            |
      |                 | false             | false           | 1         | 2            |
    And I validate all the fields in the Contract Summary section on the contracts page as below
      | columnName                             | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Contract Title                         | true              | true            | 0         | 0            |
      | Framework for this Contract            | true              | true            | 0         | 2            |
      | Contract Type                          | true              | true            | 1         | 0            |
      | Framework Contract CORAL Log Ref (CLR) | true              | false           | 1         | 2            |
      | Account Name                           | true              | true            | 2         | 0            |
      | Original for this Contract             | true              | true            | 2         | 2            |
      | Account Site                           | true              | false           | 3         | 0            |
      | Original Contract CORAL Log Ref (CLR)  | true              | false           | 3         | 2            |
      | CCRT Link                              | false             | false           | 4         | 0            |
      | CORAL Log Ref                          | true              | true            | 4         | 2            |
      | Date Received by CAT                   | true              | true            | 5         | 0            |
      | CORAL Contract Image                   | true              | false           | 5         | 2            |
      | Contract Start Date                    | true              | true            | 6         | 0            |
      | Signature Status                       | false             | true            | 6         | 2            |
      | Contract Term (months)                 | false             | true            | 7         | 0            |
      | Customer Contracting Party             | true              | true            | 7         | 2            |
      | Original Contract Term                 | true              | true            | 8         | 0            |
      | Customer Signed By                     | true              | true            | 8         | 2            |
      | Contract End Date                      | false             | true            | 9         | 0            |
      | Customer Signed Date                   | true              | true            | 9         | 2            |
      | Contract Termination Date              | true              | true            | 10        | 0            |
      | Contract Products                      | true              | true            | 10        | 2            |
      | Expiration Date                        | true              | false           | 11        | 0            |
      | Parent Contract                        | true              | true            | 11        | 2            |
      | Contract Term (calculated months)      | false             | false           | 12        | 0            |
      | Master Contract                        | true              | true            | 12        | 2            |
      | Contract Term Remaining (in months)    | false             | false           | 13        | 0            |
      | Master Contract                        | false             | true            | 13        | 2            |
      | Option Expiry Date                     | true              | true            | 14        | 0            |
      |                                        | false             | false           | 14        | 2            |
      | Perpetual Framework                    | true              | true            | 15        | 0            |
      |                                        | false             | false           | 15        | 2            |
      | Perpetual Licence                      | true              | true            | 16        | 0            |
      |                                        | false             | false           | 16        | 2            |
      | Auto-Renewal                           | false             | true            | 17        | 0            |
      |                                        | false             | false           | 17        | 2            |
      | Customer Signed By - Image Extract     | true              | true            | 18        | 0            |
    And I validate all the fields in the Sync Subscriptions section on the contracts page as below
      | columnName          | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Fixed Billing Day   | true              | true            | 0         | 0            |
      | Billing Frequency   | true              | true            | 0         | 2            |
      | Fixed Billing Month | true              | true            | 1         | 0            |
      |                     | false             | false           | 1         | 2            |
    And I validate all the fields in the Billing Information section on the contracts page as below
      | columnName                    | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | RF Start Terms                | true              | true            | 0         | 0            |
      | Bill To                       | false             | true            | 0         | 2            |
      | Recurring Payment Holiday     | true              | true            | 1         | 0            |
      | NS Customer Address           | false             | true            | 1         | 2            |
      | RF Start Planned              | true              | true            | 2         | 0            |
      | Ship To                       | false             | true            | 2         | 2            |
      | Next CPI Uplift Date          | false             | false           | 3         | 0            |
      | NS Customer "Ship-To" Address | false             | true            | 3         | 2            |
      |                               | false             | false           | 4         | 0            |
      |                               | false             | false           | 4         | 2            |
    And I validate all the fields in the CPI Uplift section on the contracts page as below
      | columnName                             | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | CPI Uplift                             | false             | true            | 0         | 0            |
      | RF Notification for Rate Change (days) | true              | true            | 0         | 2            |
      | Skip Uplift                            | false             | true            | 1         | 0            |
      |                                        | false             | fals            | 1         | 2            |
    And I validate all the fields in the legacy Misys NS RB fields section on the contracts page as below
      | columnName              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | RF Index                | true              | true            | 0         | 0            |
      | RF Earliest Review Date | false             | true            | 0         | 2            |
      | RF +/- %                | true              | true            | 1         | 0            |
      | RF Review Month         | true              | true            | 1         | 2            |
      | RF Index Type           | false             | true            | 2         | 0            |
      | RF Billing Cycle        | true              | true            | 2         | 2            |
      | RF Rate Increase Min %  | false             | true            | 3         | 0            |
      | Bill from Existing BG   | false             | true            | 3         | 2            |
      | RF Rate Increase Max %  | true              | true            | 4         | 0            |
      |                         | false             | false           | 4         | 2            |
    And I validate all the fields in the Contract Obligations/Entitlement section on the contracts page as below
      | columnName          | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Delivery Date       | true              | true            | 0         | 0            |
      | SLA Environment     | true              | true            | 0         | 2            |
      |                     | false             | false           | 1         | 0            |
      | Response SLA        | true              | true            | 1         | 2            |
      |                     | false             | false           | 2         | 0            |
      | Response SLA Detail | true              | true            | 2         | 2            |
    And I validate all the fields in the Legal and Risk section on the contracts page as below
      | columnName                       | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Audit Permitted                  | true              | true            | 0         | 0            |
      | Standard Termination             | true              | true            | 0         | 2            |
      | Governing Law                    | true              | true            | 1         | 0            |
      | Non-Standard Termination Notice  | true              | true            | 1         | 2            |
      | Assignment without Consent       | true              | true            | 2         | 0            |
      | Standard Warranty                | true              | true            | 2         | 2            |
      | Source Code Protected            | true              | true            | 3         | 0            |
      | Warranty Period                  | true              | true            | 3         | 2            |
      | IP rights to Derivative Works    | true              | true            | 4         | 0            |
      | Standard Indemnity               | true              | true            | 4         | 2            |
      | WIP Log No                       | true              | true            | 5         | 0            |
      | Standard Limitation of Liability | true              | true            | 5         | 2            |
    And I validate all the fields in the Contract Scoring section on the contracts page as below
      | columnName             | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Letter Aggregate Score | false             | false           | 0         | 0            |
      | Letter Grade           | false             | false           | 0         | 2            |
      | Number Aggregate Score | false             | false           | 1         | 0            |
      | Number Score           | false             | false           | 1         | 2            |
      |                        | false             | false           | 2         | 0            |
      |                        | false             | false           | 2         | 2            |
      |                        | false             | false           | 3         | 0            |
      | Contract Score         | true              | true            | 3         | 2            |
    And I validate all the fields in the Salesforce CPQ Information section on the contracts page as below
      | columnName                         | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Renewal Opportunity                | true              | true            | 0         | 0            |
      | Default Renewal Contact Roles      | true              | true            | 0         | 2            |
      | Renewal Opportunity Record Type Id | true              | true            | 1         | 0            |
      | Default Renewal Partners           | true              | true            | 1         | 2            |
      | Renewal Opportunity Stage          | true              | true            | 2         | 0            |
      | Renewal Pricebook Id               | true              | true            | 2         | 2            |
      | Renewal Forecast                   | true              | true            | 3         | 0            |
      | Preserve Bundle Structure          | true              | true            | 3         | 2            |
      | Renewal Quoted                     | true              | true            | 4         | 0            |
      | Amendment & Renewal Behavior       | true              | true            | 4         | 2            |
      | Renewal Term                       | true              | true            | 5         | 0            |
      | MDQ Renewal Behavior               | true              | true            | 5         | 2            |
      |                                    | false             | false           | 6         | 0            |
      |                                    | false             | false           | 6         | 2            |
      |                                    | false             | false           | 7         | 0            |
      | Renewal Owner                      | true              | true            | 7         | 2            |
    And I validate all the fields in the Amendments section on the contracts page as below
      | columnName                           | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Amendment Start Date                 | true              | true            | 0         | 0            |
      | Amendment Pricebook Id               | true              | true            | 0         | 2            |
      | Amendment Opportunity Stage          | true              | true            | 1         | 0            |
      | Disable Amendment Co-Term            | true              | true            | 1         | 2            |
      | Amendment Opportunity Record Type Id | true              | true            | 2         | 0            |
      | Amendment Owner                      | true              | true            | 2         | 2            |
