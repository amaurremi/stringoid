package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
        extends TypeAdapter<T> {
    private final Gson a;
    private final TypeAdapter<T> b;
    private final Type c;

    m(Gson paramGson, TypeAdapter<T> paramTypeAdapter, Type paramType) {
        this.a = paramGson;
        this.b = paramTypeAdapter;
        this.c = paramType;
    }

    private Type a(Type paramType, Object paramObject) {
        Object localObject = paramType;
        if (paramObject != null) {
            if ((paramType != Object.class) && (!(paramType instanceof TypeVariable))) {
                localObject = paramType;
                if (!(paramType instanceof Class)) {
                }
            } else {
                localObject = paramObject.getClass();
            }
        }
        return (Type) localObject;
    }

    public T read(JsonReader paramJsonReader) {
        return (T) this.b.read(paramJsonReader);
    }

    public void write(JsonWriter paramJsonWriter, T paramT) {
        TypeAdapter localTypeAdapter = this.b;
        Type localType = a(this.c, paramT);
        if (localType != this.c) {
            localTypeAdapter = this.a.getAdapter(TypeToken.get(localType));
            if ((localTypeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                break label52;
            }
        }
        for (; ; ) {
            localTypeAdapter.write(paramJsonWriter, paramT);
            return;
            label52:
            if (!(this.b instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                localTypeAdapter = this.b;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */