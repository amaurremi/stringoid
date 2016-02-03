package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Field;

class i
        extends j {
    final TypeAdapter<?> a = ReflectiveTypeAdapterFactory.access$100(this.f, this.b, this.c, this.d);

    i(ReflectiveTypeAdapterFactory paramReflectiveTypeAdapterFactory, String paramString, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, Field paramField, TypeToken paramTypeToken, boolean paramBoolean3) {
        super(paramString, paramBoolean1, paramBoolean2);
    }

    void a(JsonReader paramJsonReader, Object paramObject) {
        paramJsonReader = this.a.read(paramJsonReader);
        if ((paramJsonReader != null) || (!this.e)) {
            this.c.set(paramObject, paramJsonReader);
        }
    }

    void a(JsonWriter paramJsonWriter, Object paramObject) {
        paramObject = this.c.get(paramObject);
        new m(this.b, this.a, this.d.getType()).write(paramJsonWriter, paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */