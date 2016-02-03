package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class l<T>
        extends TypeAdapter<T> {
    private TypeAdapter<T> a;

    public void a(TypeAdapter<T> paramTypeAdapter) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = paramTypeAdapter;
    }

    public T read(JsonReader paramJsonReader) {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        return (T) this.a.read(paramJsonReader);
    }

    public void write(JsonWriter paramJsonWriter, T paramT) {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        this.a.write(paramJsonWriter, paramT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */