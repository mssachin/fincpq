package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFQuoteItemDetailsPageClassic extends Context {

    private static final By netUnitPriceFieldValueLocator = By.id("00N0J00000AQFh7_ileinner");
    private static final By netUnitPriceFieldValueEditLocator = By.id("00N0J00000AQFh7");
    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By editButtonLocator = By.name("edit");


    public void populateNetUnitPriceOnQuoteItem(String unitPriceValue) {
        sfObjectMethods.SFDoubleClickOnAnElement(netUnitPriceFieldValueLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(netUnitPriceFieldValueEditLocator);
        sfObjectMethods.SFEnterTextInTextBox(netUnitPriceFieldValueEditLocator, unitPriceValue);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }
}
