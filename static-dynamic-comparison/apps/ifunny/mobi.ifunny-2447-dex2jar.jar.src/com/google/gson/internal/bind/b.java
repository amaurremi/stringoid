package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class b<E>
        extends TypeAdapter<Collection<E>> {
    private final TypeAdapter<E> a;
    private final ObjectConstructor<? extends Collection<E>> b;

    public b(Gson paramGson, Type paramType, TypeAdapter<E> paramTypeAdapter, ObjectConstructor<? extends Collection<E>> paramObjectConstructor) {
        this.a = new m(paramGson, paramTypeAdapter, paramType);
        this.b = paramObjectConstructor;
    }

    public Collection<E> a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        Collection localCollection = (Collection) this.b.construct();
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext()) {
            localCollection.add(this.a.read(paramJsonReader));
        }
        paramJsonReader.endArray();
        return localCollection;
    }

    public void a(JsonWriter paramJsonWriter, Collection<E> paramCollection) {
        if (paramCollection == null) {
            paramJsonWriter.nullValue();
            return;
        }
        paramJsonWriter.beginArray();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            Object localObject = paramCollection.next();
            this.a.write(paramJsonWriter, localObject);
        }
        paramJsonWriter.endArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */