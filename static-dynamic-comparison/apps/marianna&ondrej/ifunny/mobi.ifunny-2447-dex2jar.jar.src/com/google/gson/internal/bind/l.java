package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.sql.Time;

final class l
        implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        if (paramTypeToken.getRawType() == Time.class) {
            return new TimeTypeAdapter();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */