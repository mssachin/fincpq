package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@DependsOn("base")
public class SFSubscriptionDetailsPageClassic extends Context {

    private static final By subscriptionCloneButtonLocator = By.name("clone");
    private static final By subscriptionIdFieldLocator = By.id("Name_ileinner");
    private static final By nextSOGenerationDateValueLocator = By.xpath("//td[text()='Next SO generation Date']/following-sibling::td[1]/div[1]");
    private static final By nextBillingDateValueLocator = By.xpath("//td[text()='Next Billing Date']/following-sibling::td[1]/div[1]");
    private static final By billingInformationSection = By.xpath("//div[@id='head_01B3E000002jfQX_ep']");
    private static final By fairValueValueLocator = By.id("00N3E000000Ujur_ileinner");
    private static final By netPriceValueLocator = By.id("00N0J00000AQFlw_ileinner");
    private static final By subscriptionHeaderLocator = By.className("mainTitle");
    private static final By quoteLineItemLinkLocator = By.partialLinkText("QLTT-");
    private static final By transactionalFlagFieldLocator = By.id("00N3E000000UjwD_chkbox");
    private static final By productDetailsSectionLocator = By.id("head_01B3E000002jfQZ_ep");
    private static final By billingTypePickListLocator = By.id("00N0J00000AQFla_ileinner");
    private static final By billingTypePickListEditLocator = By.id("00N0J00000AQFla");
    private static final By billingFrequencyPickListLocator = By.id("00N0J00000AQFlZ_ileinner");
    private static final By billingFrequencyPickListEditLocator = By.id("00N0J00000AQFlZ");
    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By editButtonLocator = By.name("edit");
    private static final By soGenerationAdvanceFieldLocator = By.id("00N3E000000Ujvs_ileinner");
    private static final By soGenerationAdvanceFieldEditLocator = By.id("00N3E000000Ujvs");
    private static final By nextBillingDateValueFieldLocator = By.id("00N3E000000UjvM_ileinner");
    private static final By nextBillingDateValueEditFieldLocator = By.id("00N3E000000UjvM");
    private static final By nextSOGenerationDateValueFieldLocator = By.id("00N3E000000UjvN_ileinner");
    private static final By nextSOGenerationDateValueEditFieldLocator = By.id("00N3E000000UjvN");
    private static final By quoteLineIdValueFieldLocator = By.id("CF00N0J00000AQFmD_ileinner");
    private static final By quoteLineIdEditFieldLocator = By.id("CF00N0J00000AQFmD");


    public void returnPageTitleToConsole() {
        System.out.print("Title is " + driver.getTitle());
    }

    public String extractSubscriptionId() {
        return sfObjectMethods.SFExtractTextFromWebElement(subscriptionIdFieldLocator);
    }

    public SFSubscriptionEditPageClassic cloneSubscriptionRecord() {
        sfObjectMethods.SFLinkOrButtonClick(subscriptionCloneButtonLocator);
        return new SFSubscriptionEditPageClassic();
    }

    public String getNextSOGenerationDateValueOnSubscription() {
        return sfObjectMethods.SFExtractTextFromWebElement(nextSOGenerationDateValueLocator);
    }

    public String getNextBillingDateValueOnSubscription() {
        return sfObjectMethods.SFExtractTextFromWebElement(nextBillingDateValueLocator);
    }

    public String getCurrentFairPriceOnSubscription(){
        String fairPriceWithCurrency = sfObjectMethods.SFExtractTextFromWebElement(fairValueValueLocator);
        String [] priceAndCurrencyArr = fairPriceWithCurrency.split(" ");
        String fairPrice = priceAndCurrencyArr[1].replace(",", "");
        return fairPrice;
    }

    public String getCurrentNetPriceOnSubscription(){
        String netPriceWithCurrency = sfObjectMethods.SFExtractTextFromWebElement(netPriceValueLocator);
        String [] priceAndCurrencyArr = netPriceWithCurrency.split(" ");
        String netPrice = priceAndCurrencyArr[1].replace(",", "");
        return netPrice;
    }

    public List<String> extractTheQuoteLineItemIdsFromSubscription() {
        List<String> quoteLineItemIds = new ArrayList<>();
        List<WebElement> quoteLineItemLinkElementList = sfObjectMethods.SFFindElements(quoteLineItemLinkLocator);
        for (WebElement element : quoteLineItemLinkElementList) {
            String linkText = element.getText();
            quoteLineItemIds.add(linkText);
        }
        return quoteLineItemIds;
    }

    public String getCurrentTransactionalFlagValue(String attribute) {
        return sfObjectMethods.SFGetAttributeOfAWebElement(transactionalFlagFieldLocator, attribute);
    }

    public void selectBillingType(String billingType) {
        sfObjectMethods.SFDoubleClickOnAnElement(billingTypePickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(billingTypePickListEditLocator, billingType);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);

    }

    public void selectBillingFrequency(String billingFrequency) {
        sfObjectMethods.SFDoubleClickOnAnElement(billingFrequencyPickListLocator);
        sfObjectMethods.SFSelectElementFromAPickList(billingFrequencyPickListEditLocator, billingFrequency);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public void populateSOGenerationAdvanceField(String upliftAdvance) {
        sfObjectMethods.SFDoubleClickOnAnElement(soGenerationAdvanceFieldLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(soGenerationAdvanceFieldEditLocator);
        sfObjectMethods.SFEnterTextInTextBox(soGenerationAdvanceFieldEditLocator, upliftAdvance);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public void populateNextBillingDateOnSubscription(String date) {
        sfObjectMethods.SFDoubleClickOnAnElement(nextBillingDateValueFieldLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(nextBillingDateValueEditFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(nextBillingDateValueEditFieldLocator, date);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public void populateNextSOGenerationDateOnSubscription(String date) {
        sfObjectMethods.SFDoubleClickOnAnElement(nextSOGenerationDateValueFieldLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(nextSOGenerationDateValueEditFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(nextSOGenerationDateValueEditFieldLocator, date);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public void populateQuoteLineItemIDOnSubscription(String quoteLineItemId) {
        sfObjectMethods.SFDoubleClickOnAnElement(quoteLineIdValueFieldLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(quoteLineIdEditFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(quoteLineIdEditFieldLocator, quoteLineItemId);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public void drillDownOnQuoteItem(String quoteItemId) {
        sfObjectMethods.SFLinkOrButtonClick(By.linkText(quoteItemId));
    }


    public String captureCurrentPageBase64Screenshot() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureFullPageScreenshot("Subscription Page");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64Screenshot;
    }

    public String captureBillingInformationSection() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(billingInformationSection, "BillingInformatiOnSectiononSubscription");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }

    public String captureSubscriptionHeaderDetails(){
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(subscriptionHeaderLocator, "Subscription Header with Initial Price Values");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }


    public String captureSubscriptionProductDetails() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(productDetailsSectionLocator, "Subscription Product Details");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }



    @Override
    public List<SFPageSection> extractFieldsAndItsPropertiesInASection(String sectionName) {
        List<SFPageSection> allFieldsAndPropertiesInASection = new ArrayList<>();
       // String sectionElementPart1 = "//h2[text()=";
        //String sectionElementPart2 = "'" + sectionName + "']" + "/ancestor::div[@id=head')]/following-sibling::div[1]/table";
        By sectionElement = By.xpath("//*[@id='ep']/div[2]/div[2]/table");
        //By sectionElementLocator = By.xpath(sectionElement);
        WebElement preLogSectionElement = sfObjectMethods.SFReturnWebElement(sectionElement);

        By tableRowElement = By.tagName("tr");
        By tableColumnElement = By.tagName("td");
        By scriptElementLocator = By.tagName("script");
        List<WebElement> fieldRowsInPreLogSection = sfObjectMethods.SFFindElementsWithinAWebElement(preLogSectionElement, tableRowElement);
        SFPageSection tempPageSection = null;
        String columnName;
        Integer columnNumber;
        for (int j = 0; j < fieldRowsInPreLogSection.size(); j++) {
            WebElement eachRow = fieldRowsInPreLogSection.get(j);
            Integer rowNumber = -1;
            List<WebElement> columnElements = sfObjectMethods.SFFindElementsWithinAWebElement(eachRow, tableColumnElement);
            for (int i = 0; i < columnElements.size(); i++) {
                if (i == 0 || i == 1) {
                    if (i == 0) {
                        tempPageSection = new SFPageSection();
                        WebElement columnElement = columnElements.get(i);
                        columnName = columnElement.getText().trim();
                        rowNumber = j;
                        columnNumber = i;
                        if (!sfObjectMethods.SFIsElementPresentInsideWebElement(columnElement, scriptElementLocator)) {
                            tempPageSection.setHelpTextPresent(false);
                        } else {
                            tempPageSection.setHelpTextPresent(true);

                        }
                        tempPageSection.setColumnName(columnName);
                        tempPageSection.setRowNumber(rowNumber);
                        tempPageSection.setColumnNumber(columnNumber);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("empty") || (className.equals("labelCol") && columnElement.getText().trim().equals("")) || (className.contains("last") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                    } else {
                        WebElement columnElement = columnElements.get(i);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("Lock") || className.contains("empty") || (className.equals("dataCol") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                        allFieldsAndPropertiesInASection.add(tempPageSection);

                    }


                } else if (i == 2 || i == 3) {

                    if (i == 2) {
                        tempPageSection = new SFPageSection();
                        WebElement columnElement = columnElements.get(i);
                        columnName = columnElement.getText().trim();
                        rowNumber = j;
                        columnNumber = i;
                        if (!sfObjectMethods.SFIsElementPresentInsideWebElement(columnElement, scriptElementLocator)) {
                            tempPageSection.setHelpTextPresent(false);
                        } else {
                            tempPageSection.setHelpTextPresent(true);

                        }
                        tempPageSection.setColumnName(columnName);
                        tempPageSection.setRowNumber(rowNumber);
                        tempPageSection.setColumnNumber(columnNumber);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("empty") || (className.equals("labelCol") && columnElement.getText().trim().equals("")) || (className.contains("last") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                    } else {
                        WebElement columnElement = columnElements.get(i);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("Lock") || className.contains("empty") || (className.equals("dataCol") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }

                        allFieldsAndPropertiesInASection.add(tempPageSection);

                    }

                }
            }
        }

        return allFieldsAndPropertiesInASection;

    }


}
