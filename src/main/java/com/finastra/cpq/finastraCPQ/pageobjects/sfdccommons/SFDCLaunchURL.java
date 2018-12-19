package com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFDCLaunchURL extends Context {

    public void launchSalesforceTestSandboxURL() {
        driver.get("https://test.salesforce.com");
    }
}
