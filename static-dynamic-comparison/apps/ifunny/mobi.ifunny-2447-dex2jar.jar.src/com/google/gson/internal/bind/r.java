package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class r
        extends TypeAdapter<String> {
    public String a(JsonReader paramJsonReader) {
        JsonToken localJsonToken = paramJsonReader.peek();
        if (localJsonToken == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        if (localJsonToken == JsonToken.BOOLEAN) {
            return Boolean.toString(paramJsonReader.nextBoolean());
        }
        return paramJsonReader.nextString();
    }

    public void a(JsonWriter paramJsonWriter, String paramString) {
        paramJsonWriter.value(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */