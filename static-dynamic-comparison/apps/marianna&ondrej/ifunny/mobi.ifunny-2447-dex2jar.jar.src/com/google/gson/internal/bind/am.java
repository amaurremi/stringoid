package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class am
        implements TypeAdapterFactory {
    am(Class paramClass, TypeAdapter paramTypeAdapter) {
    }

    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        if (this.a.isAssignableFrom(paramTypeToken.getRawType())) {
            return this.b;
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */