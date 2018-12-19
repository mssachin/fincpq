package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;


import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DependsOn("base")
public class SFSalesOrderRelatedListPageOnBGClassic extends Context {

    private static final By salesOrderRelatedListTableLocator = By.className("list");
    private static final By numberOfTableRowsInRelatedListLocator = By.tagName("tr");
    private static final By billingGroupLinkLocator = By.partialLinkText("Billing Group:");


    public int getTheNumberOfSalesOrdersInBillingGroup() {
        WebElement salesOrderRelatedListTableElement = sfObjectMethods.SFReturnWebElement(salesOrderRelatedListTableLocator);
        List<WebElement> totalNumberOfSalesOrdersInABillingGroup = sfObjectMethods.SFFindElementsWithinAWebElement(salesOrderRelatedListTableElement, numberOfTableRowsInRelatedListLocator);
        return totalNumberOfSalesOrdersInABillingGroup.size() - 1;
    }

    public SFBillingGroupDetailsPageClassic navigateBackToBillingGroup() {
        sfObjectMethods.SFLinkOrButtonClick(billingGroupLinkLocator);
        return new SFBillingGroupDetailsPageClassic();
    }


}
