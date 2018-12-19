package com.finastra.cpq.finastraCPQ.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilityMethods {

    private static final String currentTimeStamp = getCurrentTimeStampAsString();


    public static String addMonthsToAGivenDate(String dateSupplied, long numberOfMonthsToAdd) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateSuppliedToDate = LocalDate.parse(dateSupplied, dateTimeFormatter);
        LocalDate newDate = dateSuppliedToDate.plusMonths(numberOfMonthsToAdd);
        String newDateAsString = newDate.format(dateTimeFormatter);
        return newDateAsString;
    }

    public static String addYearsToAGivenDate(String dateSupplied, long numberOfYearsToAdd){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateSuppliedToDate = LocalDate.parse(dateSupplied, dateTimeFormatter);
        LocalDate newDate = dateSuppliedToDate.plusYears(numberOfYearsToAdd);
        String newDateAsString = newDate.format(dateTimeFormatter);
        return newDateAsString;
    }

    public static String subtractDaysFromAGivenDate(String dateSupplied, long numberOfDaysToSubtract){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateSuppliedToDate = LocalDate.parse(dateSupplied, dateTimeFormatter);
        LocalDate newDate = dateSuppliedToDate.minusDays(numberOfDaysToSubtract);
        String newDateAsString = newDate.format(dateTimeFormatter);
        return newDateAsString;
    }

    public static String addDaysFromAGivenDate(String dateSupplied, long numberOfDaysToAdd){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateSuppliedToDate = LocalDate.parse(dateSupplied, dateTimeFormatter);
        LocalDate newDate = dateSuppliedToDate.plusDays(numberOfDaysToAdd);
        String newDateAsString = newDate.format(dateTimeFormatter);
        return newDateAsString;
    }


    public static String returnDateTodayAsString() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateToday = simpleDateFormatter.format(date);
        return dateToday;
    }

    public static void logInfoToAStep(ExtentTest test, String imageAsBase64String) throws IOException {
        test.log(Status.INFO, test.getClass().getSimpleName(), MediaEntityBuilder.createScreenCaptureFromBase64String(imageAsBase64String).build());
    }

    public static String getCurrentTimeStampAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String currentTime = sdf.format(timestamp);
        return currentTime;
    }

    public static File getCurrentReportingDirectory() {
        File reportsDirectory = new File(System.getProperty("user.dir") + "//src//test/resources//reportsDirectory");
        if (!reportsDirectory.exists()) {
            reportsDirectory.mkdir();
        }
        File currentExecutionReportDirectory = new File(System.getProperty("user.dir") + "//src//test/resources//reportsDirectory//AutomationExecutionReport " + currentTimeStamp);
        if (!currentExecutionReportDirectory.exists()) {
            currentExecutionReportDirectory.mkdir();
        }
        return currentExecutionReportDirectory;
    }

    public static File getCurrentReportPath() {
        File currentReportingDirectory = getCurrentReportingDirectory();
        File reportFile = new File(currentReportingDirectory.getAbsolutePath() + "//AutomationTestReport " + currentTimeStamp + ".html");
        return reportFile;
    }
}
