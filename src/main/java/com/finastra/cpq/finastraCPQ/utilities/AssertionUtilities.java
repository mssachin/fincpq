package com.finastra.cpq.finastraCPQ.utilities;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.finastra.cpq.finastraCPQ.testdataobjects.SFPageSection;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AssertionUtilities {

    public static void assertStringEquals(String expected, String actual, ExtentTest test, String imageAsBase64String) throws IOException {
        try {
            assertEquals(expected, actual);
            test.log(Status.PASS, "Pass: " + expected + " and actual " + actual + " match", MediaEntityBuilder.createScreenCaptureFromBase64String(imageAsBase64String).build());
        } catch (AssertionError ae) {
            test.log(Status.FAIL, "Fail: " + ae.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(imageAsBase64String).build());
        }
    }

    public static void assertIntEquals(int expected, int actual, ExtentTest test) {
        try {
            assertEquals(expected, actual);
            test.log(Status.PASS, "Pass: " + expected + " and actual " + actual + " match");
        } catch (AssertionError ae) {
            test.log(Status.FAIL, "Fail: " + ae.getMessage());
        }
    }

    public static void assertDoubleEquals(Double expected, Double actual, ExtentTest test, String imageAsBase64String) throws IOException {
        try {
            assertEquals(expected, actual, 0.20);
            test.log(Status.PASS, "Pass: " + expected + " and actual " + actual + " match with a delta of 0.20" + " Actual Difference " + String.valueOf(expected - actual));
        }catch (AssertionError ae){
            if (!imageAsBase64String.equals("")) {
                test.log(Status.FAIL, "Fail: " + ae.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(imageAsBase64String).build());
            } else {
                test.log(Status.FAIL, "Fail: " + ae.getMessage());
            }
        }

    }

    public static void assertListEquals(List<SFPageSection> expected, List<SFPageSection> actual, ExtentTest test, String imageAsBase64String) throws IOException {

        if (expected.size() != actual.size()) {
            try {
                assertEquals(expected.size(), actual.size());
            } catch (AssertionError ae) {
                test.log(Status.FAIL, "Fail: " + ae.getMessage());
            }

        } else {
            for (int i = 0; i < expected.size(); i++) {
                SFPageSection expectedPageSectionField = expected.get(i);
                SFPageSection actualPageSectionField = actual.get(i);
                try {
                    assertEquals(expectedPageSectionField, actualPageSectionField);
                    test.log(Status.PASS, "Pass: Expected " + expectedPageSectionField + "\n" + " and actual " + actualPageSectionField + " match");
                } catch (AssertionError ae) {
                    if (!imageAsBase64String.equals("")) {
                        test.log(Status.FAIL, "Fail: " + ae.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(imageAsBase64String).build());
                    } else {
                        test.log(Status.FAIL, "Fail: " + "Expected Was " + expectedPageSectionField.toString() + "\n" + " Actual was " + actualPageSectionField.toString());

                    }
                }
            }
        }
    }
}
