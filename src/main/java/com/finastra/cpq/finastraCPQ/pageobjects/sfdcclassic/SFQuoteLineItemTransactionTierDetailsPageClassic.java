package com.finastra.cpq.finastraCPQ.pageobjects.sfdcclassic;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import org.openqa.selenium.By;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@DependsOn("base")
public class SFQuoteLineItemTransactionTierDetailsPageClassic extends Context {


    private static final By priceFieldValueLocator = By.id("00N3E000000Ujja_ileinner");
    private static final By unitPriceFieldValueLocator = By.id("00N3E000000Ujjk_ileinner");
    private static final By minimumPriceFieldValueLocator = By.id("00N3E000000UjjZ_ileinner");
    private static final By quoteLineDetailSection = By.className("mainTitle");


    public String extractPriceFromQuoteLineItem() {
        String priceAndCurrencyAsString = sfObjectMethods.SFExtractTextFromWebElement(priceFieldValueLocator);
        String[] priceAndCurrencyArr = priceAndCurrencyAsString.split(" ");
        String price = priceAndCurrencyArr[1].replace(",", "");
        return price;
    }

    public String extractUnitPriceFromQuoteLineItem() {
        String unitPriceAndCurrencyAsString = sfObjectMethods.SFExtractTextFromWebElement(unitPriceFieldValueLocator);
        String[] unitPriceAndCurrencyArr = unitPriceAndCurrencyAsString.split(" ");
        String unitPrice = unitPriceAndCurrencyArr[1].replace(",", "");
        return unitPrice;
    }

    public String extractMinimumPriceFromQuoteLineItem() {
        String minimumPriceWithCurrencyAsString = sfObjectMethods.SFExtractTextFromWebElement(minimumPriceFieldValueLocator);
        String[] minimumPriceAndCurrencyArr = minimumPriceWithCurrencyAsString.split(" ");
        String minimumPrice = minimumPriceAndCurrencyArr[1].replace(",", "");
        return minimumPrice;
    }

    public String captureQuoteLinePricingDetails() {
        String base64Screenshot = null;
        try {
            base64Screenshot = sfObjectMethods.captureWebElementScreenshot(quoteLineDetailSection, "Quote Line Pricing Details");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Screenshot;
    }
}
