package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

class k
        extends TypeAdapter<Number> {
    k(Gson paramGson) {
    }

    public Number a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return Long.valueOf(paramJsonReader.nextLong());
    }

    public void a(JsonWriter paramJsonWriter, Number paramNumber) {
        if (paramNumber == null) {
            paramJsonWriter.nullValue();
            return;
        }
        paramJsonWriter.value(paramNumber.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */