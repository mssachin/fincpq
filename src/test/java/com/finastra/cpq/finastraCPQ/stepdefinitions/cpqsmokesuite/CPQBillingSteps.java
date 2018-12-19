package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqsmokesuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSalesOrdersAssociatedToABillingGroup;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSingleSalesOrderDetailsJsonResponse;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSingleSubscriptionDetailsJsonResponse;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSubscriptionsAssociatedToABillingGroup;
import com.finastra.cpq.finastraCPQ.pageobjects.apiresponseobjects.SFRubixAPIResponseObjects;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.*;
import com.finastra.cpq.finastraCPQ.utilities.AssertionUtilities;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import com.finastra.cpq.finastraCPQ.utilities.UtilityMethods;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CPQBillingSteps {

    private final String dateToday = UtilityMethods.returnDateTodayAsString();
    @Autowired
    SFRubixAPIResponseObjects sfRubixAPIResponseObjects;


    @Autowired
    private SFHomePageClassic sfHomePageClassic;

    @Autowired
    private SFRecordSearchResultsPageClassic sfRecordSearchResultsPageClassic;

    @Autowired
    private SFSubscriptionDetailsPageClassic sfSubscriptionDetailsPageClassic;

    @Autowired
    private SFSubscriptionEditPageClassic sfSubscriptionEditPageClassic;

    @Autowired
    private SFGlobalHeaderBarClassic sfGlobalHeaderBarClassic;

    @Autowired
    private SFBillingGroupDetailsPageClassic sfBillingGroupDetailsPageClassic;

    @Autowired
    private SFSalesOrderRelatedListPageOnBGClassic sfSalesOrderRelatedListPageOnBGClassic;
    private Object objectReturnedOnBillingGroup;
    private SFSubscriptionsAssociatedToABillingGroup sfSubscriptionsAssociatedToABillingGroup;

    private SFSalesOrdersAssociatedToABillingGroup sfSalesOrdersAssociatedToABillingGroup;

    private String recordId;
    private String subscriptionRecordIdNew;
    private Integer initialSalesOrderCountBeforeCreatingRLF;
    private Integer salesOrdersNumberAfterCreatingARLF;
    private String expectedNextSOGenerationDateOnBillingGroup;
    private String expectedNextBillingDateOnBillingGroup;
    private String scenarioBillingType;
    private String scenarioBillingFrequency;
    private String scenarioSOAdvance;
    private String currentNextBillingDateOnSubscription;
    private Double currentNetPriceOnSubscription;

    @Given("^I search for a record of below id and type$")
    public void i_search_for_a_record_of_below_id_and_type(DataTable recordIdTable) throws Throwable {
        Map<String, String> recordIdMap = recordIdTable.asMap(String.class, String.class);
        recordId = recordIdMap.get("key");
        sfHomePageClassic.searchForARecordBasedOnId(recordId);
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName() + " " + recordId);

    }

    @Given("^I drill down on the record to be navigated to its details$")
    public void i_drill_down_on_the_record_to_be_navigated_to_its_details() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfRecordSearchResultsPageClassic.navigateToRecordDetailsPage(recordId);
    }

    @Given("^I clone the subscription and enter date today in the Next SO Generation Date field$")
    public void i_clone_the_subscription_and_enter_todays_date_in_the_Next_SO_Generation_Date_field() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfSubscriptionDetailsPageClassic.cloneSubscriptionRecord();
        sfSubscriptionEditPageClassic.setNextBillingDateToTodaysDate();
        sfSubscriptionEditPageClassic.setNextSOGenerationDateToTodaysDate();
    }

    @Given("^I save my changes$")
    public void i_save_my_changes() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfSubscriptionEditPageClassic.saveChangesToSubscription();
    }

    @Given("^I record the subscription id create from above$")
    public void i_record_the_subscription_id_create_from_above() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        subscriptionRecordIdNew = sfSubscriptionDetailsPageClassic.extractSubscriptionId();
    }

    @Given("^I logout of the application$")
    public void i_logout_of_the_application() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfGlobalHeaderBarClassic.logoutOfSalesForce();
    }

    @Given("^I get the initial count of sales orders on billing group$")
    public void i_get_the_initial_count_of_sales_orders_on_billing_group() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        initialSalesOrderCountBeforeCreatingRLF = sfSalesOrdersAssociatedToABillingGroup.getTotalSize();
    }

    @Given("^I navigate back to billing group$")
    public void i_navigate_back_to_billing_group() throws Throwable {
        if (!(objectReturnedOnBillingGroup instanceof Integer)) {
            Hooks.getCurrentScenario().createNode(And.class, new Object() {
            }.getClass().getEnclosingMethod().getName());
            sfSalesOrderRelatedListPageOnBGClassic.navigateBackToBillingGroup();
        }
    }


    @Given("^I click on Create RLF button$")
    public void i_click_on_Create_RLF_button() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfBillingGroupDetailsPageClassic.createRLFForTheBillingGroup();
    }

    @Given("^I navigate to all sales order list on the billing group$")
    public void i_navigate_to_all_sales_order_list_on_the_billing_group() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        objectReturnedOnBillingGroup = sfBillingGroupDetailsPageClassic.navigateToSalesOrderListOnBG();

    }

    @Given("^I validate that the sales order count is increased by one$")
    public void i_validate_that_the_sales_order_count_is_increased_by() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        salesOrdersNumberAfterCreatingARLF = sfSalesOrdersAssociatedToABillingGroup.getTotalSize();
        AssertionUtilities.assertIntEquals(initialSalesOrderCountBeforeCreatingRLF + 1, salesOrdersNumberAfterCreatingARLF, currentStep);
    }


    @Given("^I search for a subscripting record created from above and drilldown$")
    public void i_search_for_a_subscripting_record_created_from_above_and_drilldown() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfHomePageClassic.searchForARecordBasedOnId(subscriptionRecordIdNew);
        sfRecordSearchResultsPageClassic.navigateToRecordDetailsPage(subscriptionRecordIdNew);

    }

    @Given("^I validate that Next SO Generation Date on the subscription record$")
    public void i_validate_that_Next_SO_Generation_Date_on_the_subscription_record() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String expectedNextSOGenerationDateOnSubscription = calculateNextSOGenerationDateOnSubscription(scenarioBillingType, scenarioSOAdvance, currentNextBillingDateOnSubscription, scenarioBillingFrequency);
        String actualNextSOGenerationDateOnSubscription = sfSubscriptionDetailsPageClassic.getNextSOGenerationDateValueOnSubscription();
        AssertionUtilities.assertStringEquals(expectedNextSOGenerationDateOnSubscription, actualNextSOGenerationDateOnSubscription, currentStep, sfSubscriptionDetailsPageClassic.captureBillingInformationSection());

    }

    @Given("^I validate the Next Billing Date on the subscription record$")
    public void i_validate_the_Next_Billing_Date_on_the_subscription_record() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String expectedNextBillingDateOnSubscription = calculateNextBillingDateBasedOnBillingFrequency(scenarioBillingFrequency, currentNextBillingDateOnSubscription);
        String actualNextBillingDateOnSubscription = sfSubscriptionDetailsPageClassic.getNextBillingDateValueOnSubscription();
        AssertionUtilities.assertStringEquals(expectedNextBillingDateOnSubscription, actualNextBillingDateOnSubscription, currentStep, sfSubscriptionDetailsPageClassic.captureBillingInformationSection());
    }

    @Given("^I validate that Next SO Generation Date on the billing group record$")
    public void i_validate_that_Next_SO_Generation_Date_on_the_billing_group_record() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String actualNextSOGenerationDateOnBillingGroup = sfBillingGroupDetailsPageClassic.getNextSOGenerationDateValueOnBillingGroup();
        AssertionUtilities.assertStringEquals(expectedNextSOGenerationDateOnBillingGroup, actualNextSOGenerationDateOnBillingGroup, currentStep, sfBillingGroupDetailsPageClassic.captureSyncSubscriptionSection());
    }

    @Given("^I validate the Next Billing Date on the billing group record$")
    public void i_validate_the_Next_Billing_Date_on_the_billing_group_record() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String actualNextBillingDateOnBillingGroup = sfBillingGroupDetailsPageClassic.getEarliestBillingDateValueOnBillingGroup();
        AssertionUtilities.assertStringEquals(expectedNextBillingDateOnBillingGroup, actualNextBillingDateOnBillingGroup, currentStep, sfBillingGroupDetailsPageClassic.captureSyncSubscriptionSection());
    }

    @Given("^I set the Billing Type on subscription to a \"([^\"]*)\"$")
    public void i_set_the_Billing_Type_on_subscription_to_a(String billingType) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        scenarioBillingType = billingType;
        sfSubscriptionDetailsPageClassic.selectBillingType(billingType);

    }

    @Given("^I set the Billing Frequency on subscription to a \"([^\"]*)\"$")
    public void i_set_the_Billing_Frequency_on_subscription_to_a(String billingFrequency) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        scenarioBillingFrequency = billingFrequency;
        sfSubscriptionDetailsPageClassic.selectBillingFrequency(billingFrequency);
    }

    @Given("^I set the SO Generation Advance field on subscription to a \"([^\"]*)\"$")
    public void i_set_the_so_generation_advance_field_on_subscription_to_a(String soAdvance) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        scenarioSOAdvance = soAdvance;
        sfSubscriptionDetailsPageClassic.populateSOGenerationAdvanceField(soAdvance);
    }

    @Given("^I set the Next SO Generation Date on the Billing Group to date today$")
    public void i_set_the_Next_SO_Generation_Date_on_the_Billing_Group_to_date_today() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfBillingGroupDetailsPageClassic.populateNextSOGenerationDateToAValue(dateToday);
    }

    @Given("^I set the Earliest Next Billing Date on the Billing Group to date today$")
    public void i_set_the_Earliest_Next_Billing_Date_on_the_Billing_Group_to_date_today() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfBillingGroupDetailsPageClassic.populateEarliestNextBillingDateToAValue(dateToday);
    }


    @Given("^I query for all the subscription records associated to a billing group$")
    public void i_query_for_all_the_subscription_records_associated_to_a_billing_group(DataTable recordIdAndChildQueryTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> recordIdAndQueryAsMap = recordIdAndChildQueryTable.asMap(String.class, String.class);
        String recordId = recordIdAndQueryAsMap.get("parentRecordId");
        String query = recordIdAndQueryAsMap.get("query");
        sfSubscriptionsAssociatedToABillingGroup = sfRubixAPIResponseObjects.getSubscriptionsAssociatedToABillingGroup(recordId, query);
    }

    @Given("^I set the Next SO Generation Date on Subscription to Date Today$")
    public void i_set_the_Next_SO_Generation_Date_on_Subscription_to_Date_Today() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfSubscriptionDetailsPageClassic.populateNextSOGenerationDateOnSubscription(dateToday);
    }

    @Given("^I set the Billing Date on Subscription to Date Today$")
    public void i_set_the_Billing_Date_on_Subscription_to_Date_Today() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfSubscriptionDetailsPageClassic.populateNextBillingDateOnSubscription(dateToday);
        currentNextBillingDateOnSubscription = dateToday;
    }


    @Given("^I capture the earliest Next SO Generation  Date from all Subscription records$")
    public void i_capture_the_earliest_Next_SO_Generation_Date_from_all_Subscription_records() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<Date> nextSOGenerationDatesOnBG = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SFSingleSubscriptionDetailsJsonResponse[] allSubscriptionsOnBG = sfSubscriptionsAssociatedToABillingGroup.getRecords();
        for (SFSingleSubscriptionDetailsJsonResponse singleSubscriptionDetailsJsonResponse : allSubscriptionsOnBG) {
            if (!singleSubscriptionDetailsJsonResponse.getRecurringNSItem().equals("") && singleSubscriptionDetailsJsonResponse.getRecurringSalesOrderType().contains("RLF")) {
                String nextSOGenerationDateAsString = singleSubscriptionDetailsJsonResponse.getNextSOGenerationDate();
                if (!(nextSOGenerationDateAsString.equals(""))) {
                    Date nextSOGenerationDate = sdf.parse(nextSOGenerationDateAsString);
                    nextSOGenerationDatesOnBG.add(nextSOGenerationDate);
                }
            }

        }

        Collections.sort(nextSOGenerationDatesOnBG);
        SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
        expectedNextSOGenerationDateOnBillingGroup = sdfNew.format(nextSOGenerationDatesOnBG.get(0));

    }

    @Given("^I capture the earliest Next Billing Date from all Subscription records$")
    public void i_capture_the_earliest_Next_Billing_Date_from_all_Subscription_records() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<Date> nextBillingDatesOnBG = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SFSingleSubscriptionDetailsJsonResponse[] allSubscriptionsOnBG = sfSubscriptionsAssociatedToABillingGroup.getRecords();
        for (SFSingleSubscriptionDetailsJsonResponse singleSubscriptionDetailsJsonResponse : allSubscriptionsOnBG) {
            String nextBillingDateAsString = singleSubscriptionDetailsJsonResponse.getNextBillingDate();
            if (!(nextBillingDateAsString.equals("")) && !singleSubscriptionDetailsJsonResponse.getRecurringNSItem().equals("") && singleSubscriptionDetailsJsonResponse.getRecurringSalesOrderType().contains("RLF")) {
                Date nextBillingDate = sdf.parse(nextBillingDateAsString);
                nextBillingDatesOnBG.add(nextBillingDate);
            }

        }
        Collections.sort(nextBillingDatesOnBG);
        SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
        expectedNextBillingDateOnBillingGroup = sdfNew.format(nextBillingDatesOnBG.get(0));
    }


    @Given("^I query for all the sales orders associated to a billing group$")
    public void i_query_for_all_the_sales_orders_associated_to_a_billing_group(DataTable recordIdAndChildQueryTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> recordIdAndQueryAsMap = recordIdAndChildQueryTable.asMap(String.class, String.class);
        String recordId = recordIdAndQueryAsMap.get("parentRecordId");
        String query = recordIdAndQueryAsMap.get("query");
        sfSalesOrdersAssociatedToABillingGroup = sfRubixAPIResponseObjects.getSalesOrdersAssociatedToABillingGroup(recordId, query);

    }

    @Given("^I capture the current net amount on the Subscription$")
    public void i_capture_the_current_net_amount_on_the_Subscription() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String netPriceBeforeUpliftAsString = sfSubscriptionDetailsPageClassic.getCurrentNetPriceOnSubscription();
        currentNetPriceOnSubscription = Double.parseDouble(netPriceBeforeUpliftAsString);

    }


    @Given("^I validate the amount on the Sales Order to match with the amount on subscription$")
    public void i_validate_the_amount_on_the_Sales_Order_to_match_with_the_amount_on_subscription() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        SFSingleSalesOrderDetailsJsonResponse[] allSalesOrder = sfSalesOrdersAssociatedToABillingGroup.getRecords();
        Double salesOrderAmount = (double) allSalesOrder[0].getTotalAmount();
        AssertionUtilities.assertDoubleEquals(currentNetPriceOnSubscription, salesOrderAmount, currentStep, "");
    }


    private String calculateNextSOGenerationDateOnSubscription(String billingType, String soGenerationAdvance, String currentNextBillingDate, String billingFrequency) throws ParseException {
        String nextSOGenerationDateToReturn = null;
        Long soGenerationAdvanceAsLong = Long.parseLong(soGenerationAdvance);
        String calculatedNextBillingDate = calculateNextBillingDateBasedOnBillingFrequency(billingFrequency, currentNextBillingDate);

        if (billingType.equalsIgnoreCase("Arrears")) {
            nextSOGenerationDateToReturn = UtilityMethods.addDaysFromAGivenDate(calculatedNextBillingDate, soGenerationAdvanceAsLong);
        } else if (billingType.equalsIgnoreCase("Advance")) {
            nextSOGenerationDateToReturn = UtilityMethods.subtractDaysFromAGivenDate(calculatedNextBillingDate, soGenerationAdvanceAsLong);

        }

        return nextSOGenerationDateToReturn;
    }

    private String calculateNextBillingDateBasedOnBillingFrequency(String billingFrequency, String currentNextBillingDate) throws ParseException {
        String nextBillingDateToReturn;

        switch (billingFrequency) {
            case "Monthly":
                nextBillingDateToReturn = UtilityMethods.addMonthsToAGivenDate(currentNextBillingDate, 1);
                break;
            case "Quarterly":
                nextBillingDateToReturn = UtilityMethods.addMonthsToAGivenDate(currentNextBillingDate, 3);
                break;
            case "Semiannual":
                nextBillingDateToReturn = UtilityMethods.addMonthsToAGivenDate(currentNextBillingDate, 6);
                break;
            case "Annual":
                nextBillingDateToReturn = UtilityMethods.addYearsToAGivenDate(currentNextBillingDate, 1);
                break;
            default:
                nextBillingDateToReturn = currentNextBillingDate;
                break;
        }

        return nextBillingDateToReturn;
    }


}
