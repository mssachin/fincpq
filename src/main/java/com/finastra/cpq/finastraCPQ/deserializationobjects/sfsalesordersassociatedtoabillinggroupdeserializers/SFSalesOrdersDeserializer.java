package com.finastra.cpq.finastraCPQ.deserializationobjects.sfsalesordersassociatedtoabillinggroupdeserializers;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSalesOrdersAssociatedToABillingGroup;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSingleSalesOrderDetailsJsonResponse;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SFSalesOrdersDeserializer implements JsonDeserializer<SFSalesOrdersAssociatedToABillingGroup> {
    @Override
    public SFSalesOrdersAssociatedToABillingGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        final Integer totalSize = jsonObject.get("totalSize").getAsInt();
        final boolean done = jsonObject.get("done").getAsBoolean();
        SFSingleSalesOrderDetailsJsonResponse[] sfSingleSalesOrderDetailsJsonResponses = context.deserialize(jsonObject.get("records"), SFSingleSalesOrderDetailsJsonResponse[].class);

        SFSalesOrdersAssociatedToABillingGroup sfSalesOrdersAssociatedToABillingGroup = new SFSalesOrdersAssociatedToABillingGroup();
        sfSalesOrdersAssociatedToABillingGroup.setTotalSize(totalSize);
        sfSalesOrdersAssociatedToABillingGroup.setDone(done);
        sfSalesOrdersAssociatedToABillingGroup.setRecords(sfSingleSalesOrderDetailsJsonResponses);
        return sfSalesOrdersAssociatedToABillingGroup;
    }
}
