package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
@DependsOn("base")
public class SFBillingGroupDetailsPageClassic extends Context {

    private static final By createRLFButtonLocator = By.name("create_rlf");
    private static final By salesOrderRelatedListLocator = By.xpath("//h3[text()='Sales Orders']/ancestor::div[starts-with(@class,'listRelatedObject')]");
    private static final By gotToAllSOsLinkLocator = By.partialLinkText("Go to list");
    private static final By allSOsOnBillingGroupLocator = By.partialLinkText("SO-");
    private static final By earliestBillingDateValueLocator = By.id("00N3E000000UjNy_ileinner");
    private static final By syncSubscriptionSection = By.xpath("//div[@id='head_01B3E000002HtL5_ep']");
    private static final By nextSoGenerationInputFieldLocator = By.id("00N3E000000UjNz_ileinner");
    private static final By nextSoGenerationInputFieldEditLocator = By.id("00N3E000000UjNz");
    private static final By earliestNextBillingDateInputFieldLocator = By.id("00N3E000000UjNy_ileinner");
    private static final By earliestNextBillingDateInputFieldEditLocator = By.id("00N3E000000UjNy");
    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By editButtonLocator = By.name("edit");



    public void createRLFForTheBillingGroup() {
        sfObjectMethods.SFLinkOrButtonClick(createRLFButtonLocator);
        sfObjectMethods.SFAcceptAlert();
        sfObjectMethods.SFAcceptAlert();
    }


    public <T> Object navigateToSalesOrderListOnBG() {
        WebElement salesOrderRelatedListElement = sfObjectMethods.SFReturnWebElement(salesOrderRelatedListLocator);
        if (sfObjectMethods.SFIsElementPresentInsideWebElement(salesOrderRelatedListElement, gotToAllSOsLinkLocator)) {
            WebElement goToAllSalesOrderListElement = sfObjectMethods.SFReturnWebElementWithinAWebElement(salesOrderRelatedListElement, gotToAllSOsLinkLocator);
            sfObjectMethods.SFClickWebElement(goToAllSalesOrderListElement);
            return new SFSalesOrderRelatedListPageOnBGClassic();
        } else {
            Integer numberOfRecordsInSORelationList = getTheNumberOfRecordsOnBGSalesOrderList();
            return numberOfRecordsInSORelationList;
        }
    }

    public String getNextSOGenerationDateValueOnBillingGroup() {
        return sfObjectMethods.SFReturnWebElement(nextSoGenerationInputFieldLocator).getText();
    }

    public String getEarliestBillingDateValueOnBillingGroup() {
        return sfObjectMethods.SFReturnWebElement(earliestBillingDateValueLocator).getText();
    }

    public void populateNextSOGenerationDateToAValue(String dateAsString) {
        sfObjectMethods.SFDoubleClickOnAnElement(nextSoGenerationInputFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(nextSoGenerationInputFieldEditLocator, dateAsString);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void populateEarliestNextBillingDateToAValue(String dateAsString) {
        sfObjectMethods.SFDoubleClickOnAnElement(earliestNextBillingDateInputFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(earliestNextBillingDateInputFieldEditLocator, dateAsString);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public String captureCurrentPageBase64Screenshot() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureFullPageScreenshot("Billing Group Page");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64Screenshot;
    }

    public String captureSyncSubscriptionSection() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(syncSubscriptionSection, "Sync Subscription Section on Billing Group");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }


    public Integer getTheNumberOfRecordsOnBGSalesOrderList() {
        List<WebElement> tableRows = sfObjectMethods.SFFindElements(allSOsOnBillingGroupLocator);
        return tableRows.size();
    }

}
