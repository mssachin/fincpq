package com.finastra.cpq.finastraCPQ.pageobjects.apiresponseobjects;

import com.finastra.cpq.finastraCPQ.deserializationobjects.commondeserializationobjects.SFSingleObjectAttributesDeserializer;
import com.finastra.cpq.finastraCPQ.deserializationobjects.sfsalesordersassociatedtoabillinggroupdeserializers.SFSalesOrdersDeserializer;
import com.finastra.cpq.finastraCPQ.deserializationobjects.sfsalesordersassociatedtoabillinggroupdeserializers.SFSingleSalesOrderDeserializer;
import com.finastra.cpq.finastraCPQ.deserializationobjects.sfsubscriptionsassociatedtoabillinggroupdeserializers.SFSingleSubscriptionDeserializer;
import com.finastra.cpq.finastraCPQ.deserializationobjects.sfsubscriptionsassociatedtoabillinggroupdeserializers.SFSubscriptionsDeserializer;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFObjectResponseAttributes;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSalesOrdersAssociatedToABillingGroup;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup.SFSingleSalesOrderDetailsJsonResponse;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSingleSubscriptionDetailsJsonResponse;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup.SFSubscriptionsAssociatedToABillingGroup;
import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import static io.restassured.RestAssured.given;

@Component
@DependsOn("base")
public class SFRubixAPIResponseObjects extends Context {


    public SFSubscriptionsAssociatedToABillingGroup getSubscriptionsAssociatedToABillingGroup(String billingGroupId, String query) throws UnsupportedEncodingException {
        InputStream sfSubscriptionsAssociatedToABillingGroupResponseAsInputStream = given().when().log().all().header("Authorization", tokenType + " " + apiAccessToken)
                .param("q", query + "'" + billingGroupId + "'")
                .get("query/").asInputStream();

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SFSubscriptionsAssociatedToABillingGroup.class, new SFSubscriptionsDeserializer());
        gsonBuilder.registerTypeAdapter(SFSingleSubscriptionDetailsJsonResponse.class, new SFSingleSubscriptionDeserializer());
        gsonBuilder.registerTypeAdapter(SFObjectResponseAttributes.class, new SFSingleObjectAttributesDeserializer());
        final Gson gson = gsonBuilder.create();

        Reader reader = new InputStreamReader(sfSubscriptionsAssociatedToABillingGroupResponseAsInputStream, "UTF-8");
        final SFSubscriptionsAssociatedToABillingGroup sfSubscriptionsAssociatedToABillingGroup = gson.fromJson(reader, SFSubscriptionsAssociatedToABillingGroup.class);

        return sfSubscriptionsAssociatedToABillingGroup;
    }


    public SFSalesOrdersAssociatedToABillingGroup getSalesOrdersAssociatedToABillingGroup(String billingGroupId, String query) throws UnsupportedEncodingException {
        InputStream sfSalesOrdersAssociatedToABillingGroupResponseAsInputStream = given().when().log().all().header("Authorization", tokenType + " " + apiAccessToken)
                .param("q", query + "'" + billingGroupId + "'" + " Order By CreatedDate DESC")
                .get("query/").asInputStream();

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SFSalesOrdersAssociatedToABillingGroup.class, new SFSalesOrdersDeserializer());
        gsonBuilder.registerTypeAdapter(SFSingleSalesOrderDetailsJsonResponse.class, new SFSingleSalesOrderDeserializer());
        gsonBuilder.registerTypeAdapter(SFObjectResponseAttributes.class, new SFSingleObjectAttributesDeserializer());
        final Gson gson = gsonBuilder.create();

        Reader reader = new InputStreamReader(sfSalesOrdersAssociatedToABillingGroupResponseAsInputStream, "UTF-8");
        final SFSalesOrdersAssociatedToABillingGroup sfSalesOrdersAssociatedToABillingGroup = gson.fromJson(reader, SFSalesOrdersAssociatedToABillingGroup.class);

        return sfSalesOrdersAssociatedToABillingGroup;
    }


    public void printSubscriptionsAssociatedToABillingGroup(String billingGroupId, String query) throws UnsupportedEncodingException {
        given().when().log().all().header("Authorization", tokenType + " " + apiAccessToken)
                .param("q", query + "'" + billingGroupId + "'")
                .get("query/").prettyPrint();


    }
}
