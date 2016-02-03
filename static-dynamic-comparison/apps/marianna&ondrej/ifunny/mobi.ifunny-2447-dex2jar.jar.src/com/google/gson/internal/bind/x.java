package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.net.URI;
import java.net.URISyntaxException;

final class x
        extends TypeAdapter<URI> {
    public URI a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
        }
        for (; ; ) {
            return null;
            try {
                paramJsonReader = paramJsonReader.nextString();
                if ("null".equals(paramJsonReader)) {
                    continue;
                }
                paramJsonReader = new URI(paramJsonReader);
                return paramJsonReader;
            } catch (URISyntaxException paramJsonReader) {
                throw new JsonIOException(paramJsonReader);
            }
        }
    }

    public void a(JsonWriter paramJsonWriter, URI paramURI) {
        if (paramURI == null) {
        }
        for (paramURI = null; ; paramURI = paramURI.toASCIIString()) {
            paramJsonWriter.value(paramURI);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */