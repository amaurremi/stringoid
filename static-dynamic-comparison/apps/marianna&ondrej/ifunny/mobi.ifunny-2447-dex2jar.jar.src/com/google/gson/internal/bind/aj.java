package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class aj
        implements TypeAdapterFactory {
    aj(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {
    }

    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        paramGson = paramTypeToken.getRawType();
        if ((paramGson == this.a) || (paramGson == this.b)) {
            return this.c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */