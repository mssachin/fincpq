package com.finastra.cpq.finastraCPQ.initializers;


import com.finastra.cpq.finastraCPQ.deserializationobjects.commondeserializationobjects.SFAuthenticationResponseDeserializer;
import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFAuthenticationResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import static io.restassured.RestAssured.given;

@Component
public class SFDCAPIAutomationSpec {

    private static final String grantType = "password";
    private static final String clientId = "3MVG92H4TjwUcLlJuQLVGHYmUpTjlMl6Em4jW0OebsyEL.iX9pSDj15LU.g54QU1k6RfOjJnkp49Nu0uDv5JD";
    private static final String clientSecret = "3444511262404092636";
    private static final String userName = "sachin.mylavarapu@finastra.com.finsit";
    private static final String password = "Finastra^%21DlYc0dO40rwx6GL0t2MQfjkEF";

    @Getter(AccessLevel.PUBLIC)
    private String accessToken;

    @Getter(AccessLevel.PUBLIC)
    private String baseHost;

    @Getter(AccessLevel.PUBLIC)
    private String tokenType;


    public SFDCAPIAutomationSpec() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SFAuthenticationResponse.class, new SFAuthenticationResponseDeserializer());
        final Gson gson = gsonBuilder.create();
        InputStream sfAuthenticationResponse = given().when().param("grant_type", grantType)
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("username", userName)
                .param("password", password)
                .post("https://test.salesforce.com/services/oauth2/token").asInputStream();
        try {
            Reader reader = new InputStreamReader(sfAuthenticationResponse, "UTF-8");
            final SFAuthenticationResponse sfAuthenticationResponseAsObject = gson.fromJson(reader, SFAuthenticationResponse.class);
            this.accessToken = sfAuthenticationResponseAsObject.getAccessToken();
            this.baseHost = sfAuthenticationResponseAsObject.getInstanceURL();
            this.tokenType = sfAuthenticationResponseAsObject.getTokenType();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}