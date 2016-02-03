package com.google.gson.internal;

import com.google.gson.JsonIOException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class k
        implements ObjectConstructor<T> {
    k(ConstructorConstructor paramConstructorConstructor, Type paramType) {
    }

    public T construct() {
        if ((this.a instanceof ParameterizedType)) {
            Type localType = ((ParameterizedType) this.a).getActualTypeArguments()[0];
            if ((localType instanceof Class)) {
                return EnumSet.noneOf((Class) localType);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
        throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */