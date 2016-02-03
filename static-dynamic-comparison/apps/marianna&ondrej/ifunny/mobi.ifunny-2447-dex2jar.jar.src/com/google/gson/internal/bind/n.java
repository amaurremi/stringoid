package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class n
        extends TypeAdapter<Class> {
    public Class a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void a(JsonWriter paramJsonWriter, Class paramClass) {
        if (paramClass == null) {
            paramJsonWriter.nullValue();
            return;
        }
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */