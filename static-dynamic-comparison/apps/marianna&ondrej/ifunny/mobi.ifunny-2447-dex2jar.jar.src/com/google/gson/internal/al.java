package com.google.gson.internal;

import java.lang.reflect.Method;

final class al
        extends UnsafeAllocator {
    al(Method paramMethod) {
    }

    public <T> T newInstance(Class<T> paramClass) {
        return (T) this.a.invoke(null, new Object[]{paramClass, Object.class});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */