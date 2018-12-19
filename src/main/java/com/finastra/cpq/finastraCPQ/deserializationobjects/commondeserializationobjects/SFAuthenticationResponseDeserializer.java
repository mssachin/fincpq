package com.finastra.cpq.finastraCPQ.deserializationobjects.commondeserializationobjects;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFAuthenticationResponse;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SFAuthenticationResponseDeserializer implements JsonDeserializer<SFAuthenticationResponse> {
    @Override
    public SFAuthenticationResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final String accessToken = jsonObject.get("access_token").getAsString();
        final String instanceURL = jsonObject.get("instance_url").getAsString();
        final String id = jsonObject.get("id").getAsString();
        final String tokenType = jsonObject.get("token_type").getAsString();
        final String issuedAt = jsonObject.get("issued_at").getAsString();
        final String signature = jsonObject.get("signature").getAsString();

        final SFAuthenticationResponse sfAuthenticationResponse = new SFAuthenticationResponse();
        sfAuthenticationResponse.setAccessToken(accessToken);
        sfAuthenticationResponse.setInstanceURL(instanceURL);
        sfAuthenticationResponse.setId(id);
        sfAuthenticationResponse.setTokenType(tokenType);
        sfAuthenticationResponse.setIssuedAt(issuedAt);
        sfAuthenticationResponse.setSignature(signature);

        return sfAuthenticationResponse;
    }
}
