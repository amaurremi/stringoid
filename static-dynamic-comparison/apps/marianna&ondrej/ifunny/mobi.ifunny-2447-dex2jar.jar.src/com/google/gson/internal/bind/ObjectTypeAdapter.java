package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter
        extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new g();
    private final Gson gson;

    private ObjectTypeAdapter(Gson paramGson) {
        this.gson = paramGson;
    }

    public Object read(JsonReader paramJsonReader) {
        Object localObject = paramJsonReader.peek();
        switch (h.a[localObject.ordinal()]) {
            default:
                throw new IllegalStateException();
            case 1:
                localObject = new ArrayList();
                paramJsonReader.beginArray();
                while (paramJsonReader.hasNext()) {
                    ((List) localObject).add(read(paramJsonReader));
                }
                paramJsonReader.endArray();
                return localObject;
            case 2:
                localObject = new LinkedTreeMap();
                paramJsonReader.beginObject();
                while (paramJsonReader.hasNext()) {
                    ((Map) localObject).put(paramJsonReader.nextName(), read(paramJsonReader));
                }
                paramJsonReader.endObject();
                return localObject;
            case 3:
                return paramJsonReader.nextString();
            case 4:
                return Double.valueOf(paramJsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(paramJsonReader.nextBoolean());
        }
        paramJsonReader.nextNull();
        return null;
    }

    public void write(JsonWriter paramJsonWriter, Object paramObject) {
        if (paramObject == null) {
            paramJsonWriter.nullValue();
            return;
        }
        TypeAdapter localTypeAdapter = this.gson.getAdapter(paramObject.getClass());
        if ((localTypeAdapter instanceof ObjectTypeAdapter)) {
            paramJsonWriter.beginObject();
            paramJsonWriter.endObject();
            return;
        }
        localTypeAdapter.write(paramJsonWriter, paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ObjectTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */