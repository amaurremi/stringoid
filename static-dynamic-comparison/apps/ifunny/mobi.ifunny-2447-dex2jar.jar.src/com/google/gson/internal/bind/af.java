package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class af
        extends TypeAdapter<JsonElement> {
    public JsonElement a(JsonReader paramJsonReader) {
        switch (an.a[paramJsonReader.peek().ordinal()]) {
            default:
                throw new IllegalArgumentException();
            case 3:
                return new JsonPrimitive(paramJsonReader.nextString());
            case 1:
                return new JsonPrimitive(new LazilyParsedNumber(paramJsonReader.nextString()));
            case 2:
                return new JsonPrimitive(Boolean.valueOf(paramJsonReader.nextBoolean()));
            case 4:
                paramJsonReader.nextNull();
                return JsonNull.INSTANCE;
            case 5:
                localObject = new JsonArray();
                paramJsonReader.beginArray();
                while (paramJsonReader.hasNext()) {
                    ((JsonArray) localObject).add(a(paramJsonReader));
                }
                paramJsonReader.endArray();
                return (JsonElement) localObject;
        }
        Object localObject = new JsonObject();
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext()) {
            ((JsonObject) localObject).add(paramJsonReader.nextName(), a(paramJsonReader));
        }
        paramJsonReader.endObject();
        return (JsonElement) localObject;
    }

    public void a(JsonWriter paramJsonWriter, JsonElement paramJsonElement) {
        if ((paramJsonElement == null) || (paramJsonElement.isJsonNull())) {
            paramJsonWriter.nullValue();
            return;
        }
        if (paramJsonElement.isJsonPrimitive()) {
            paramJsonElement = paramJsonElement.getAsJsonPrimitive();
            if (paramJsonElement.isNumber()) {
                paramJsonWriter.value(paramJsonElement.getAsNumber());
                return;
            }
            if (paramJsonElement.isBoolean()) {
                paramJsonWriter.value(paramJsonElement.getAsBoolean());
                return;
            }
            paramJsonWriter.value(paramJsonElement.getAsString());
            return;
        }
        if (paramJsonElement.isJsonArray()) {
            paramJsonWriter.beginArray();
            paramJsonElement = paramJsonElement.getAsJsonArray().iterator();
            while (paramJsonElement.hasNext()) {
                a(paramJsonWriter, (JsonElement) paramJsonElement.next());
            }
            paramJsonWriter.endArray();
            return;
        }
        if (paramJsonElement.isJsonObject()) {
            paramJsonWriter.beginObject();
            paramJsonElement = paramJsonElement.getAsJsonObject().entrySet().iterator();
            while (paramJsonElement.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramJsonElement.next();
                paramJsonWriter.name((String) localEntry.getKey());
                a(paramJsonWriter, (JsonElement) localEntry.getValue());
            }
            paramJsonWriter.endObject();
            return;
        }
        throw new IllegalArgumentException("Couldn't write " + paramJsonElement.getClass());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */