package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class o<T>
        extends TypeAdapter<T> {
    private final JsonSerializer<T> a;
    private final JsonDeserializer<T> b;
    private final Gson c;
    private final TypeToken<T> d;
    private final TypeAdapterFactory e;
    private TypeAdapter<T> f;

    private o(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory) {
        this.a = paramJsonSerializer;
        this.b = paramJsonDeserializer;
        this.c = paramGson;
        this.d = paramTypeToken;
        this.e = paramTypeAdapterFactory;
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

    public static TypeAdapterFactory a(TypeToken<?> paramTypeToken, Object paramObject) {
        return new q(paramObject, paramTypeToken, false, null, null);
    }

    public static TypeAdapterFactory a(Class<?> paramClass, Object paramObject) {
        return new q(paramObject, null, false, paramClass, null);
    }

    public static TypeAdapterFactory b(TypeToken<?> paramTypeToken, Object paramObject) {
        if (paramTypeToken.getType() == paramTypeToken.getRawType()) {
        }
        for (boolean bool = true; ; bool = false) {
            return new q(paramObject, paramTypeToken, bool, null, null);
        }
    }

    public T read(JsonReader paramJsonReader) {
        if (this.b == null) {
            return (T) a().read(paramJsonReader);
        }
        paramJsonReader = Streams.parse(paramJsonReader);
        if (paramJsonReader.isJsonNull()) {
            return null;
        }
        return (T) this.b.deserialize(paramJsonReader, this.d.getType(), this.c.deserializationContext);
    }

    public void write(JsonWriter paramJsonWriter, T paramT) {
        if (this.a == null) {
            a().write(paramJsonWriter, paramT);
            return;
        }
        if (paramT == null) {
            paramJsonWriter.nullValue();
            return;
        }
        Streams.write(this.a.serialize(paramT, this.d.getType(), this.c.serializationContext), paramJsonWriter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */