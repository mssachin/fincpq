package com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic.SFHomePageClassic;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFLoginPage extends Context {

    private static final By usernameFieldLocator = By.id("username");
    private static final By passwordFieldLocator = By.id("password");
    private static final By loginButtonLocator = By.id("Login");


    public void enterUsername(String username) {
        sfObjectMethods.SFEnterTextInTextBox(usernameFieldLocator, username);
    }

    public void enterPassword(String password) {
        sfObjectMethods.SFEnterTextInTextBox(passwordFieldLocator, password);
    }


    public SFHomePageClassic loginToSalesforce() {
        sfObjectMethods.SFLinkOrButtonClick(loginButtonLocator);
        return new SFHomePageClassic();
    }


}
