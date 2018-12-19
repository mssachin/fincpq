Feature:  Validate CAT Profile
  As a Billing user
  I should have access to Objects and fields
  In order to billing functions


  @InDevProfilesBillingGroup
  Scenario: Test Scenario
    Given I have launched salesforce test sandbox url
    And I have logged in to salesforce as the below user
      | username | sachin.mylavarapu@finastra.com.sit.mbra |
      | password | Finastra!23                             |
      | profile  | M B&RA profile + CS Sys Admin           |
    Given I search for a record of below id and type
      | key | BG0030211 |
    And I drill down on the record to be navigated to its details
    And I validate all the fields in the Customer Details section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | BG Client Contracting Name              | true              | true            | 0         | 0            |
      | BG Billing Group Name                   | false             | false           | 0         | 2            |
      | BG Client Contracting Site              | false             | false           | 1         | 0            |
      | 18CharId                                | false             | false           | 1         | 2            |
      | BG Account 18chr Id                     | false             | false           | 2         | 0            |
      | BG Annual Maintenance                   | false             | true            | 2         | 2            |
      | Acct PO Required                        | true              | false           | 3         | 0            |
      | NS Currency                             | false             | false           | 3         | 2            |
      | BG Annual Increase rate from H/O        | true              | true            | 4         | 0            |
      | BG Billing Group Owner                  | true              | true            | 4         | 2            |
      | Billing - RLF Early Payer               | true              | false           | 5         | 0            |
      | BG Billing Group Active                 | true              | true            | 5         | 2            |
      | Billing - RLF Invoice in Service Period | true              | false           | 6         | 0            |
      | Milestone Billing                       | true              | true            | 6         | 2            |
      | Billing - Special Handling              | true              | false           | 7         | 0            |
      | BG Product (text)                       | true              | true            | 7         | 2            |
      | Transaction Late                        | true              | true            | 8         | 0            |
      |                                         | false             | false           | 8         | 2            |
      | SO On Hold Since                        | true              | true            | 9         | 0            |
      |                                         | false             | false           | 9         | 2            |
      | BG Additional Billing Reference         | true              | true            | 10        | 0            |
      | BG Comments                             | true              | true            | 11        | 0            |
      | Recurring Batch Error Logs              | false             | true            | 12        | 0            |
