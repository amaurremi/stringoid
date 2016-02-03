package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.Date;

final class ab
        implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        if (paramTypeToken.getRawType() != Timestamp.class) {
            return null;
        }
        return new ac(this, paramGson.getAdapter(Date.class));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */