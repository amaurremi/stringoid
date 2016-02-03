package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class at
        extends TypeAdapter<Number> {
    public Number a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return Float.valueOf((float) paramJsonReader.nextDouble());
    }

    public void a(JsonWriter paramJsonWriter, Number paramNumber) {
        paramJsonWriter.value(paramNumber);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */