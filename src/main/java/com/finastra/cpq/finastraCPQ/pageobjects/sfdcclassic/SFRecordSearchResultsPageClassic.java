package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFRecordSearchResultsPageClassic extends Context {

    private static final By noResultsFoundLocator = By.xpath("//div[text()='No matches found']");
    private static final By searchAgainButtonLocator = By.id("secondSearchButton");


    public <T> Object navigateToRecordDetailsPage(String recordLinkText) {
        final By recordLinkLocator = By.linkText(recordLinkText);
        if (!sfObjectMethods.SFIsElementPresent(recordLinkLocator)) {
            while (!sfObjectMethods.SFIsElementPresent(recordLinkLocator)) {
                sfObjectMethods.SFLinkOrButtonClick(searchAgainButtonLocator);
                if (sfObjectMethods.SFIsElementPresent(recordLinkLocator)) {
                    sfObjectMethods.SFLinkOrButtonClick(recordLinkLocator);
                    break;
                }
            }
        } else {
            sfObjectMethods.SFLinkOrButtonClick(recordLinkLocator);
        }
        return new Object();
    }


}
