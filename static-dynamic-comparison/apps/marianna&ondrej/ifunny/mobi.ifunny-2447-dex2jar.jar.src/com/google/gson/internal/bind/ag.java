package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class ag
        implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        paramTypeToken = paramTypeToken.getRawType();
        if ((!Enum.class.isAssignableFrom(paramTypeToken)) || (paramTypeToken == Enum.class)) {
            return null;
        }
        paramGson = paramTypeToken;
        if (!paramTypeToken.isEnum()) {
            paramGson = paramTypeToken.getSuperclass();
        }
        return new au(paramGson);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */