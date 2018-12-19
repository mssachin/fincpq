package com.finastra.cpq.finastraCPQ.stepdefinitions.cpqcommons;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.SFDCLaunchURL;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.SFLoginPage;
import com.finastra.cpq.finastraCPQ.utilities.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CPQCommonSteps {

    @Autowired
    private SFDCLaunchURL sfdcLaunchURL;

    @Autowired
    private SFLoginPage sfLoginPage;


    @Given("^I have launched salesforce test sandbox url$")
    public void i_have_launched_salesforce_test_sandbox_url() {
        sfdcLaunchURL.launchSalesforceTestSandboxURL();
    }


    @Given("^I have logged in to salesforce as the below user$")
    public void i_have_logged_in_to_salesforce_as_the_below_user(DataTable userCredentials) throws Throwable {
        Map<String, String> userCredentialsMap = userCredentials.asMap(String.class, String.class);
        String username = userCredentialsMap.get("username");
        String password = userCredentialsMap.get("password");
        String userProfile = userCredentialsMap.get("profile");
        Hooks.getCurrentScenario().createNode(com.aventstack.extentreports.gherkin.model.Given.class, /*new Object(){}.getClass().getEnclosingMethod().getName()+*/" Login to Salesforce as: " + userProfile + " user ");
        sfLoginPage.enterUsername(username);
        sfLoginPage.enterPassword(password);
        sfLoginPage.loginToSalesforce();

    }


}