#     | Description                             | true              | true            | 19        | 0            |
#     | Terms - Image Extract                   | true              | true            | 20        | 0            |
    And I validate all the fields in the Customer CCRT Details on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | BG Client Contracting CCRT              | false             | false           | 0         | 0            |
      | BG Client Contracting CSN               | false             | false           | 0         | 2            |
      | BG Client Contracting TCode             | false             | false           | 1         | 0            |
      | BG Client Contracting CFN               | false             | false           | 1         | 2            |
    And I validate all the fields in the BG Original Source Data section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Original Opportunity                    | false             | true            | 0         | 0            |
      | Original Contract                       | false             | true            | 0         | 2            |
      | Original Opportunity Number             | false             | false           | 1         | 0            |
      | Original Contract Expiry Date           | false             | true            | 1         | 2            |
      | Original Opportunity Close Date         | false             | false           | 2         | 0            |
      | Indeterminate End Date                  | true              | true            | 2         | 2            |
      | ARCR                                    | true              | true            | 3         | 0            |
      | Contract Expiry Dates Match             | true              | false           | 3         | 2            |
    And I validate all the fields in the Sync Subscriptions section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Fixed Billing Day                       | true              | true            | 0         | 0            |
      | Billing Type                            | true              | true            | 0         | 2            |
      | Fixed Billing Month                     | true              | true            | 1         | 0            |
      | SO Advance Day                          | true              | true            | 1         | 2            |
      | Billing Frequency                       | true              | true            | 2         | 0            |
      | Next SO generation Date                 | true              | true            | 2         | 2            |
      | Earliest Next Billing Date              | true              | true            | 3         | 0            |
      |                                         | false             | false           | 3         | 2            |
    And I validate all the fields in the Hold Billing section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Hold Billing                            | false             | true            | 0         | 0            |
      | Hold Billing Review Date                | false             | true            | 1         | 0            |
      | Hold Billing Reason                     | false             | true            | 2         | 0            |
      | Hold Reason Detail                      | false             | true            | 3         | 0            |
    And I validate all the fields in the Billing Information section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | BG Misys Entity                         | true              | true            | 0         | 0            |
      | BG Client 'Bill To'                     | true              | true            | 0         | 2            |
      | BG Finastra Entity Currency             | false             | false           | 1         | 0            |
      | NS Customer Address                     | true              | true            | 1         | 2            |
      | Account By Sub                          | true              | true            | 2         | 0            |
      | NS Customer Address/Sub Label           | false             | false           | 2         | 2            |
      | Set Tax Combo Override                  | true              | true            | 3         | 0            |
      | BG Client Bill-to Country               | false             | false           | 3         | 2            |
      | Customer PO Number                      | true              | true            | 4         | 0            |
      | Is Default Billing Address              | false             | false           | 4         | 2            |
      | Auto Process                            | false             | true            | 5         | 0            |
      | BG Client "Ship-To"                     | false             | true            | 5         | 2            |
      | Last Invoice Date                       | false             | true            | 6         | 0            |
      | NS Customer "Ship-To" Address           | false             | true            | 6         | 2            |
      |                                         | false             | false           | 7         | 0            |
      | Contract Memo                           | true              | false           | 7         | 2            |
      |                                         | false             | false           | 8         | 0            |
      | NS Specific Invoice Wording             | false             | true            | 8         | 2            |
      |                                         | false             | false           | 9         | 0            |
      | SO End Date                             | false             | true            | 9         | 2            |
    And I validate all the fields in the Legacy Misys NS RB fields section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Sales Order Start Date                  | true              | true            | 0         | 0            |
      | NS Subscription Memo                    | false             | true            | 0         | 2            |
      | NS Subscription Start Date              | true              | true            | 1         | 0            |
      | Initial RLF Package Created             | false             | true            | 1         | 2            |
      | Fixed Billing Date                      | true              | true            | 2         | 0            |
      | Reseed Subscription                     | false             | true            | 2         | 2            |
      | NS Subscription Term                    | true              | true            | 3         | 0            |
      | Reseed RLF Package Created              | false             | true            | 3         | 2            |
      | NS Subscription Minimum Term            | true              | true            | 4         | 0            |
      | Subscription Plan Base Key              | true              | false           | 4         | 2            |
      | NS Subscription Notice Period           | true              | true            | 5         | 0            |
      | NS Subscription Billing Method          | true              | true            | 5         | 2            |
      | Invoices per year                       | true              | false           | 6         | 0            |
      | NS Rating Frequency (Billing Period)    | true              | true            | 6         | 2            |
      | Reset Next Bill Date                    | true              | true            | 7         | 0            |
      | NS Billing Frequency                    | true              | true            | 7         | 2            |
      | BG Next Invoice Due Date                | true              | true            | 8         | 0            |
      | Bulk COs                                | false             | true            | 8         | 2            |
      |                                         | false             | false           | 9         | 0            |
      | Type of increase                        | true              | true            | 9         | 2            |
    And I validate all the fields in the Take-on Information fields section on the Billing Group page as below
      | columnName                              | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | BG Opportunity Number(s) (migration)    | true              | true            | 0         | 0            |
      | BG Coral Log Ref(s) (migration)         | true              | true            | 0         | 2            |
      | BG Contract Date (migration)            | true              | true            | 1         | 0            |
      | BG CLR Status AMB/Unbilled (migration)  | true              | true            | 1         | 2            |
      | BG Misys Billing Entity (migration)     | true              | true            | 2         | 0            |
      | BG CLR Status Coral (migration)         | true              | true            | 2         | 2            |
      | BG Revenue Stream (migration)           | true              | true            | 3         | 0            |
      | BG CLR Status RMS (migration)           | true              | true            | 3         | 2            |
      | BG Debtor Name (migration)              | true              | true            | 4         | 0            |
      | BG Bill Sync locked                     | true              | true            | 4         | 2            |
      | BG Debtor Code (migration)              | true              | true            | 5         | 0            |
      | BG Bill sync date                       | true              | true            | 5         | 2            |
      | BG Client Contracting CSN (migration)   | true              | true            | 6         | 0            |
      | BG Contracted Recurring Fees (migration)| true              | true            | 6         | 2            |
      | BG Client 'Bill To' (migration)         | true              | true            | 7         | 0            |
      | BG Contractual Royalties (migration)    | true              | true            | 7         | 2            |
      | BG Clarity PrjID (migration)            | true              | true            | 8         | 0            |
      | BG Contracted RF Amount RMS (migration) | true              | true            | 8         | 2            |
      | BG Product as per contract (migration)  | true              | true            | 9         | 0            |
      |                                         | false             | false           | 9         | 2            |
      | BG Product as per AMB (migration)       | true              | true            | 10        | 0            |
      | BG Clarity PRJ Entry                    | false             | true            | 10        | 2            |
      |                                         | false             | false           | 11        | 0            |
      | BG Clarity Project Name                 | false             | false           | 11        | 2            |