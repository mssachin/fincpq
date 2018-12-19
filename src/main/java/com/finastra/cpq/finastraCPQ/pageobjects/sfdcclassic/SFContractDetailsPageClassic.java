package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;


import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFContractDetailsPageClassic extends Context {

    private static final By contractStartDateFieldValueLocator = By.id("ctrc5_ileinner");
    private static final By contractStartDateFieldEditLocator = By.id("ctrc5");
    private static final By saveButtonLocator = By.name("inlineEditSave");
    private static final By editButtonLocator = By.name("edit");


    public void setContractStartDateToADate(String startDate) {
        sfObjectMethods.SFDoubleClickOnAnElement(contractStartDateFieldValueLocator);
        sfObjectMethods.SFClearCurrentContentInAnElement(contractStartDateFieldEditLocator);
        sfObjectMethods.SFEnterTextInTextBox(contractStartDateFieldEditLocator, startDate);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        sfObjectMethods.SFWaitForElementToBeClickable(editButtonLocator);
    }
}
