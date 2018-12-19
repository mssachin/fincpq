package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqsmokesuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFBillingGroupDetailsPageClassic;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFContractDetailsPageClassic;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;
import com.finastra.cpq.finastraCPQ.utilities.AssertionUtilities;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfilesBillingGroupObjectSteps {

    @Autowired
    private SFBillingGroupDetailsPageClassic sfBillingGroupDetailsPageClassic;

    @Given("^I validate all the fields in the Customer Details section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Customer_Details_section_on_the_Billing_Group_page_as_below(DataTable custDetailsSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = custDetailsSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Customer Details");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Customer CCRT Details on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Customer_CCRT_Details_on_the_Billing_Group_page_as_below(DataTable custCCRTDetails) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = custCCRTDetails.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Customer CCRT Details");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the BG Original Source Data section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_BG_Original_Source_Data_section_on_the_Billing_Group_page_as_below(DataTable BgOriginalSourceDataSectionFeilds) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = BgOriginalSourceDataSectionFeilds.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("BG Original Source Data");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Sync Subscriptions section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Sync_Subscriptions_Section_section_on_the_Billing_Group_page_as_below(DataTable SyncSubscriptionsSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SyncSubscriptionsSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Sync Subscriptions Section");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Hold Billing section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Hold_Billing_section_on_the_Billing_Group_page_as_below(DataTable HoldBillingSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = HoldBillingSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Hold Billing");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Billing Information section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Billing_Information_section_on_the_Billing_Group_page_as_below(DataTable BillingInformationSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = BillingInformationSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Billing Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Legacy Misys NS RB fields section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Legacy_Misys_NS_RB_fields_section_on_the_Billing_Group_page_as_below(DataTable LegacyMisysNSRBSectionFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = LegacyMisysNSRBSectionFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("legacy Misys NS RB fields");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

    @Given("^I validate all the fields in the Take-on Information fields section on the Billing Group page as below$")
    public void i_validate_all_the_fields_in_the_Take_on_Information_fields_section_on_the_Billing_Group_page_as_below(DataTable TakeOnInformationFields) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = TakeOnInformationFields.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfBillingGroupDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Take-on Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");
    }

}
