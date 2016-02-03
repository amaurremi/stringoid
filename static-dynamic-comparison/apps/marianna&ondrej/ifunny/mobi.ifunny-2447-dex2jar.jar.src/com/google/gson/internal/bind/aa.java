package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.util.UUID;

final class aa
        extends TypeAdapter<UUID> {
    public UUID a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return UUID.fromString(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, UUID paramUUID) {
        if (paramUUID == null) {
        }
        for (paramUUID = null; ; paramUUID = paramUUID.toString()) {
            paramJsonWriter.value(paramUUID);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */