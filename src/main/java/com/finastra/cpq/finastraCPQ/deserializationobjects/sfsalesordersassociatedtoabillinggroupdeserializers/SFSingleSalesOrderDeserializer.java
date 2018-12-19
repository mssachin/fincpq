package com.finastra.cpq.finastraCPQ.deserializationobjects.sfsalesordersassociatedtoabillinggroupdeserializers;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFObjectResponseAttributes;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSingleSalesOrderDetailsJsonResponse;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SFSingleSalesOrderDeserializer implements JsonDeserializer<SFSingleSalesOrderDetailsJsonResponse> {
    @Override
    public SFSingleSalesOrderDetailsJsonResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        SFObjectResponseAttributes sfObjectResponseAttributes = context.deserialize(jsonObject.get("attributes"), SFObjectResponseAttributes.class);
        final String orderType = jsonObject.get("Order_Type__c").getAsString();
        final Integer totalAmount = jsonObject.get("Total_Amount__c").getAsInt();
        final String orderStatus = jsonObject.get("Order_Status__c").getAsString();

        final SFSingleSalesOrderDetailsJsonResponse sfSingleSalesOrderDetailsJsonResponse = new SFSingleSalesOrderDetailsJsonResponse();
        sfSingleSalesOrderDetailsJsonResponse.setSFObjectResponseAttributes(sfObjectResponseAttributes);
        sfSingleSalesOrderDetailsJsonResponse.setOrderType(orderType);
        sfSingleSalesOrderDetailsJsonResponse.setTotalAmount(totalAmount);
        sfSingleSalesOrderDetailsJsonResponse.setOrderStatus(orderStatus);

        return sfSingleSalesOrderDetailsJsonResponse;
    }
}
