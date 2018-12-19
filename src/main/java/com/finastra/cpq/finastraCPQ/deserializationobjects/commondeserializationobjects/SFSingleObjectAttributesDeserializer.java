package com.finastra.cpq.finastraCPQ.deserializationobjects.commondeserializationobjects;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFObjectResponseAttributes;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SFSingleObjectAttributesDeserializer implements JsonDeserializer<SFObjectResponseAttributes> {
    @Override
    public SFObjectResponseAttributes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        final String type = jsonObject.get("type").getAsString();
        final String url = jsonObject.get("url").getAsString();

        final SFObjectResponseAttributes sfObjectResponseAttributes = new SFObjectResponseAttributes();
        sfObjectResponseAttributes.setType(type);
        sfObjectResponseAttributes.setUrl(url);
        return sfObjectResponseAttributes;
    }
}
