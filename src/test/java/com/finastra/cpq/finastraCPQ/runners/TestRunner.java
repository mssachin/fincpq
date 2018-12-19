package com.finastra.cpq.finastraCPQ.runners;


import com.finastra.cpq.finastraCPQ.initializers.SFDCUIAutomationSpec;
import com.finastra.cpq.finastraCPQ.utilities.ApplicationContextProvider;
import com.finastra.cpq.finastraCPQ.utilities.UtilityMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = {"com.finastra.cpq.finastraCPQ.stepdefinitions",
                "com.finastra.cpq.finastraCPQ.utilities"},
        tags = {"@Profiles"}
)
public class TestRunner {

    @BeforeClass
    public static void removeExistingObjects() {
        UtilityMethods.getCurrentReportPath();
    }


    @AfterClass
    public static void tearDown() {
        ApplicationContextProvider.getApplicationContext().getBean(SFDCUIAutomationSpec.class).getChromeDriver().quit();
    }


}
