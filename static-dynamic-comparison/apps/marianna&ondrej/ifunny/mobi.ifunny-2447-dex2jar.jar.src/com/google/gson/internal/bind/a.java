package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.GenericArrayType;

final class a
        implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        paramTypeToken = paramTypeToken.getType();
        if ((!(paramTypeToken instanceof GenericArrayType)) && ((!(paramTypeToken instanceof Class)) || (!((Class) paramTypeToken).isArray()))) {
            return null;
        }
        paramTypeToken =.Gson.Types.getArrayComponentType(paramTypeToken);
        return new ArrayTypeAdapter(paramGson, paramGson.getAdapter(TypeToken.get(paramTypeToken)),.Gson.Types.getRawType(paramTypeToken))
        ;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */