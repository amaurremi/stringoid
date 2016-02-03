package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.math.BigDecimal;

final class s
        extends TypeAdapter<BigDecimal> {
    public BigDecimal a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        try {
            paramJsonReader = new BigDecimal(paramJsonReader.nextString());
            return paramJsonReader;
        } catch (NumberFormatException paramJsonReader) {
            throw new JsonSyntaxException(paramJsonReader);
        }
    }

    public void a(JsonWriter paramJsonWriter, BigDecimal paramBigDecimal) {
        paramJsonWriter.value(paramBigDecimal);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */