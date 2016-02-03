package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class au<T extends Enum<T>>
        extends TypeAdapter<T> {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public au(Class<T> paramClass) {
        for (; ; ) {
            try {
                Enum[] arrayOfEnum = (Enum[]) paramClass.getEnumConstants();
                int j = arrayOfEnum.length;
                int i = 0;
                if (i < j) {
                    Enum localEnum = arrayOfEnum[i];
                    String str = localEnum.name();
                    SerializedName localSerializedName = (SerializedName) paramClass.getField(str).getAnnotation(SerializedName.class);
                    if (localSerializedName != null) {
                        str = localSerializedName.value();
                        this.a.put(str, localEnum);
                        this.b.put(localEnum, str);
                        i += 1;
                    }
                } else {
                    return;
                }
            } catch (NoSuchFieldException paramClass) {
                throw new AssertionError();
            }
        }
    }

    public T a(JsonReader paramJsonReader) {
        if (paramJsonReader.peek() == JsonToken.NULL) {
            paramJsonReader.nextNull();
            return null;
        }
        return (Enum) this.a.get(paramJsonReader.nextString());
    }

    public void a(JsonWriter paramJsonWriter, T paramT) {
        if (paramT == null) {
        }
        for (paramT = null; ; paramT = (String) this.b.get(paramT)) {
            paramJsonWriter.value(paramT);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */