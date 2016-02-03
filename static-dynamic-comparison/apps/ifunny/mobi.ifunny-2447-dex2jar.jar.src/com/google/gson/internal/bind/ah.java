package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class ah
        implements TypeAdapterFactory {
    ah(TypeToken paramTypeToken, TypeAdapter paramTypeAdapter) {
    }

    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        if (paramTypeToken.equals(this.a)) {
            return this.b;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */