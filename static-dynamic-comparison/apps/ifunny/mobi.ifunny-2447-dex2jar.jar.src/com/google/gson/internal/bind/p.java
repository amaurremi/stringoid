package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class p
        extends TypeAdapter<Number> {
    public Number a(JsonReader paramJsonReader) {
        JsonToken localJsonToken = paramJsonReader.peek();
        switch (an.a[localJsonToken.ordinal()]) {
            case 2:
            case 3:
            default:
                throw new JsonSyntaxException("Expecting number, got: " + localJsonToken);
            case 4:
                paramJsonReader.nextNull();
                return null;
        }
        return new LazilyParsedNumber(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, Number paramNumber) {
        paramJsonWriter.value(paramNumber);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */