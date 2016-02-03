package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

abstract class j {
    final String g;
    final boolean h;
    final boolean i;

    protected j(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        this.g = paramString;
        this.h = paramBoolean1;
        this.i = paramBoolean2;
    }

    abstract void a(JsonReader paramJsonReader, Object paramObject);

    abstract void a(JsonWriter paramJsonWriter, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */