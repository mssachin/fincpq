package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@DependsOn("base")
public class SFSalesOrderDetailsPageClassic extends Context {

    private static final By invoiceWordingFieldLocator = By.id("00N200000066WyT_ileinner");
    private static final By invoiceWordingFieldEditLocator = By.id("00N200000066WyT");
    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By editButtonLocator = By.name("edit");
    private static final By opportunitySectionLocator = By.id("head_01B2000000TtWws_ep");


    public void enterTextInInvoiceWordingField(String textToEnter) {
        sfObjectMethods.SFDoubleClickOnAnElement(invoiceWordingFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(invoiceWordingFieldEditLocator, textToEnter);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }

    public String captureOpportunitySection() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(opportunitySectionLocator, "Opportunity  Section on Sales Order");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }


}
