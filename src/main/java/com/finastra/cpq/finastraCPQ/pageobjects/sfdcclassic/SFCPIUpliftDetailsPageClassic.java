package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;


import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@DependsOn("base")
public class SFCPIUpliftDetailsPageClassic extends Context {


    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By overrideFactorFieldInputLocator = By.id("00N3E000000UjxG_ileinner");
    private static final By overrideFactorEditFieldInputLocator = By.id("00N3E000000UjxG");
    private static final By upliftFactorValueLocator = By.id("00N3E000001rPR3_ileinner");
    private static final By upliftAnnualEffectiveDateInputLocator = By.id("00N3E000001tPD5_ileinner");
    private static final By upliftAnnualEffectiveDateEditInputLocator = By.id("00N3E000001tPD5");
    private static final By upliftApplicationDateInputLocator = By.id("00N3E000001tPDA_ileinner");
    private static final By upliftApplicationDateEditInputLocator = By.id("00N3E000001tPDA");
    private static final By billingTypePickListLocator = By.id("00N3E000001tPDP_ileinner");
    private static final By billingTypePickListEditLocator = By.id("00N3E000001tPDP");
    private static final By billingFrequencyPickListLocator = By.id("00N3E000001s93w_ileinner");
    private static final By billingFrequencyPickListEditLocator = By.id("00N3E000001s93w");
    private static final By cpiUpliftTypePickListLocator = By.id("00N3E000001rPQz_ileinner");
    private static final By cpiUpliftTypePickListEditLocator = By.id("00N3E000001rPQz");
    private static final By upliftCalcTypePickListLocator = By.id("00N3E000000UjxK_ileinner");
    private static final By upliftCalcTypePickListEditLocator = By.id("00N3E000000UjxK");
    private static final By upliftAdvanceFiledInputLocator = By.id("00N3E000001sM8H_ileinner");
    private static final By upliftAdvanceFiledInputEditLocator = By.id("00N3E000001sM8H");
    private static final By holdBillingFlagLocator = By.id("00N3E0000027vY6_chkbox");
    private static final By holdBillingFlagEditLocator = By.id("00N3E0000027vY6");
    private static final By applyUpliftButtonLocator = By.name("apply_uplift");
    private static final By editButtonLocator = By.name("edit");
    private static final By additionalInformationSectionLocator = By.id("head_01B3E000002jfS1_ep");
    private static final By netCustomerUpliftFieldValueLocator = By.id("00N3E000000UjxC_ileinner");
    private static final By upliftStartDateFieldValueLocator = By.id("00N3E000001tPDF_ileinner");
    private static final By upliftStartDateEditFieldLocator = By.id("00N3E000001tPDF");
    private static final By upliftDetailMainSection = By.className("mainTitle");
    private static final By interimUpliftPercentageFieldValueLocator = By.id("00N3E000001tSoW_ileinner");



    public void populateOverrideFieldWithAFactor(String overrideFactor){
        sfObjectMethods.SFDoubleClickOnAnElement(overrideFactorFieldInputLocator);
        sfObjectMethods.SFEnterTextInTextBox(overrideFactorEditFieldInputLocator,overrideFactor);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public String extractUpliftFactor(){
       return sfObjectMethods.SFExtractTextFromWebElement(upliftFactorValueLocator);
    }

    public void populateUpliftStartDate(String upliftStartDate) {
        sfObjectMethods.SFDoubleClickOnAnElement(upliftStartDateFieldValueLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(upliftStartDateEditFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(upliftStartDateEditFieldLocator, upliftStartDate);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void populateUpliftAnnualEffectiveDate(String upliftAnnualEffectiveDate) {
        sfObjectMethods.SFDoubleClickOnAnElement(upliftAnnualEffectiveDateInputLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(upliftAnnualEffectiveDateEditInputLocator);
        sfObjectMethods.SFEnterTextInTextBox(upliftAnnualEffectiveDateEditInputLocator, upliftAnnualEffectiveDate);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void populateUpliftApplicationDate(String upliftApplicationDate){
        sfObjectMethods.SFDoubleClickOnAnElement(upliftApplicationDateInputLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(upliftApplicationDateEditInputLocator);
        sfObjectMethods.SFEnterTextInTextBox(upliftApplicationDateEditInputLocator,upliftApplicationDate);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void selectBillingType(String billingType){
        sfObjectMethods.SFDoubleClickOnAnElement(billingTypePickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(billingTypePickListEditLocator, billingType);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void selectBillingFrequency(String billingFrequency){
        sfObjectMethods.SFDoubleClickOnAnElement(billingFrequencyPickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(billingFrequencyPickListEditLocator, billingFrequency);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void selectCPIUpliftType(String cpiUpliftType){
        sfObjectMethods.SFDoubleClickOnAnElement(cpiUpliftTypePickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(cpiUpliftTypePickListEditLocator, cpiUpliftType);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void selectUpliftCalcType(String upliftCalcType){
        sfObjectMethods.SFDoubleClickOnAnElement(upliftCalcTypePickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(upliftCalcTypePickListEditLocator, upliftCalcType);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void populateUpliftAdvance(String upliftAdvance){
        sfObjectMethods.SFDoubleClickOnAnElement(upliftAdvanceFiledInputLocator);
        sfObjectMethods.SFEnterTextInTextBox(upliftAdvanceFiledInputEditLocator, upliftAdvance);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void applyUpliftToAssociatedSubscriptions(){
        sfObjectMethods.SFLinkOrButtonClick(applyUpliftButtonLocator);
        sfObjectMethods.SFAcceptAlert();
        sfObjectMethods.SFAcceptAlert();
    }

    public void populateHoldBillingFlag(){
        sfObjectMethods.SFDoubleClickOnAnElement(holdBillingFlagLocator);
        sfObjectMethods.SFLinkOrButtonClick(holdBillingFlagEditLocator);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public String getCurrentHoldBillingFlagValue(String attribute){
        return sfObjectMethods.SFGetAttributeOfAWebElement(holdBillingFlagLocator, attribute);
    }

    public String getCurrentUpliftAnnualEffectiveDate(){
        return sfObjectMethods.SFExtractTextFromWebElement(upliftAnnualEffectiveDateInputLocator);
    }

    public String getCurrentUpliftApplicationDate(){
        return  sfObjectMethods.SFExtractTextFromWebElement(upliftApplicationDateInputLocator);
    }

    public String extractNetCustomerUpliftValueAsString() {
        String netCustomerUpliftValuePercentage = sfObjectMethods.SFExtractTextFromWebElement(netCustomerUpliftFieldValueLocator);
        String netCustomerUpliftValueWithoutPercentageSymbol = netCustomerUpliftValuePercentage.split("%")[0];
        return netCustomerUpliftValueWithoutPercentageSymbol;
    }

    public String extractCurrentUpliftCalcTypeValue() {
        return sfObjectMethods.SFExtractTextFromWebElement(upliftCalcTypePickListLocator);
    }

    public String extractCurrentInterimUpliftPercentageValueAsString() {
        String upliftPercentage = sfObjectMethods.SFExtractTextFromWebElement(interimUpliftPercentageFieldValueLocator);
        String upliftValueWithoutPercentageSign = upliftPercentage.split("%")[0];
        return upliftValueWithoutPercentageSign;
    }

    public String captureAdditionalDetailsSection() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(additionalInformationSectionLocator, "Additional Details on CPI Uplift Record");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }

    public String captureCPIUpliftMainSection() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(upliftDetailMainSection, "Main Details on CPI Uplift Record");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }

}
