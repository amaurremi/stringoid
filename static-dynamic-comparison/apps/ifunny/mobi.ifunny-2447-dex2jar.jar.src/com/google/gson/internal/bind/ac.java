package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.sql.Timestamp;
import java.util.Date;

class ac
        extends TypeAdapter<Timestamp> {
    ac(ab paramab, TypeAdapter paramTypeAdapter) {
    }

    public Timestamp a(JsonReader paramJsonReader) {
        paramJsonReader = (Date) this.a.read(paramJsonReader);
        if (paramJsonReader != null) {
            return new Timestamp(paramJsonReader.getTime());
        }
        return null;
    }

    public void a(JsonWriter paramJsonWriter, Timestamp paramTimestamp) {
        this.a.write(paramJsonWriter, paramTimestamp);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */