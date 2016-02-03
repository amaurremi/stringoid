package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class f<K, V>
        extends TypeAdapter<Map<K, V>> {
    private final TypeAdapter<K> b;
    private final TypeAdapter<V> c;
    private final ObjectConstructor<? extends Map<K, V>> d;

    public f(Gson paramGson, Type paramType1, TypeAdapter<K> paramTypeAdapter, Type paramType2, TypeAdapter<V> paramTypeAdapter1, ObjectConstructor<? extends Map<K, V>> paramObjectConstructor) {
        this.b = new m(paramType1, paramType2, paramTypeAdapter);
        this.c = new m(paramType1, paramObjectConstructor, paramTypeAdapter1);
        ObjectConstructor localObjectConstructor;
        this.d = localObjectConstructor;
    }

    private String a(JsonElement paramJsonElement) {
        if (paramJsonElement.isJsonPrimitive()) {
            paramJsonElement = paramJsonElement.getAsJsonPrimitive();
            if (paramJsonElement.isNumber()) {
                return String.valueOf(paramJsonElement.getAsNumber());
            }
            if (paramJsonElement.isBoolean()) {
                return Boolean.toString(paramJsonElement.getAsBoolean());
            }
            if (paramJsonElement.isString()) {
                return paramJsonElement.getAsString();
            }
            throw new AssertionError();
        }
        if (paramJsonElement.isJsonNull()) {
            return "null";
        }
        throw new AssertionError();
    }

    public Map<K, V> a(JsonReader paramJsonReader) {
        Object localObject = paramJsonReader.peek();
        if (localObject == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        Map localMap = (Map) this.d.construct();
        if (localObject == JsonToken.BEGIN_ARRAY) {
            paramJsonReader.beginArray();
            while (paramJsonReader.hasNext()) {
                paramJsonReader.beginArray();
                localObject = this.b.read(paramJsonReader);
                if (localMap.put(localObject, this.c.read(paramJsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + localObject);
                }
                paramJsonReader.endArray();
            }
            paramJsonReader.endArray();
            return localMap;
        }
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext()) {
            JsonReaderInternalAccess.INSTANCE.promoteNameToValue(paramJsonReader);
            localObject = this.b.read(paramJsonReader);
            if (localMap.put(localObject, this.c.read(paramJsonReader)) != null) {
                throw new JsonSyntaxException("duplicate key: " + localObject);
            }
        }
        paramJsonReader.endObject();
        return localMap;
    }

    public void a(JsonWriter paramJsonWriter, Map<K, V> paramMap) {
        int m = 0;
        int k = 0;
        if (paramMap == null) {
            paramJsonWriter.nullValue();
            return;
        }
        if (!MapTypeAdapterFactory.access$000(this.a)) {
            paramJsonWriter.beginObject();
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                localObject = (Map.Entry) paramMap.next();
                paramJsonWriter.name(String.valueOf(((Map.Entry) localObject).getKey()));
                this.c.write(paramJsonWriter, ((Map.Entry) localObject).getValue());
            }
            paramJsonWriter.endObject();
            return;
        }
        Object localObject = new ArrayList(paramMap.size());
        ArrayList localArrayList = new ArrayList(paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        int i = 0;
        if (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            JsonElement localJsonElement = this.b.toJsonTree(localEntry.getKey());
            ((List) localObject).add(localJsonElement);
            localArrayList.add(localEntry.getValue());
            if ((localJsonElement.isJsonArray()) || (localJsonElement.isJsonObject())) {
            }
            for (int j = 1; ; j = 0) {
                i = j | i;
                break;
            }
        }
        if (i != 0) {
            paramJsonWriter.beginArray();
            i = k;
            while (i < ((List) localObject).size()) {
                paramJsonWriter.beginArray();
                Streams.write((JsonElement) ((List) localObject).get(i), paramJsonWriter);
                this.c.write(paramJsonWriter, localArrayList.get(i));
                paramJsonWriter.endArray();
                i += 1;
            }
            paramJsonWriter.endArray();
            return;
        }
        paramJsonWriter.beginObject();
        i = m;
        while (i < ((List) localObject).size()) {
            paramJsonWriter.name(a((JsonElement) ((List) localObject).get(i)));
            this.c.write(paramJsonWriter, localArrayList.get(i));
            i += 1;
        }
        paramJsonWriter.endObject();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */