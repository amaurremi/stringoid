package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

class j
        extends TypeAdapter<Number> {
    j(Gson paramGson) {
    }

    public Float a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return Float.valueOf((float) paramJsonReader.nextDouble());
    }

    public void a(JsonWriter paramJsonWriter, Number paramNumber) {
        if (paramNumber == null) {
            paramJsonWriter.nullValue();
            return;
        }
        float f = paramNumber.floatValue();
        Gson.access$000(this.a, f);
        paramJsonWriter.value(paramNumber);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */