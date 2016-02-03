package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

class r
        extends TypeAdapter<T> {
    r(TypeAdapter paramTypeAdapter) {
    }

    public T read(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return (T) this.a.read(paramJsonReader);
    }

    public void write(JsonWriter paramJsonWriter, T paramT) {
        if (paramT == null) {
            paramJsonWriter.nullValue();
            return;
        }
        this.a.write(paramJsonWriter, paramT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */