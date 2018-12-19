package com.finastra.cpq.finastraCPQ;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestClass {

    private static double calculateUpliftFactor(String upliftStartDate, String upliftAnnualEffectiveDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate upliftStartDateAsLocalDate = LocalDate.parse(upliftStartDate, dateTimeFormatter);
        LocalDate upliftAnnualEffectiveDateAsLocalDate = LocalDate.parse(upliftAnnualEffectiveDate, dateTimeFormatter);
        int numberOfDaysInTheCurrentBillingPeriod = upliftAnnualEffectiveDateAsLocalDate.lengthOfMonth();
        int daysBetweenUpliftStartDateAndEffectiveDate = (int) (ChronoUnit.DAYS.between(upliftAnnualEffectiveDateAsLocalDate, upliftStartDateAsLocalDate));
        int daysOfProRation = numberOfDaysInTheCurrentBillingPeriod - daysBetweenUpliftStartDateAndEffectiveDate;
        double upliftFactor = 1 + (daysOfProRation * (3.9 / 100)) / numberOfDaysInTheCurrentBillingPeriod;

        return upliftFactor;


    }

    @Test
    public void initiateChromeDriver() throws ParseException {
/*
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate upliftStartDate = LocalDate.parse("12/06/2018", dateTimeFormatter);
        System.out.println("Start "+upliftStartDate);
        LocalDate upliftAnnualEffectiveDate = LocalDate.parse("10/06/2018", dateTimeFormatter);
        System.out.println("Effective "+upliftAnnualEffectiveDate);
        LocalDate upliftEffectiveDatePlusMonth =  upliftAnnualEffectiveDate.plusMonths(1);
        System.out.println("Plustmonth "+upliftEffectiveDatePlusMonth);
        double differenceInt = (double) ChronoUnit.DAYS.between(upliftAnnualEffectiveDate, upliftEffectiveDatePlusMonth);
        System.out.println("Different dates "+differenceInt);
        double intDays = (double)ChronoUnit.DAYS.between(upliftAnnualEffectiveDate, upliftStartDate);
        System.out.println("Different dates int "+intDays);
        double differenceRatio= (1-(intDays/differenceInt));
        System.out.println("Ratio is "+differenceRatio);
        double factor = 1+ ((differenceRatio*3.9)/100);
        System.out.println("Factor is "+factor);
        double factor = calculateUpliftFactor("12/06/2018", "01/06/2018");
        System.out.println("Factor is " + factor);*/

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        //list1.add(null);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        //list1.add(null);
        Collections.sort(list1);
        Collections.sort(list2);

        Assert.assertEquals(list1, list2);


    }
}
