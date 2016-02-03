package com.google.gson.internal;

import java.lang.reflect.Method;

final class aj
        extends UnsafeAllocator {
    aj(Method paramMethod, Object paramObject) {
    }

    public <T> T newInstance(Class<T> paramClass) {
        return (T) this.a.invoke(this.b, new Object[]{paramClass});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */