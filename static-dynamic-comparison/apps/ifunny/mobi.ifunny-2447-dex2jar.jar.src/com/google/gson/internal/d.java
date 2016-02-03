package com.google.gson.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

class d
        implements ObjectConstructor<T> {
    d(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {
    }

    public T construct() {
        return (T) this.a.createInstance(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */