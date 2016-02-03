package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class a
        implements Serializable, GenericArrayType {
    private static final long serialVersionUID = 0L;
    private final Type a;

    public a(Type paramType) {
        this.a =.Gson.Types.canonicalize(paramType);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof GenericArrayType)) && (.Gson.Types.equals(this, (GenericArrayType) paramObject))
        ;
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return.Gson.Types.typeToString(this.a) + "[]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */