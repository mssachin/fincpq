package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import com.finastra.cpq.finastraCPQ.utilities.UtilityMethods;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;


@Component
@DependsOn("base")
public class SFSubscriptionEditPageClassic extends Context {

    private static final By nextBillingDateFieldLocator = By.id("00N3E000000UjvM");
    private static final By nextSOGenerationDateFieldLocator = By.id("00N3E000000UjvN");
    private static final By saveButtonLocator = By.name("save");
    private static final By dmUniqueIdEditLocator = By.id("00N3E000000Ujuk");


    public void setNextBillingDateToTodaysDate() {
        sfObjectMethods.SFClearCurrentContentInAnElement(nextBillingDateFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(nextBillingDateFieldLocator, UtilityMethods.returnDateTodayAsString());
    }

    public void setNextSOGenerationDateToTodaysDate() {
        sfObjectMethods.SFClearCurrentContentInAnElement(nextSOGenerationDateFieldLocator);
        sfObjectMethods.SFEnterTextInTextBox(nextSOGenerationDateFieldLocator, UtilityMethods.returnDateTodayAsString());
    }

    public SFSubscriptionDetailsPageClassic saveChangesToSubscription() {
        sfObjectMethods.SFClearCurrentContentInAnElement(dmUniqueIdEditLocator);
        sfObjectMethods.SFLinkOrButtonClick(saveButtonLocator);
        return new SFSubscriptionDetailsPageClassic();
    }


}
