package com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons;

import com.finastra.cpq.finastraCPQ.SFObjectHandling.SFObjectMethods;
import com.finastra.cpq.finastraCPQ.initializers.SFDCAPIAutomationSpec;
import com.finastra.cpq.finastraCPQ.initializers.SFDCUIAutomationSpec;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;
import com.finastra.cpq.finastraCPQ.utilities.ApplicationContextProvider;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("base")
@DependsOn("context")
public class Context {


    protected WebDriver driver;
    protected static String apiAccessToken;
    protected static String apiBaseHost;
    protected static String tokenType;

    @Autowired
    protected SFObjectMethods sfObjectMethods;


    public Context() {
        this.driver = ApplicationContextProvider.getApplicationContext().getBean(SFDCUIAutomationSpec.class).getChromeDriver();
        this.apiAccessToken = ApplicationContextProvider.getApplicationContext().getBean(SFDCAPIAutomationSpec.class).getAccessToken();
        this.apiBaseHost = ApplicationContextProvider.getApplicationContext().getBean(SFDCAPIAutomationSpec.class).getBaseHost();
        RestAssured.baseURI = apiBaseHost;
        this.tokenType = ApplicationContextProvider.getApplicationContext().getBean(SFDCAPIAutomationSpec.class).getTokenType();
        RestAssured.basePath = "/services/data/v44.0/";
    }


    public List<SFPageSection> extractFieldsAndItsPropertiesInASection(String sectionName) {
        List<SFPageSection> allFieldsAndPropertiesInASection = new ArrayList<>();
        String sectionElementPart1 = "//h3[text()=";
        String sectionElementPart2 = "'" + sectionName + "']" + "/ancestor::div[starts-with(@id,'head')]/following-sibling::div[1]/table";
        By sectionElementLocator = By.xpath(sectionElementPart1 + sectionElementPart2);
        WebElement sectionElement = sfObjectMethods.SFReturnWebElement(sectionElementLocator);

        By tableRowElement = By.tagName("tr");
        By tableColumnElement = By.tagName("td");
        By scriptElementLocator = By.tagName("script");
        List<WebElement> fieldRowsInPreLogSection = sfObjectMethods.SFFindElementsWithinAWebElement(sectionElement, tableRowElement);
        SFPageSection tempPageSection = null;
        String columnName;
        Integer columnNumber;
        for (int j = 0; j < fieldRowsInPreLogSection.size(); j++) {
            WebElement eachRow = fieldRowsInPreLogSection.get(j);
            Integer rowNumber = -1;
            List<WebElement> columnElements = sfObjectMethods.SFFindElementsWithinAWebElement(eachRow, tableColumnElement);
            for (int i = 0; i < columnElements.size(); i++) {
                if (i == 0 || i == 1) {
                    if (i == 0) {
                        tempPageSection = new SFPageSection();
                        WebElement columnElement = columnElements.get(i);
                        columnName = columnElement.getText().trim();
                        rowNumber = j;
                        columnNumber = i;
                        if (!sfObjectMethods.SFIsElementPresentInsideWebElement(columnElement, scriptElementLocator)) {
                            tempPageSection.setHelpTextPresent(false);
                        } else {
                            tempPageSection.setHelpTextPresent(true);

                        }
                        tempPageSection.setColumnName(columnName);
                        tempPageSection.setRowNumber(rowNumber);
                        tempPageSection.setColumnNumber(columnNumber);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("empty") || (className.equals("labelCol") && columnElement.getText().trim().equals("")) || (className.contains("last") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                    } else {
                        WebElement columnElement = columnElements.get(i);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("Lock") || className.contains("empty") || (className.equals("dataCol") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                        allFieldsAndPropertiesInASection.add(tempPageSection);

                    }


                } else if (i == 2 || i == 3) {

                    if (i == 2) {
                        tempPageSection = new SFPageSection();
                        WebElement columnElement = columnElements.get(i);
                        columnName = columnElement.getText().trim();
                        rowNumber = j;
                        columnNumber = i;
                        if (!sfObjectMethods.SFIsElementPresentInsideWebElement(columnElement, scriptElementLocator)) {
                            tempPageSection.setHelpTextPresent(false);
                        } else {
                            tempPageSection.setHelpTextPresent(true);

                        }
                        tempPageSection.setColumnName(columnName);
                        tempPageSection.setRowNumber(rowNumber);
                        tempPageSection.setColumnNumber(columnNumber);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("empty") || (className.equals("labelCol") && columnElement.getText().trim().equals("")) || (className.contains("last") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }
                    } else {
                        WebElement columnElement = columnElements.get(i);
                        String className = columnElement.getAttribute("class");
                        if (className.contains("Lock") || className.contains("empty") || (className.equals("dataCol") && columnElement.getText().trim().equals(""))) {
                            tempPageSection.setFieldEditable(false);
                        } else {
                            tempPageSection.setFieldEditable(true);
                        }

                        allFieldsAndPropertiesInASection.add(tempPageSection);

                    }

                }
            }
        }

        return allFieldsAndPropertiesInASection;

    }

}