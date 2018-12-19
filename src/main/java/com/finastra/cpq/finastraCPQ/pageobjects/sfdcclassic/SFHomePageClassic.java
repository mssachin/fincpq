package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("base")
public class SFHomePageClassic extends Context {


    private static final By searchInputLocator = By.id("phSearchInput");
    private static final By searchButtonLocator = By.id("phSearchButton");


    public SFRecordSearchResultsPageClassic searchForARecordBasedOnId(String recordId) {

        sfObjectMethods.SFEnterTextInTextBox(searchInputLocator, recordId);
        sfObjectMethods.SFLinkOrButtonClick(searchButtonLocator);
        return new SFRecordSearchResultsPageClassic();
    }


}
