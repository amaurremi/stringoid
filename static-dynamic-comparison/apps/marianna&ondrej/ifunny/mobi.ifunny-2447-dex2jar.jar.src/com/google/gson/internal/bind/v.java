package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class v
        extends TypeAdapter<StringBuffer> {
    public StringBuffer a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return new StringBuffer(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, StringBuffer paramStringBuffer) {
        if (paramStringBuffer == null) {
        }
        for (paramStringBuffer = null; ; paramStringBuffer = paramStringBuffer.toString()) {
            paramJsonWriter.value(paramStringBuffer);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */