package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public final T fromJson(Reader paramReader) {
        return (T) read(new JsonReader(paramReader));
    }

    public final T fromJson(String paramString) {
        return (T) fromJson(new StringReader(paramString));
    }

    public final T fromJsonTree(JsonElement paramJsonElement) {
        try {
            paramJsonElement = read(new JsonTreeReader(paramJsonElement));
            return paramJsonElement;
        } catch (IOException paramJsonElement) {
            throw new JsonIOException(paramJsonElement);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new r(this);
    }

    public abstract T read(JsonReader paramJsonReader);

    public final String toJson(T paramT) {
        StringWriter localStringWriter = new StringWriter();
        toJson(localStringWriter, paramT);
        return localStringWriter.toString();
    }

    public final void toJson(Writer paramWriter, T paramT) {
        write(new JsonWriter(paramWriter), paramT);
    }

    public final JsonElement toJsonTree(T paramT) {
        try {
            JsonTreeWriter localJsonTreeWriter = new JsonTreeWriter();
            write(localJsonTreeWriter, paramT);
            paramT = localJsonTreeWriter.get();
            return paramT;
        } catch (IOException paramT) {
            throw new JsonIOException(paramT);
        }
    }

    public abstract void write(JsonWriter paramJsonWriter, T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */