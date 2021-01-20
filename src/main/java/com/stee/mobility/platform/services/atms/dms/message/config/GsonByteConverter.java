package com.stee.mobility.platform.services.atms.dms.message.config;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author ZhouHu
 * @since 2020-06-22 19:33
 **/
public class GsonByteConverter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
    @Override
    public byte[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsString().getBytes();
    }

    @Override
    public JsonElement serialize(byte[] src, Type type, JsonSerializationContext jsonSerializationContext) {
        if (src == null) {
            return null;
        }
        return new JsonPrimitive(new String(src));
    }
}
