package com.finastra.cpq.finastraCPQ.deserializationobjects.sfsubscriptionsassociatedtoabillinggroupdeserializers;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSingleSubscriptionDetailsJsonResponse;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSubscriptionsAssociatedToABillingGroup;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SFSubscriptionsDeserializer implements JsonDeserializer<SFSubscriptionsAssociatedToABillingGroup> {
    @Override
    public SFSubscriptionsAssociatedToABillingGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        final Integer totalSize = jsonObject.get("totalSize").getAsInt();
        final boolean done = jsonObject.get("done").getAsBoolean();
        SFSingleSubscriptionDetailsJsonResponse[] records = context.deserialize(jsonObject.get("records"), SFSingleSubscriptionDetailsJsonResponse[].class);

        final SFSubscriptionsAssociatedToABillingGroup sfSubscriptionsAssociatedToABillingGroup = new SFSubscriptionsAssociatedToABillingGroup();
        sfSubscriptionsAssociatedToABillingGroup.setTotalSize(totalSize);
        sfSubscriptionsAssociatedToABillingGroup.setDone(done);
        sfSubscriptionsAssociatedToABillingGroup.setRecords(records);

        return sfSubscriptionsAssociatedToABillingGroup;

    }
}
