package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

class i
        extends TypeAdapter<Number> {
    i(Gson paramGson) {
    }

    public Double a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return Double.valueOf(paramJsonReader.nextDouble());
    }

    public void a(JsonWriter paramJsonWriter, Number paramNumber) {
        if (paramNumber == null) {
            paramJsonWriter.nullValue();
            return;
        }
        double d = paramNumber.doubleValue();
        Gson.access$000(this.a, d);
        paramJsonWriter.value(paramNumber);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */