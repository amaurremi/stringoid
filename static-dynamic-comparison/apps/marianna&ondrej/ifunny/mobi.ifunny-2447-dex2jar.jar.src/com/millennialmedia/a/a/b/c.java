package com.millennialmedia.a.a.b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class c
        implements Serializable, GenericArrayType {
    private static final long serialVersionUID = 0L;
    private final Type a;

    public c(Type paramType) {
        this.a = b.d(paramType);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof GenericArrayType)) && (b.a(this, (GenericArrayType) paramObject));
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return b.f(this.a) + "[]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */