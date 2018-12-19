package com.finastra.cpq.finastraCPQ.deserializationobjects.sfsubscriptionsassociatedtoabillinggroupdeserializers;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFObjectResponseAttributes;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSingleSubscriptionDetailsJsonResponse;
import com.google.gson.*;

import java.lang.reflect.Type;


public class SFSingleSubscriptionDeserializer implements JsonDeserializer<SFSingleSubscriptionDetailsJsonResponse> {

    @Override
    public SFSingleSubscriptionDetailsJsonResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        SFObjectResponseAttributes sfObjectResponseAttributes = context.deserialize(jsonObject.get("attributes"), SFObjectResponseAttributes.class);
        final JsonElement nullableNextBillingDate = jsonObject.get("Next_Billing_Date__c");
        final String nextBillingDate = (nullableNextBillingDate instanceof JsonNull) ? "" : nullableNextBillingDate.getAsString();
        final JsonElement nullableNextSOGenerationDate = jsonObject.get("Next_SO_generation_Date__c");
        final String nextSOGenerationDate = (nullableNextSOGenerationDate instanceof JsonNull) ? "" : nullableNextSOGenerationDate.getAsString();
        final SFSingleSubscriptionDetailsJsonResponse sfSingleSubscriptionDetailsJsonResponse = new SFSingleSubscriptionDetailsJsonResponse();
        final JsonElement nullableRecurringNSItem = jsonObject.get("Recurring_NS_Item__c");
        final String recurringNSItem = (nullableRecurringNSItem instanceof JsonNull) ? "" : nullableRecurringNSItem.getAsString();
        final JsonElement nullableRecurringSalesOrderType = jsonObject.get("Recurring_Sales_Order_Type__c");
        final String recurringSalesOrderType = (nullableRecurringSalesOrderType instanceof JsonNull) ? "" : nullableRecurringSalesOrderType.getAsString();

        sfSingleSubscriptionDetailsJsonResponse.setSFObjectResponseAttributes(sfObjectResponseAttributes);
        sfSingleSubscriptionDetailsJsonResponse.setNextBillingDate(nextBillingDate);
        sfSingleSubscriptionDetailsJsonResponse.setNextSOGenerationDate(nextSOGenerationDate);
        sfSingleSubscriptionDetailsJsonResponse.setRecurringNSItem(recurringNSItem);
        sfSingleSubscriptionDetailsJsonResponse.setRecurringSalesOrderType(recurringSalesOrderType);

        return sfSingleSubscriptionDetailsJsonResponse;
    }

}