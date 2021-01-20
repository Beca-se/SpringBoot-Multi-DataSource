package com.stee.mobility.platform.services.atms.dms.message.config;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ZhouHu
 * @since 2020-06-22 19:36
 **/
public class PresetPositionZonedDateTimeConverter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());
    ;

    public PresetPositionZonedDateTimeConverter() {
    }

    @Override
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return null;
        }
        return new JsonPrimitive(FORMATTER.format(src));
    }

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return ZonedDateTime.parse(json.getAsString(), FORMATTER);
        } catch (Exception var5) {
            return null;
        }
    }


}
