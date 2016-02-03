package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class p
        extends TypeAdapter<T> {
    private TypeAdapter<T> f;

    p(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, TypeToken paramTypeToken) {
    }

    private TypeAdapter<T> a() {
        TypeAdapter localTypeAdapter = this.f;
        if (localTypeAdapter != null) {
            return localTypeAdapter;
        }
        localTypeAdapter = this.c.getDelegateAdapter(this.e, this.d);
        this.f = localTypeAdapter;
        return localTypeAdapter;
    }

    public T read(JsonReader paramJsonReader) {
        if (this.a) {
            paramJsonReader.skipValue();
            return null;
        }
        return (T) a().read(paramJsonReader);
    }

    public void write(JsonWriter paramJsonWriter, T paramT) {
        if (this.b) {
            paramJsonWriter.nullValue();
            return;
        }
        a().write(paramJsonWriter, paramT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */