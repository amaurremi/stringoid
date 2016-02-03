package com.google.gson.internal;

import java.lang.reflect.Type;

class g
        implements ObjectConstructor<T> {
    private final UnsafeAllocator d = UnsafeAllocator.create();

    g(ConstructorConstructor paramConstructorConstructor, Class paramClass, Type paramType) {
    }

    public T construct() {
        try {
            Object localObject = this.d.newInstance(this.a);
            return (T) localObject;
        } catch (Exception localException) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */