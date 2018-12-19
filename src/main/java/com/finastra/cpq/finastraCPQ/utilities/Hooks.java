package com.finastra.cpq.finastraCPQ.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hooks {

    private static final ExtentReports extentReports = new ExtentReports();

    private static ExtentTest feature;

    @Getter
    private static ExtentTest currentScenario;

    private static List<String> allFeaturesList = new ArrayList<>();

    @Before
    public void initializeEnvironment(cucumber.api.Scenario scenario) {
        String featureAndScenarioText = scenario.getId();
        String[] featureAndScenarioAsArr = featureAndScenarioText.split(";");
        String featureName = featureAndScenarioAsArr[0].replaceAll("-", " ").toUpperCase();
        String scenarioName = scenario.getName();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(UtilityMethods.getCurrentReportPath().getAbsoluteFile());
        htmlReporter.loadConfig(System.getProperty("user.dir") + "//extent-config.xml");
        extentReports.attachReporter(htmlReporter);
        if (!allFeaturesList.contains(featureName)) {
            feature = extentReports.createTest(Feature.class, featureName);
            currentScenario = feature.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class, scenarioName);
        } else {
            currentScenario = feature.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class, scenarioName);
        }
        allFeaturesList.add(featureName);
    }


    @After
    public void tearDown() {
        extentReports.flush();
    }

}
