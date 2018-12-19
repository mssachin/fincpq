package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.SFLoginPage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFGlobalHeaderBarClassic extends Context {

    private static final By globalHeaderNameLinkLocatorAdmin = By.id("userNavLabel");
    private static final By globalHeaderNameLinkLocatorNonAdmin = By.id("globalHeaderNameMink");
    private static final By logoutLinkLocator = By.linkText("Logout");

    public SFLoginPage logoutOfSalesForce() {
        if (sfObjectMethods.SFIsElementPresent(globalHeaderNameLinkLocatorAdmin)) {
            sfObjectMethods.SFLinkOrButtonClick(globalHeaderNameLinkLocatorAdmin);
        } else {
            sfObjectMethods.SFLinkOrButtonClick(globalHeaderNameLinkLocatorNonAdmin);
        }
        sfObjectMethods.SFLinkOrButtonClick(logoutLinkLocator);
        return new SFLoginPage();
    }


}
