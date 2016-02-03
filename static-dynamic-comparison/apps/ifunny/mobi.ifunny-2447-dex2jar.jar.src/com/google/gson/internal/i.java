package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class i
        implements ObjectConstructor<T> {
    i(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor) {
    }

    public T construct() {
        try {
            Object localObject = this.a.newInstance(null);
            return (T) localObject;
        } catch (InstantiationException localInstantiationException) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
        } catch (InvocationTargetException localInvocationTargetException) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new AssertionError(localIllegalAccessException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */