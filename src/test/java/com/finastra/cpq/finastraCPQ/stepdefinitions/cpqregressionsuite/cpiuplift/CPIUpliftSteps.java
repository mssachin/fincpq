package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqregressionsuite.cpiuplift;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.*;
import com.finastra.cpq.finastraCPQ.utilities.AssertionUtilities;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import com.finastra.cpq.finastraCPQ.utilities.UtilityMethods;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPIUpliftSteps {

    private final String dateToday = UtilityMethods.returnDateTodayAsString();
    private Double fairPriceOnSubscriptionBeforeUplift;
    private Double currentNetPriceOnSubscription;
    private Double actualUpliftFactorValueFromSF;
    private Double scenarioNetUnitPriceOnQuote;
    private Double scenarioInterimUpliftPercentage;
    private String scenarioBillingType;
    private String upliftAdvanceAsString;
    private String transactionalAttributeValue;
    private String scenarioBillingFrequency;
    private String scenarioUpliftStartDate;
    private String scenarioUpliftAnnualEffectiveDate;
    private String scenarioExpectedUpliftAnnualEffectiveDate;
    private String scenarioRunningUpliftCalcType;
    private String scenarioContractStartDate;
    private String annualEffectiveDateBeforeUplift;
    private String scenarioUpliftType;
    private List<String> quoteLineItemIdsForTransactionalSubscription = new ArrayList<>();
    private Map<String, Map<String, String>> quoteLineItemToPricesMapInitial = new HashMap();
    private Map<String, Map<String, String>> quoteLineItemToPricesMapPostUplift = new HashMap<>();
    private Double scenarioNetCustomerUpliftValue;

    @Autowired
    private SFQuoteItemDetailsPageClassic sfQuoteItemDetailsPageClassic;

    @Autowired
    private SFSubscriptionDetailsPageClassic sfSubscriptionDetailsPageClassic;

    @Autowired
    private SFCPIUpliftDetailsPageClassic sfcpiUpliftDetailsPageClassic;

    @Autowired
    private SFHomePageClassic sfHomePageClassic;

    @Autowired
    private SFRecordSearchResultsPageClassic sfRecordSearchResultsPageClassic;

    @Autowired
    private SFQuoteLineItemTransactionTierDetailsPageClassic sfQuoteLineItemTransactionTierDetailsPageClassic;

    @Autowired
    private SFContractDetailsPageClassic sfContractDetailsPageClassic;



    @Given("^I capture the current fair value on the Subscription$")
    public void i_capture_the_current_fair_value_on_the_Subscription() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        String fairValueBeforeUpliftAsString =sfSubscriptionDetailsPageClassic.getCurrentFairPriceOnSubscription();
        fairPriceOnSubscriptionBeforeUplift = Double.parseDouble(fairValueBeforeUpliftAsString);
        UtilityMethods.logInfoToAStep(currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails());
    }

    @Given("^I capture the current net price on the Subscription$")
    public void i_capture_the_current_net_price_on_the_Subscription() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        String netPriceBeforeUpliftAsString= sfSubscriptionDetailsPageClassic.getCurrentNetPriceOnSubscription();
        currentNetPriceOnSubscription = Double.parseDouble(netPriceBeforeUpliftAsString);

    }

    @Given("^I set the override field to a \"([^\"]*)\"$")
    public void i_set_the_override_field_to_a(String overrideFactor) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateOverrideFieldWithAFactor(overrideFactor);
    }

    @Given("^I capture the Uplift Factor$")
    public void i_capture_the_Uplift_Factor() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        String upliftFactorAsString = sfcpiUpliftDetailsPageClassic.extractUpliftFactor();
        actualUpliftFactorValueFromSF = Double.parseDouble(upliftFactorAsString);
    }

    @Given("^I set the Uplift Annual Effective Date to todays date$")
    public void i_set_the_Uplift_Annual_Effective_Date_to_todays_date() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftAnnualEffectiveDate(dateToday);
    }

    @Given("^I set the Uplift Application Date to todays date$")
    public void i_set_the_Uplift_Application_Date_to_todays_date() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftApplicationDate(dateToday);
    }

    @Given("^I set the Billing Type to a \"([^\"]*)\"$")
    public void i_set_the_Billing_Type_to_a(String billingType) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        scenarioBillingType = billingType;
        sfcpiUpliftDetailsPageClassic.selectBillingType(billingType);

    }

    @Given("^I set the Billing Frequency to a \"([^\"]*)\"$")
    public void i_set_the_Billing_Frequency_to_a_frequency(String billingFrequency) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        scenarioBillingFrequency = billingFrequency;
        sfcpiUpliftDetailsPageClassic.selectBillingFrequency(billingFrequency);
    }

    @Given("^I set the CPI Uplift Type to an \"([^\"]*)\"$")
    public void i_set_the_CPI_Uplift_Type_to_an(String upliftType) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.selectCPIUpliftType(upliftType);
        scenarioUpliftType = upliftType;
    }

    @Given("^I set the Uplift Calc Type to a \"([^\"]*)\"$")
    public void i_set_the_Uplift_Calc_Type_to_a(String upliftCalcType) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.selectUpliftCalcType(upliftCalcType);
    }

    @Given("^I set the Uplift Advance field to a \"([^\"]*)\"$")
    public void i_set_the_Uplift_Advance_field_to_a(String upliftAdvance) throws Throwable {
        upliftAdvanceAsString = upliftAdvance;
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftAdvance(upliftAdvance);

    }

    @Given("^I set the Hold Billing Flag to a \"([^\"]*)\"$")
    public void i_set_the_Hold_Billing_Flag_to_a(String holdBillingFlag) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        if(sfcpiUpliftDetailsPageClassic.getCurrentHoldBillingFlagValue("alt").equals("Not Checked")){
            sfcpiUpliftDetailsPageClassic.populateHoldBillingFlag();
        }else if(holdBillingFlag.equals(true)) {
            sfcpiUpliftDetailsPageClassic.populateHoldBillingFlag();
        }
        UtilityMethods.logInfoToAStep(currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());
    }

    @Given("^I click on Apply Uplift Button$")
    public void i_click_on_Apply_Uplift_Button() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.applyUpliftToAssociatedSubscriptions();
    }

    @Given("^I validate the new Uplift Annual Effective Date$")
    public void i_validate_the_new_Uplift_Annual_Effective_Date() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        scenarioExpectedUpliftAnnualEffectiveDate = calculateAndReturnExpectedAnnualEffectiveDate(annualEffectiveDateBeforeUplift);
        String actualUpliftAnnualEffectiveDate = sfcpiUpliftDetailsPageClassic.getCurrentUpliftAnnualEffectiveDate();
        AssertionUtilities.assertStringEquals(scenarioExpectedUpliftAnnualEffectiveDate, actualUpliftAnnualEffectiveDate, currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());
    }

    @Given("^I validate the new Uplift Application Date$")
    public void i_validate_the_new_Uplift_Application_Date() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        if(scenarioBillingType.equalsIgnoreCase("Advance")) {
            String expectedUpliftApplicationDate = UtilityMethods.subtractDaysFromAGivenDate(scenarioExpectedUpliftAnnualEffectiveDate, Long.parseLong(upliftAdvanceAsString));
            String actualUpliftApplicationDate = sfcpiUpliftDetailsPageClassic.getCurrentUpliftApplicationDate();
            AssertionUtilities.assertStringEquals(expectedUpliftApplicationDate, actualUpliftApplicationDate, currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());

        }else{
            String expectedUpliftApplicationDate = UtilityMethods.addDaysFromAGivenDate(scenarioExpectedUpliftAnnualEffectiveDate, Long.parseLong(upliftAdvanceAsString));
            String actualUpliftApplicationDate = sfcpiUpliftDetailsPageClassic.getCurrentUpliftApplicationDate();
            AssertionUtilities.assertStringEquals(expectedUpliftApplicationDate, actualUpliftApplicationDate, currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());


        }
    }

    @Then("^I validate that fair value on the subscription is uplifted by the uplift factor$")
    public void i_validate_that_fair_value_on_the_subscription_is_uplifted_by_the_uplift_factor() throws Throwable {
        int precision = 100;
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        UtilityMethods.logInfoToAStep(currentStep,sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails() );
        Double expectedFairValueOnStandardSubscriptionAsBD = Math.floor((fairPriceOnSubscriptionBeforeUplift * actualUpliftFactorValueFromSF) * precision + .5) / precision;
        Double actualFairValueOnStandardSubscription = Double.parseDouble(sfSubscriptionDetailsPageClassic.getCurrentFairPriceOnSubscription());
        AssertionUtilities.assertDoubleEquals(expectedFairValueOnStandardSubscriptionAsBD, actualFairValueOnStandardSubscription, currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails());

    }

    @Then("^I validate that net price on the subscription is uplifted by the uplift factor$")
    public void i_validate_that_net_price_on_the_subscription_is_uplifted_by_the_uplift_factor() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object(){}.getClass().getEnclosingMethod().getName());
        UtilityMethods.logInfoToAStep(currentStep,sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails() );
        Double expectedNetPriceOnStandardSubscriptionAsBD = currentNetPriceOnSubscription * actualUpliftFactorValueFromSF;
        Double actualNetPriceOnStandardSubscription = Double.parseDouble(sfSubscriptionDetailsPageClassic.getCurrentNetPriceOnSubscription());
        AssertionUtilities.assertDoubleEquals(expectedNetPriceOnStandardSubscriptionAsBD, actualNetPriceOnStandardSubscription, currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails());
    }

    @Given("^I validate that the Subscription record is Transactional$")
    public void i_validate_that_the_Subscription_record_is_Transactional() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        UtilityMethods.logInfoToAStep(currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionProductDetails());
        transactionalAttributeValue = sfSubscriptionDetailsPageClassic.getCurrentTransactionalFlagValue("alt");
    }


    @Given("^I extract the quote line item ids associated to subscription$")
    public void i_extract_the_quote_line_item_ids_associated_to_subscription() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        if (transactionalAttributeValue.equalsIgnoreCase("Checked")) {
            quoteLineItemIdsForTransactionalSubscription = sfSubscriptionDetailsPageClassic.extractTheQuoteLineItemIdsFromSubscription();
        } else {
            UtilityMethods.logInfoToAStep(currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionProductDetails());
        }
    }

    @Given("^search for each quote line item and extract the current values of price and unit price and minimum price$")
    public void search_for_each_quote_line_item_and_extract_the_current_values_of_price_and_unit_price_and_minimum_price(DataTable stepSequenceTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> stepSequenceMap = stepSequenceTable.asMap(String.class, String.class);
        String stepSequence = stepSequenceMap.get("type");
        if (stepSequence.equalsIgnoreCase("initial")) {
            quoteLineItemToPricesMapInitial = getQuoteLinesCurrentPriceValuesMapAssociatedToASubscription(quoteLineItemIdsForTransactionalSubscription);
        } else {
            quoteLineItemToPricesMapPostUplift = getQuoteLinesCurrentPriceValuesMapAssociatedToASubscription(quoteLineItemIdsForTransactionalSubscription);
        }
    }

    @Then("^I validate the values of price and unit price and minimum price are uplift by the factor$")
    public void i_validate_the_values_of_price_and_unit_price_and_minimum_price_are_uplift_by_the_factor() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        for (String quoteLineItemId : quoteLineItemIdsForTransactionalSubscription) {
            Map<String, String> initialValuesMap = quoteLineItemToPricesMapInitial.get(quoteLineItemId);
            Map<String, String> upliftValuesMap = quoteLineItemToPricesMapPostUplift.get(quoteLineItemId);
            String initialPrice = initialValuesMap.get("price");
            String upliftPrice = upliftValuesMap.get("price");
            Double expectedPriceAsBD = Double.parseDouble(initialPrice) * actualUpliftFactorValueFromSF;
            Double actualUpliftPriceAsBD = Double.parseDouble(upliftPrice);
            AssertionUtilities.assertDoubleEquals(expectedPriceAsBD, actualUpliftPriceAsBD, currentStep, sfQuoteLineItemTransactionTierDetailsPageClassic.captureQuoteLinePricingDetails());
            String initialUnitPrice = initialValuesMap.get("unitPrice");
            String upliftUnitPrice = upliftValuesMap.get("unitPrice");
            Double expectedUnitPriceAsBD = Double.parseDouble(initialUnitPrice) * actualUpliftFactorValueFromSF;
            Double actualUnitPriceAsBD = Double.parseDouble(upliftUnitPrice);
            AssertionUtilities.assertDoubleEquals(expectedUnitPriceAsBD, actualUnitPriceAsBD, currentStep, sfQuoteLineItemTransactionTierDetailsPageClassic.captureQuoteLinePricingDetails());
            String initialMinimumPrice = initialValuesMap.get("minimumPrice");
            String upliftMinimumPrice = upliftValuesMap.get("minimumPrice");
            Double expectedInitialMinimumPriceAsBD = Double.parseDouble(initialMinimumPrice) * actualUpliftFactorValueFromSF;
            Double actualInitialMinimumPriceAsBD = Double.parseDouble(upliftMinimumPrice);
            AssertionUtilities.assertDoubleEquals(expectedInitialMinimumPriceAsBD, actualInitialMinimumPriceAsBD, currentStep, sfQuoteLineItemTransactionTierDetailsPageClassic.captureQuoteLinePricingDetails());
        }
    }

    @Given("^I set the contract start date to the date below$")
    public void i_set_the_contract_start_date_to_the_date_below(DataTable contractDateTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> contractDateAsMap = contractDateTable.asMap(String.class, String.class);
        scenarioContractStartDate = contractDateAsMap.get("startDate");
        sfContractDetailsPageClassic.setContractStartDateToADate(scenarioContractStartDate);
    }


    @Given("^I capture the value in Net Customer Uplift field$")
    public void i_capture_the_value_in_Net_Customer_Uplift_field() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String scenarioNetCustomerUpliftValueAsString = sfcpiUpliftDetailsPageClassic.extractNetCustomerUpliftValueAsString();
        scenarioNetCustomerUpliftValue = Double.parseDouble(scenarioNetCustomerUpliftValueAsString);
    }

    @Given("^I set the quote line on subscription to below value$")
    public void i_set_the_quote_line_on_subscription_to_below_value(DataTable quoteLineItemTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> quoteLineItemAsMap = quoteLineItemTable.asMap(String.class, String.class);
        String quoteLineItemId = quoteLineItemAsMap.get("quoteLineItemId");
        sfSubscriptionDetailsPageClassic.populateQuoteLineItemIDOnSubscription(quoteLineItemId);
    }

    @Given("^I set the Uplift Start Date to a \"([^\"]*)\"$")
    public void i_set_the_Uplift_Start_Date_to_a(String upliftStartDate) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftStartDate(upliftStartDate);
        scenarioUpliftStartDate = upliftStartDate;
    }

    @Given("^I set the Uplift Annual Effective Date to a \"([^\"]*)\"$")
    public void i_set_the_Uplift_Annual_Effective_Date_to_a(String upliftAnnualEffectiveDate) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftAnnualEffectiveDate(upliftAnnualEffectiveDate);
        scenarioUpliftAnnualEffectiveDate = upliftAnnualEffectiveDate;
    }

    @Given("^I set the Uplift Application Date to a \"([^\"]*)\"$")
    public void i_set_the_Uplift_Application_Date_to_a(String upliftApplicationDate) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfcpiUpliftDetailsPageClassic.populateUpliftApplicationDate(upliftApplicationDate);
    }

    @Given("^I compute the expected uplift factor value and validate it against the value from salesforce$")
    public void i_compute_the_expected_uplift_factor_value_and_validate_it_against_the_value_from_salesforce() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Double expectedUpliftFactor = calculateUpliftFactor(scenarioUpliftStartDate, scenarioUpliftAnnualEffectiveDate);
        AssertionUtilities.assertDoubleEquals(expectedUpliftFactor, actualUpliftFactorValueFromSF, currentStep, sfcpiUpliftDetailsPageClassic.captureCPIUpliftMainSection());

    }

    @Then("^I validate that the Uplift Calc Type is changed to below value$")
    public void i_validate_that_the_Uplift_Calc_Type_is_changed_to_below_value(DataTable upliftCalcTypeTable) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> upliftCalcTypeAsMap = upliftCalcTypeTable.asMap(String.class, String.class);
        String expectedUpliftCalcTypeValue = upliftCalcTypeAsMap.get("upliftCalcType");
        String actualUpliftCalcTypeValue = sfcpiUpliftDetailsPageClassic.extractCurrentUpliftCalcTypeValue();
        AssertionUtilities.assertStringEquals(expectedUpliftCalcTypeValue, actualUpliftCalcTypeValue, currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());
    }

    @Then("^I validate the Interim Uplift Percentage field is changed to a Net Customer Uplift value$")
    public void i_validate_the_Interim_Uplift_Percentage_field_is_changed_to_a_Net_Customer_Uplift_value() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Double expectedInterimUpliftPercentage = Double.parseDouble(sfcpiUpliftDetailsPageClassic.extractNetCustomerUpliftValueAsString());
        Double actualInterimUpliftPercentage = Double.parseDouble(sfcpiUpliftDetailsPageClassic.extractCurrentInterimUpliftPercentageValueAsString());
        AssertionUtilities.assertDoubleEquals(expectedInterimUpliftPercentage, actualInterimUpliftPercentage, currentStep, sfcpiUpliftDetailsPageClassic.captureAdditionalDetailsSection());
        scenarioInterimUpliftPercentage = expectedInterimUpliftPercentage;
    }

    @Then("^I set the \"([^\"]*)\" on quote to a value$")
    public void i_set_the_on_quote_to_a_value(String netUnitPrice) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        sfQuoteItemDetailsPageClassic.populateNetUnitPriceOnQuoteItem(netUnitPrice);
        scenarioNetUnitPriceOnQuote = Double.parseDouble(netUnitPrice);

    }


    @Then("^I drill down on the Quote Item to be navigated to its details page$")
    public void i_drill_down_on_the_Quote_Item_to_be_navigated_to_its_details_page(DataTable quoteItemTable) throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Map<String, String> quoteLineItemAsMap = quoteItemTable.asMap(String.class, String.class);
        String quoteLineItemId = quoteLineItemAsMap.get("quoteLineItemId");
        sfSubscriptionDetailsPageClassic.drillDownOnQuoteItem(quoteLineItemId);
    }

    @Then("^I validate that net price on the subscription is uplifted by the interim uplift factor based on the quote net price$")
    public void i_validate_that_net_price_on_the_subscription_is_uplifted_by_the_interim_uplift_factor_based_on_the_quote_net_price() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Double expectedNetPriceOnSubscriptionAfterInterimUplift = scenarioNetUnitPriceOnQuote * (1 + (scenarioInterimUpliftPercentage / 100.00));
        Double actualNetPriceOnSubscriptionAfterInterimUplift = Double.parseDouble(sfSubscriptionDetailsPageClassic.getCurrentNetPriceOnSubscription());
        AssertionUtilities.assertDoubleEquals(expectedNetPriceOnSubscriptionAfterInterimUplift, actualNetPriceOnSubscriptionAfterInterimUplift, currentStep, sfSubscriptionDetailsPageClassic.captureSubscriptionHeaderDetails());

    }


    @Then("^I validate uplift factor is changed to net customer uplift value as a decimal$")
    public void i_validate_uplift_factor_is_changed_to_net_customer_uplift_value_as_a_decimal() throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Double upliftFactorDecimalPart = scenarioNetCustomerUpliftValue / 100.00;
        Double expectedUpliftFactor = 1.00 + upliftFactorDecimalPart;
        Double actualUpliftFactor = Double.parseDouble(sfcpiUpliftDetailsPageClassic.extractUpliftFactor());
        AssertionUtilities.assertDoubleEquals(expectedUpliftFactor, actualUpliftFactor, currentStep, sfcpiUpliftDetailsPageClassic.captureCPIUpliftMainSection());
    }

    @Then("^I capture the current uplift calc type$")
    public void i_capture_the_current_uplift_calc_type() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        scenarioRunningUpliftCalcType = sfcpiUpliftDetailsPageClassic.extractCurrentUpliftCalcTypeValue();
    }

    @Then("^I capture the uplift annual effective date before uplift$")
    public void i_capture_the_uplift_annual_effective_date_before_uplift() throws Throwable {
        Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        annualEffectiveDateBeforeUplift = sfcpiUpliftDetailsPageClassic.getCurrentUpliftAnnualEffectiveDate();
    }

    private Double calculateUpliftFactor(String upliftStartDate, String upliftAnnualEffectiveDate) {

        Double upliftFactor = null;
        int precision = 1000;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (scenarioBillingFrequency.equalsIgnoreCase("Monthly")) {
            LocalDate upliftStartDateAsLocalDate = LocalDate.parse(upliftStartDate, dateTimeFormatter);
            LocalDate upliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDate, dateTimeFormatter);
            Double numberOfDaysInTheCurrentBillingPeriod = (double) upliftAnnualEffectiveDateAsLocalDate.lengthOfMonth();
            Double daysBetweenUpliftStartDateAndEffectiveDate = (double) ChronoUnit.DAYS.between(upliftAnnualEffectiveDateAsLocalDate, upliftStartDateAsLocalDate);
            Double daysOfProRation = numberOfDaysInTheCurrentBillingPeriod - daysBetweenUpliftStartDateAndEffectiveDate;
            Double upliftValueAsBD = scenarioNetCustomerUpliftValue / 100.00;
            Double factorToAdd = (daysOfProRation * (upliftValueAsBD)) / (numberOfDaysInTheCurrentBillingPeriod);
            upliftFactor = Math.floor((1.00 + factorToAdd) * precision + .5) / precision;
        } else if (scenarioBillingFrequency.equalsIgnoreCase("Quarterly")) {
            LocalDate upliftStartDateAsLocalDate = LocalDate.parse(upliftStartDate, dateTimeFormatter);
            LocalDate upliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDate, dateTimeFormatter);
            Integer currentQuarter = upliftAnnualEffectiveDateAsLocalDate.get(IsoFields.QUARTER_OF_YEAR);
            Integer currentYear = upliftAnnualEffectiveDateAsLocalDate.getYear();
            Integer numberOfDaysInQuarter = numberOfDaysInAGivenCalendarQuarter(currentQuarter, currentYear);
            Double numberOfDaysInCurrentQuarter = (double) numberOfDaysInQuarter;
            Double daysBetweenUpliftStartDateAndEffectiveDate = (double) ChronoUnit.DAYS.between(upliftAnnualEffectiveDateAsLocalDate, upliftStartDateAsLocalDate);
            Double daysOfProRation = numberOfDaysInCurrentQuarter - daysBetweenUpliftStartDateAndEffectiveDate;
            Double upliftValueAsBD = scenarioNetCustomerUpliftValue.doubleValue() / 100.00;
            Double factorToAdd = (daysOfProRation * upliftValueAsBD) / numberOfDaysInCurrentQuarter;
            upliftFactor = Math.floor((1.00 + factorToAdd) * precision + .5) / precision;
        } else if (scenarioBillingFrequency.equalsIgnoreCase("Semiannual")) {
            LocalDate upliftStartDateAsLocalDate = LocalDate.parse(upliftStartDate, dateTimeFormatter);
            LocalDate upliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDate, dateTimeFormatter);
            Integer currentMonth = upliftAnnualEffectiveDateAsLocalDate.getMonth().getValue();
            Integer currentYear = upliftAnnualEffectiveDateAsLocalDate.getYear();
            Integer numberOfDaysInCurrentSemiannualPeriod = calculateAndReturnNumberOfDaysInCalendarSemiannualPeriod(currentYear, currentMonth);
            Double numberOfDaysInCurrentSemiannualPeriodAsDouble = (double) numberOfDaysInCurrentSemiannualPeriod;
            Double daysBetweenUpliftStartDateAndEffectiveDate = (double) ChronoUnit.DAYS.between(upliftAnnualEffectiveDateAsLocalDate, upliftStartDateAsLocalDate);
            Double daysOfProRation = numberOfDaysInCurrentSemiannualPeriodAsDouble - daysBetweenUpliftStartDateAndEffectiveDate;
            Double upliftValueAsBD = scenarioNetCustomerUpliftValue.doubleValue() / 100.00;
            Double factorToAdd = (daysOfProRation * upliftValueAsBD) / numberOfDaysInCurrentSemiannualPeriodAsDouble;
            upliftFactor = Math.floor((1.00 + factorToAdd) * precision + .5) / precision;
        } else if (scenarioBillingFrequency.equalsIgnoreCase("Annual")) {
            LocalDate upliftStartDateAsLocalDate = LocalDate.parse(upliftStartDate, dateTimeFormatter);
            LocalDate upliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDate, dateTimeFormatter);
            Integer currentYear = upliftAnnualEffectiveDateAsLocalDate.getYear();
            LocalDate startDateOfCurrentYear = LocalDate.of(currentYear, Month.JANUARY, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endDateOfCurrentYears = LocalDate.of(currentYear, Month.DECEMBER, 1).with(TemporalAdjusters.lastDayOfMonth());
            Double numberOfDaysInCurrentYearAsDouble = (double) ChronoUnit.DAYS.between(startDateOfCurrentYear, endDateOfCurrentYears) + 1;
            Double daysBetweenUpliftStartDateAndEffectiveDate = (double) ChronoUnit.DAYS.between(upliftAnnualEffectiveDateAsLocalDate, upliftStartDateAsLocalDate);
            Double daysOfProRation = numberOfDaysInCurrentYearAsDouble - daysBetweenUpliftStartDateAndEffectiveDate;
            Double upliftValueAsBD = scenarioNetCustomerUpliftValue.doubleValue() / 100.00;
            Double factorToAdd = (daysOfProRation * upliftValueAsBD) / numberOfDaysInCurrentYearAsDouble;
            upliftFactor = Math.floor((1.00 + factorToAdd) * precision + .5) / precision;

        }

        return upliftFactor;


    }


    private Map<String, Map<String, String>> getQuoteLinesCurrentPriceValuesMapAssociatedToASubscription(List<String> quoteLineItemsList) {
        Map<String, Map<String, String>> quoteLineItemsToPricesMap = new HashMap<>();
        for (String quoteLineItemId : quoteLineItemsList) {
            sfHomePageClassic.searchForARecordBasedOnId(quoteLineItemId);
            sfRecordSearchResultsPageClassic.navigateToRecordDetailsPage(quoteLineItemId);
            String priceOnLineItem = sfQuoteLineItemTransactionTierDetailsPageClassic.extractPriceFromQuoteLineItem();
            String unitPriceOnLineItem = sfQuoteLineItemTransactionTierDetailsPageClassic.extractUnitPriceFromQuoteLineItem();
            String minimumPriceOnLineItem = sfQuoteLineItemTransactionTierDetailsPageClassic.extractMinimumPriceFromQuoteLineItem();
            Map<String, String> pricesMap = new HashMap<>();
            pricesMap.put("price", priceOnLineItem);
            pricesMap.put("unitPrice", unitPriceOnLineItem);
            pricesMap.put("minimumPrice", minimumPriceOnLineItem);
            quoteLineItemsToPricesMap.put(quoteLineItemId, pricesMap);
        }
        return quoteLineItemsToPricesMap;
    }

    private String calculateAndReturnExpectedAnnualEffectiveDate(String upliftAnnualEffectiveDateInput) throws IOException {
        String expectedAnnualEffectiveDate = null;
        if (!scenarioRunningUpliftCalcType.equalsIgnoreCase("Interim")) {
            if (scenarioBillingFrequency.equalsIgnoreCase("Monthly")) {
                expectedAnnualEffectiveDate = UtilityMethods.addMonthsToAGivenDate(upliftAnnualEffectiveDateInput, 1l);

            } else if (scenarioBillingFrequency.equalsIgnoreCase("Quarterly")) {
                expectedAnnualEffectiveDate = UtilityMethods.addMonthsToAGivenDate(upliftAnnualEffectiveDateInput, 3l);


            } else if (scenarioBillingFrequency.equalsIgnoreCase("Semiannual")) {
                expectedAnnualEffectiveDate = UtilityMethods.addMonthsToAGivenDate(upliftAnnualEffectiveDateInput, 6l);

            } else if (scenarioBillingFrequency.equalsIgnoreCase("Annual")) {
                if (!scenarioUpliftType.equalsIgnoreCase("Anniversary")) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate currentUpliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDateInput, dateTimeFormatter);
                    int currentYear = currentUpliftAnnualEffectiveDateAsLocalDate.getYear();
                    expectedAnnualEffectiveDate = LocalDate.ofYearDay(currentYear + 1, 1).format(dateTimeFormatter);
                } else {
                    expectedAnnualEffectiveDate = UtilityMethods.addYearsToAGivenDate(upliftAnnualEffectiveDateInput, 1l);
                }
            }
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate currentUpliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDateInput, dateTimeFormatter);
            int currentYear = currentUpliftAnnualEffectiveDateAsLocalDate.getYear();
            expectedAnnualEffectiveDate = LocalDate.ofYearDay(currentYear + 1, 1).format(dateTimeFormatter);
        }
        return expectedAnnualEffectiveDate;
    }


    private Integer numberOfDaysInAGivenCalendarQuarter(Integer quarter, Integer currentYear) {
        Integer numberOfDaysInACalendarQuarter = 0;

        if (quarter == 1) {
            LocalDate startDay0fFirstCalendarQuarter = LocalDate.of(currentYear, Month.JANUARY, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endDayOfFirstCalendarQuarter = LocalDate.of(currentYear, Month.MARCH, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInACalendarQuarter = (int) ChronoUnit.DAYS.between(startDay0fFirstCalendarQuarter, endDayOfFirstCalendarQuarter) + 1;
        } else if (quarter == 2) {
            LocalDate startDay0fSecondCalendarQuarter = LocalDate.of(currentYear, Month.APRIL, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endDayOfSecondCalendarQuarter = LocalDate.of(currentYear, Month.JUNE, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInACalendarQuarter = (int) ChronoUnit.DAYS.between(startDay0fSecondCalendarQuarter, endDayOfSecondCalendarQuarter) + 1;
        } else if (quarter == 3) {
            LocalDate startDay0fThirdCalendarQuarter = LocalDate.of(currentYear, Month.JULY, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endDayOfThirdCalendarQuarter = LocalDate.of(currentYear, Month.SEPTEMBER, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInACalendarQuarter = (int) ChronoUnit.DAYS.between(startDay0fThirdCalendarQuarter, endDayOfThirdCalendarQuarter) + 1;
        } else if (quarter == 4) {
            LocalDate startDay0fFourthCalendarQuarter = LocalDate.of(currentYear, Month.OCTOBER, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endDayOfFourthCalendarQuarter = LocalDate.of(currentYear, Month.DECEMBER, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInACalendarQuarter = (int) ChronoUnit.DAYS.between(startDay0fFourthCalendarQuarter, endDayOfFourthCalendarQuarter) + 1;

        }

        return numberOfDaysInACalendarQuarter;
    }

    public Integer calculateAndReturnNumberOfDaysInCalendarSemiannualPeriod(Integer currentYear, Integer upliftAnnualEffectiveMonth) {
        Integer numberOfDaysInASemiannualPeriod = 0;

        if (upliftAnnualEffectiveMonth >= 1 && upliftAnnualEffectiveMonth <= 6) {
            LocalDate startOfFirstCalendarSemiannualPeriod = LocalDate.of(currentYear, Month.JANUARY, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endOfFirstCalendarSemiannualPeriod = LocalDate.of(currentYear, Month.JUNE, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInASemiannualPeriod = (int) ChronoUnit.DAYS.between(startOfFirstCalendarSemiannualPeriod, endOfFirstCalendarSemiannualPeriod) + 1;

        } else if (upliftAnnualEffectiveMonth > 6 && upliftAnnualEffectiveMonth <= 12) {
            LocalDate startOfSecondCalendarSemiannualPeriod = LocalDate.of(currentYear, Month.JULY, 1).with(TemporalAdjusters.firstDayOfMonth());
            LocalDate endOfSecondCalendarSemiannualPeriod = LocalDate.of(currentYear, Month.DECEMBER, 1).with(TemporalAdjusters.lastDayOfMonth());
            numberOfDaysInASemiannualPeriod = (int) ChronoUnit.DAYS.between(startOfSecondCalendarSemiannualPeriod, endOfSecondCalendarSemiannualPeriod) + 1;
        }

        return numberOfDaysInASemiannualPeriod;

    }

}
