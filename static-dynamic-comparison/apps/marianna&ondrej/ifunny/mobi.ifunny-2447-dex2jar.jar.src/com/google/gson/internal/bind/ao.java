package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class ao
        extends TypeAdapter<Boolean> {
    public Boolean a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return Boolean.valueOf(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, Boolean paramBoolean) {
        if (paramBoolean == null) {
        }
        for (paramBoolean = "null"; ; paramBoolean = paramBoolean.toString()) {
            paramJsonWriter.value(paramBoolean);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */