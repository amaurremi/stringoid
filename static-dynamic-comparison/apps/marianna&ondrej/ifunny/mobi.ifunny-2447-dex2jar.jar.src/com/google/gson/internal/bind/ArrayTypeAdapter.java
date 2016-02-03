package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E>
        extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new a();
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass) {
        this.componentTypeAdapter = new m(paramGson, paramTypeAdapter, paramClass);
        this.componentType = paramClass;
    }

    public Object read(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext()) {
            localArrayList.add(this.componentTypeAdapter.read(paramJsonReader));
        }
        paramJsonReader.endArray();
        paramJsonReader = Array.newInstance(this.componentType, localArrayList.size());
        int i = 0;
        while (i < localArrayList.size()) {
            Array.set(paramJsonReader, i, localArrayList.get(i));
            i += 1;
        }
        return paramJsonReader;
    }

    public void write(JsonWriter paramJsonWriter, Object paramObject) {
        if (paramObject == null) {
            paramJsonWriter.nullValue();
            return;
        }
        paramJsonWriter.beginArray();
        int i = 0;
        int j = Array.getLength(paramObject);
        while (i < j) {
            Object localObject = Array.get(paramObject, i);
            this.componentTypeAdapter.write(paramJsonWriter, localObject);
            i += 1;
        }
        paramJsonWriter.endArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ArrayTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */