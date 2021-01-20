package com.stee.mobility.platform.services.atms.dms.message.utils;

import com.google.gson.*;
import com.stee.mobility.platform.services.atms.dms.message.config.GsonByteConverter;
import com.stee.mobility.platform.services.atms.dms.message.config.PresetPositionZonedDateTimeConverter;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GsonUtils {
    public static final double GSON_VERSION = 1.0;

    public static Gson getGsonInstance() {
        return new GsonBuilder().
                registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                    @Override
                    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                        if (src == src.longValue()) {
                            return new JsonPrimitive(src.longValue());
                        }
                        return new JsonPrimitive(src);
                    }
                }).registerTypeAdapter(ZonedDateTime.class, new JsonSerializer<ZonedDateTime>() {
            @Override
            public JsonElement serialize(ZonedDateTime zonedDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                return new JsonPrimitive(zonedDateTime.format(fmt));
            }
        }).registerTypeAdapter(ZonedDateTime.class, new JsonDeserializer<ZonedDateTime>() {
            @Override
            public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());
                return ZonedDateTime.parse(jsonElement.getAsString(), fmt);
            }
        }).setVersion(GSON_VERSION).create();
    }

    public static Gson getPresetPositionGson() {
        return new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new PresetPositionZonedDateTimeConverter())
                .registerTypeAdapter(byte[].class, new GsonByteConverter())
                .setVersion(GSON_VERSION)
                .serializeNulls()
                .create();
    }


    public static Gson getPtzGson() {
        return new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new PresetPositionZonedDateTimeConverter())
                .registerTypeAdapter(byte[].class, new GsonByteConverter())
                .setVersion(GSON_VERSION)
                .create();
    }

}
