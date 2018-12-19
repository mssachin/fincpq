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
      | key | SUB-0014240 |
    And I drill down on the record to be navigated to its details
    And I validate all the fields in the Subscription Detail section on the Subscriptions page as below
      | columnName                   | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Subscription #               | false             | false           | 0         | 0            |
      | 18CharID                     | false             | false           | 0         | 2            |
      | Asset                        | true              | true            | 1         | 0            |
      | Account                      | true              | true            | 1         | 2            |
      | Product                      | true              | false           | 2         | 0            |
      | Account Site                 | true              | true            | 2         | 2            |
      | Product Name                 | true              | false           | 3         | 0            |
      | Contract                     | true              | true            | 3         | 2            |
      | Product Name Override        | true              | false           | 4         | 0            |
      | Perpetual                    | true              | true            | 4         | 2            |
      | PPOPPLINE_Concat             | true              | false           | 5         | 0            |
      | Origin                       | true              | true            | 5         | 2            |
      | OpportunityLineItem          | true              | false           | 6         | 0            |
      | Fair Value                   | true              | true            | 6         | 2            |
      | LineItem Type                | false             | false           | 7         | 0            |
      | Net Price                    | false             | false           | 7         | 2            |
      | Quote Line                   | true              | false           | 8         | 0            |
      | Annual Maintenance           | true              | true            | 8         | 2            |
      | Opportunity Billing Schedule | true              | false           | 9         | 0            |
      | Remaining Maintenance Amount | true              | true            | 9         | 2            |
      | Initial Software Delivery    | true              | false           | 10        | 0            |
      | Create Add On ILF/RLF        | true              | false           | 11        | 0            |
      | Revenue Type                 | false             | true            | 12        | 0            |
      | Notes                        | false             | false           | 13        | 0            |


    And I validate all the fields in the threePP Details  section on the Subscriptions page as below
      | columnName                     | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Create 3PP Event               | true              | true            | 0         | 0            |
      | 3PP Discount                   | false             | true            | 0         | 2            |
      | 3PP Vendor                     | false             | false           | 1         | 0            |
      | 3PP Vendor BSch Trigger        | false             | true            | 2         | 0            |
      | 3PP Recurring Costs (deal ccy) | true              | false           | 2         | 2            |
      | 3PP Costs (deal ccy)           | true              | true            | 3         | 0            |
      | 3PP Currency (PO ccy)          | false             | true            | 4         | 0            |
      | 3PP Recurring Costs (PO ccy)   | true              | true            | 4         | 2            |
      | 3PP Costs (PO ccy)             | true              | true            | 5         | 0            |
      | 3PP Legacy Coral Sales Ref     | false             | true            | 5         | 2            |
      | 3PP Asset Location             | false             | true            | 6         | 0            |
    And I validate all the fields in the Billing Information section on the Subscriptions page as below
      | columnName               | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Billing Group            | false             | true            | 0         | 0            |
      | RF Start Planned Date    | true              | true            | 0         | 2            |
      | Billing Status           | false             | true            | 1         | 0            |
      | RF Waiver Months         | false             | false           | 1         | 2            |
      | Billing Type             | true              | true            | 2         | 0            |
      | Last Billed Date         | false             | true            | 2         | 2            |
      | Billing Frequency        | true              | true            | 3         | 0            |
      | Next Billing Date        | false             | true            | 3         | 2            |
      | Fixed Billing Day        | false             | true            | 4         | 0            |
      | SO Generation Advance    | true              | false           | 4         | 2            |
      | Fixed Billing Month      | false             | true            | 5         | 0            |
      | Next SO generation Date  | false             | true            | 5         | 2            |
      | CPI Uplift               | false             | true            | 6         | 0            |
      | CPI Uplift Factor        | true              | true            | 7         | 0            |
      | Last Pro rata Required   | false             | false           | 7         | 2            |
      | Pro rata Days            | false             | true            | 8         | 0            |
      | Last Pro rata Calculated | false             | true            | 8         | 2            |
      | Pro rata Calculated      | false             | true            | 9         | 0            |

    And I validate all the fields in the Tax Determination section on the Subscriptions page as below
      | columnName             | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Recurring Delivery     | true              | false           | 0         | 0            |
      | Mandatory              | true              | false           | 0         | 2            |
      | Recurring Revenue Type | true              | true            | 1         | 0            |
      | Qualified Licence      | true              | false           | 1         | 2            |
      | One Time Delivery      | true              | true            | 2         | 0            |
      | Ship From Code         | true              | false           | 3         | 0            |

    And I validate all the fields in the Product Details section on the Subscriptions page as below
      | columnName                 | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Sales Product Set          | false             | true            | 0         | 0            |
      | SKU Group                  | false             | true            | 0         | 2            |
      | ProductSet Process Type    | false             | true            | 1         | 0            |
      | Fair Value Adjustment Item | false             | true            | 1         | 2            |
      | LineItem Process Type      | false             | true            | 2         | 0            |
      | Pearl Item                 | false             | false           | 2         | 2            |
      | Product Family             | false             | false           | 3         | 0            |
      | Transactional              | false             | true            | 3         | 2            |
      | Revenue Family             | false             | true            | 4         | 0            |
      | Varied Licence             | false             | true            | 4         | 2            |
      | Product PCID               | false             | true            | 5         | 0            |
      | Product Release            | false             | true            | 5         | 2            |
      | Asset Product GA           | false             | true            | 6         | 0            |


    And I validate all the fields in the Subscription Values section on the Subscriptions page as below
      | columnName                      | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Contract #                      | true              | false           | 0         | 0            |
      | Quantity                        | true              | true            | 0         | 2            |
      | Original Contract               | true              | true            | 1         | 0            |
      | Quantity Description            | false             | true            | 1         | 2            |
      | Transactions                    | true              | true            | 2         | 2            |
      | Start Date                      | true              | false           | 3         | 0            |
      | Minimum Transactions            | true              | true            | 3         | 2            |
      | End Date                        | true              | true            | 4         | 0            |
      | Maximum Transactions            | true              | true            | 4         | 2            |
      | Expiry Date                     | false             | false           | 5         | 0            |
      | Pricing Scheme                  | false             | true            | 5         | 2            |
      | Term Begin Date                 | false             | true            | 6         | 0            |
      | Term End Date                   | false             | true            | 7         | 0            |
      | Amended Subscription            | false             | true            | 7         | 2            |
      | Term                            | false             | false           | 8         | 0            |
      | Previously Cancelled            | false             | true            | 8         | 2            |
      | Expired Subscription            | true              | false           | 10        | 0            |
      | Previous Asset under Management | false             | false           | 10        | 2            |
      | Asset under management          | false             | false           | 11        | 2            |


    And I validate all the fields in the User Levels section on the Subscriptions  page as below
      | columnName               | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Location                 | false             | true            | 0         | 0            |
      | Licence Metric Quantity  | false             | true            | 1         | 0            |
      | Licence_Band_Incremented | false             | true            | 1         | 2            |
      | License Metric           | false             | true            | 2         | 0            |
      | License Status           | false             | true            | 2         | 2            |
      | Licence Band             | false             | true            | 3         | 0            |
      | Licence Status Date      | false             | true            | 3         | 2            |


    And I validate all the fields in the Subscription Amounts section on the Subscriptions page as below
      | columnName                         | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Contracted Fair Value              | true              | true            | 0         | 0            |
      | Unrecoverable Costs                | true              | true            | 0         | 2            |
      | Upfront List Value                 | false             | false           | 1         | 0            |
      | Per Diem Contracted Value          | true              | true            | 1         | 2            |
      | List Value                         | false             | false           | 2         | 0            |
      | Per Diem List Value                | true              | true            | 2         | 2            |
      | RPA List Value                     | true              | true            | 3         | 0            |
      | Total Number Of Travel Hours       | true              | true            | 3         | 2            |
      | Discount / Premium                 | false             | true            | 4         | 0            |
      | Total Number Of Non Billable Hours | false             | true            | 4         | 2            |
      | Upfront Fair Value                 | false             | true            | 5         | 0            |
      | Total Number Of Contractor Hours   | false             | true            | 5         | 2            |
      | Upfront RPA Value                  | false             | true            | 6         | 0            |
      | Reimbursable Costs Estimate        | false             | true            | 6         | 2            |
      | Internal Costs                     | false             | true            | 7         | 0            |
      | Reimbursable Costs Recovery Value  | false             | true            | 7         | 2            |
      | Sold Per Diem Value                | false             | true            | 8         | 0            |
      | NS Deferred Revenue Account ID     | false             | true            | 8         | 2            |
      | Commissionable_Value               | false             | true            | 9         | 0            |
      | Pearl UPN                          | false             | true            | 9         | 2            |
      | Total Chargeable Hours             | false             | true            | 10        | 2            |
      | Original Annual Maintenance        | false             | true            | 11        | 0            |
      | Fair Value Adjustment              | false             | true            | 11        | 2            |


    And I validate all the fields in the Pricing Information section on the Subscriptions page as below
      | columnName                      | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Prorate Multiplier              | true              | true            | 0         | 0            |
      | List Price                      | true              | true            | 0         | 2            |
      | Additional Disc. (%)            | true              | true            | 1         | 0            |
      | Special Price                   | true              | true            | 1         | 2            |
      | Additional Disc. (Amt)          | true              | true            | 2         | 0            |
      | Customer Price                  | true              | true            | 2         | 2            |
      | Partner Discount                | true              | true            | 3         | 0            |
      | Regular Price                   | true              | true            | 3         | 2            |
      | Distributor Discount            | true              | true            | 4         | 0            |
      | Renewal Price                   | true              | true            | 4         | 2            |
      | Upfront Sold Discount from List | true              | true            | 5         | 0            |
      | Initial Sold Price              | true              | true            | 5         | 2            |
      | Initial List Price              | false             | true            | 6         | 2            |
      | Markup (%)                      | true              | false           | 7         | 0            |
      | Weighted RPA                    | false             | true            | 7         | 2            |
      | Markup (Amt)                    | true              | true            | 8         | 0            |
      | Unit Cost                       | true              | true            | 9         | 2            |

    And I validate all the fields in the Segment Information section on the Subscriptions page as below
      | columnName           | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Price Dimension      | true              | true            | 0         | 0            |
      | Segment Quantity     | true              | true            | 0         | 2            |
      | Segment Uplift       | true              | true            | 1         | 0            |
      | Segment Start Date   | true              | true            | 1         | 2            |
      | Dimension Type       | false             | false           | 2         | 0            |
      | Segment End Date     | true              | true            | 2         | 2            |
      | Segment Uplift (Amt) | true              | true            | 3         | 0            |
      | Initial SO Formula   | false             | false           | 3         | 2            |


    And I validate all the fields in the Support Information section on the Subscriptions page as below
      | columnName          | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Support Product Set | false             | true            | 0         | 0            |
      | Environment         | false             | true            | 0         | 2            |
      | Support Asset       | false             | true            | 1         | 0            |
      | Support SKU Group   | false             | true            | 1         | 2            |


    And I validate all the fields in the Termination section on the Subscriptions page as below
      | columnName      | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Terminated      | false             | false           | 0         | 0            |
      | Terminated Date | true              | true            | 0         | 2            |


    And I validate all the fields in the Data Migration and Legacy Information section on the Subscriptions page as below
      | columnName                  | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Contract Asset              | false             | true            | 0         | 0            |
      | Client Asset                | false             | true            | 0         | 2            |
      | Contract Asset Record Type  | false             | true            | 1         | 0            |
      | Contract Asset Status       | false             | true            | 2         | 0            |
      | Legacy Contract             | false             | true            | 2         | 2            |
      | Asset Source                | true              | true            | 3         | 0            |
      | Legacy External ID For Beam | false             | true            | 4         | 2            |
      | DM Source                   | false             | true            | 5         | 0            |
      | DM Unique Id                | false             | true            | 6         | 0            |

    And I validate all the fields in the NS Information section on the Subscriptions page as below
      | columnName                 | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Order Type                 | false             | true            | 0         | 0            |
      | Initial Delivery Type      | false             | true            | 0         | 2            |
      | NS Order Form Type         | false             | true            | 1         | 0            |
      | Initial Sovos Code         | false             | true            | 1         | 2            |
      | SO Grouping                | false             | false           | 2         | 0            |
      | Initial Sales Order Type   | false             | true            | 2         | 2            |
      | NS Item Name               | false             | true            | 3         | 0            |
      | Initial Revenue Type       | false             | true            | 3         | 2            |
      | Initial NS Item            | false             | true            | 4         | 0            |
      | Recurring Sovos Code       | false             | true            | 4         | 2            |
      | Recurring NS Item          | false             | true            | 5         | 0            |
      | Recurring Sales Order Type | false             | true            | 5         | 2            |

    And I validate all the fields in the System Information section on the Subscriptions page as below
      | columnName                      | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
      | Created By                      | false             | false           | 0         | 0            |
      | Initial UPID                    | false             | true            | 0         | 2            |
      | Owner                           | false             | false           | 1         | 0            |
      | Upfront UPID                    | false             | false           | 1         | 2            |
      | Last Modified By                | false             | false           | 2         | 0            |
      | Assets Created                  | false             | true            | 2         | 2            |
      | D+H Support Product Set GUID    | true              | true            | 3         | 0            |
      | Is Migrated                     | false             | true            | 3         | 2            |
      | D+H Support Product Group GUID  | true              | true            | 4         | 0            |
      | D+H Product Support Module GUID | true              | true            | 5         | 0            |
      | D+H Support Component Guid      | true              | true            | 6         | 0            |


   # And I validate all the fields in the Query - TO BE REMOVED OR DELETED section on the Subscriptions page as below
     # | columnName                        | isHelpTextPresent | isFieldEditable | rowNumber | columnNumber |
     # | xxx3PP Currency                   | false             | true            | 0         | 0            |
     # | Period End Date                   | false             | false           | 0         | 2            |
      #| xxx3PP Contractor Cost (deal ccy) | false             | true            | 1         | 0            |
      #| Start Trigger                     | false             | true            | 1         | 2            |
      #| Renewal Quantity                  | true              | true            | 2         | 0            |
      #| Exclude from Uplift               | false             | true            | 2         | 2            |
      #| Renewed Date                      | true              | true            | 3         | 0            |
      #| Renewal Uplift (%)                | true              | true            | 3         | 2            |
      #| Revised Subscription              | true              | true            | 3         | 2            |
      #| Bill To                           | false             | true            | 4         | 0            |
      #| Ship To                           | false             | true            | 5         | 0            |
      #| Uplift Earliest Review Date       | false             | true            | 6         | 0            |
      #| BG Next Billing Date              | false             | false           | 6         | 0            |