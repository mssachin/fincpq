package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqsmokesuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFContractDetailsPageClassic;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;
import com.finastra.cpq.finastraCPQ.utilities.AssertionUtilities;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfilesContractObjectSteps {

    @Autowired
    private SFContractDetailsPageClassic sfContractDetailsPageClassic;

    @Given("^I print all the fields in a section$")
    public void i_print_all_the_fields_in_a_section() throws Throwable {

        sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Asset Uplift");
    }


    @Given("^I validate all the fields in the Pre-Log section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Pre_Log_section_on_the_contracts_page_as_below(DataTable preLogSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = preLogSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Pre-Log");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the ReachOut section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_ReachOut_section_on_the_contracts_page_as_below(DataTable reachOutSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = reachOutSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("ReachOut");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Contract Summary section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Contract_Summary_section_on_the_contracts_page_as_below(DataTable contractSummarySectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = contractSummarySectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Contract Summary");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Sync Subscriptions section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Sync_Subscriptions_section_on_the_contracts_page_as_below(DataTable syncSubscriptionsSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = syncSubscriptionsSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Sync Subscriptions");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Billing Information section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Billing_Information_section_on_the_contracts_page_as_below(DataTable billingInformationSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = billingInformationSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Billing Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the CPI Uplift section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_CPI_Uplift_section_on_the_contracts_page_as_below(DataTable cpiUpliftSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = cpiUpliftSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("CPI Uplift");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the legacy Misys NS RB fields section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_legacy_Misys_NS_RB_fields_section_on_the_contracts_page_as_below(DataTable legacyMisysSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = legacyMisysSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("legacy Misys NS RB fields");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Contract Obligations/Entitlement section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Contract_Obligations_Entitlement_section_on_the_contracts_page_as_below(DataTable contractObligationsSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = contractObligationsSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Contract Obligations/Entitlement");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Legal and Risk section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Legal_and_Risk_section_on_the_contracts_page_as_below(DataTable legalAndRiskSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = legalAndRiskSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Legal and Risk");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Contract Scoring section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Contract_Scoring_section_on_the_contracts_page_as_below(DataTable contractScoringSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = contractScoringSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Contract Scoring");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Salesforce CPQ Information section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Salesforce_CPQ_Information_section_on_the_contracts_page_as_below(DataTable salesforceCPQInfoSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = salesforceCPQInfoSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Salesforce CPQ Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Amendments section on the contracts page as below$")
    public void i_validate_all_the_fields_in_the_Amendments_section_on_the_contracts_page_as_below(DataTable amendmentsSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = amendmentsSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfContractDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Amendments");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

}