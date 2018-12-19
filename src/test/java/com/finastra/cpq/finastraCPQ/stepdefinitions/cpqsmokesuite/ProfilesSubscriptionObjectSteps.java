package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqsmokesuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFContractDetailsPageClassic;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFSubscriptionDetailsPageClassic;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;
import com.finastra.cpq.finastraCPQ.utilities.AssertionUtilities;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfilesSubscriptionObjectSteps {

    @Autowired
    private SFSubscriptionDetailsPageClassic sfSubscriptionDetailsPageClassic;




    @Given("^I validate all the fields in the Subscription Detail section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Subscription_Detail_section_on_the_Subscriptions_page_as_below(DataTable SubscriptionDetailsection) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SubscriptionDetailsection.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Subscription Detail");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the threePP Details  section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_PP_Details_section_on_the_Subscriptions_page_as_below(DataTable threePPDetails) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = threePPDetails.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("3PP Details");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Billing Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Billing_Information_section_on_the_Subscriptions_page_as_below(DataTable BillingInformation ) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = BillingInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("BillingInformation");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Tax Determination section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Tax_Determination_section_on_the_Subscriptions_page_as_below(DataTable TaxDetermination) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = TaxDetermination.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Tax Determination");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Product Details section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Product_Details_section_on_the_Subscriptions_page_as_below(DataTable ProductDetails) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = ProductDetails.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Product Details");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Subscription Values section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Subscription_Values_section_on_the_Subscriptions_page_as_below(DataTable SubscriptionValues) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SubscriptionValues.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Subscription Values");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");


    }

    @Given("^I validate all the fields in the User Levels section on the Subscriptions  page as below$")
    public void i_validate_all_the_fields_in_the_User_Levels_section_on_the_Subscriptions_page_as_below(DataTable UserLevels) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = UserLevels.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("User Levels");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Subscription Amounts section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Subscription_Amounts_section_on_the_Subscriptions_page_as_below(DataTable SubscriptionAmounts) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SubscriptionAmounts.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Subscription Amounts");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Pricing Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Pricing_Information_section_on_the_Subscriptions_page_as_below(DataTable PricingInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = PricingInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Pricing Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Segment Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Segment_Information_section_on_the_Subscriptions_page_as_below(DataTable SegmentInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SegmentInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Segment Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");


    }

    @Given("^I validate all the fields in the Support Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Support_Information_section_on_the_Subscriptions_page_as_below(DataTable SupportInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SupportInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Support Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Termination section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Termination_section_on_the_Subscriptions_page_as_below(DataTable Termination) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = Termination.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Termination");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the Data Migration and Legacy Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Data_Migration_Legacy_Information_section_on_the_Subscriptions_page_as_below(DataTable DataMigrationandLegacyInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = DataMigrationandLegacyInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Data Migration & Legacy Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the NS Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_NS_Information_section_on_the_Subscriptions_page_as_below(DataTable NSInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = NSInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("NS Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");

    }

    @Given("^I validate all the fields in the System Information section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_System_Information_section_on_the_Subscriptions_page_as_below(DataTable SystemInformation) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = SystemInformation.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("System Information");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");


    }

    /*

    @Given("^I validate all the fields in the Query - TO BE REMOVED OR DELETED section on the Subscriptions page as below$")
    public void i_validate_all_the_fields_in_the_Query_TO_BE_REMOVED_OR_DELETED_section_on_the_Subscriptions_page_as_below(DataTable Query - TO BE REMOVED OR DELETED) throws Throwable {
        ExtentTest currentStep = Hooks.getCurrentScenario().createNode(And.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        List<SFPageSection> expectedFieldsInSectionWithIndexesAsList = Query - TO BE REMOVED OR DELETED.asList(SFPageSection.class);
        List<SFPageSection> actualFieldsInSectionWithIndexesAsList = sfSubscriptionDetailsPageClassic.extractFieldsAndItsPropertiesInASection("Query - TO BE REMOVED OR DELETED");
        AssertionUtilities.assertListEquals(expectedFieldsInSectionWithIndexesAsList, actualFieldsInSectionWithIndexesAsList, currentStep, "");


    }
  */


}