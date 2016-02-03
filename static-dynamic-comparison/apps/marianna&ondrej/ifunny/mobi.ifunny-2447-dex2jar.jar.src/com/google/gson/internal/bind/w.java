package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.net.URL;

final class w
        extends TypeAdapter<URL> {
    public URL a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
        }
        do {
            return null;
            paramJsonReader = paramJsonReader.nextString();
        } while ("null".equals(paramJsonReader));
        return new URL(paramJsonReader);
    }

    public void a(JsonWriter paramJsonWriter, URL paramURL) {
        if (paramURL == null) {
        }
        for (paramURL = null; ; paramURL = paramURL.toExternalForm()) {
            paramJsonWriter.value(paramURL);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */