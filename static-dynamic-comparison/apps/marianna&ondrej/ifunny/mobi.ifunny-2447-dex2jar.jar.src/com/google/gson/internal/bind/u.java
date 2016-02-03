package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class u
        extends TypeAdapter<StringBuilder> {
    public StringBuilder a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return new StringBuilder(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, StringBuilder paramStringBuilder) {
        if (paramStringBuilder == null) {
        }
        for (paramStringBuilder = null; ; paramStringBuilder = paramStringBuilder.toString()) {
            paramJsonWriter.value(paramStringBuilder);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */