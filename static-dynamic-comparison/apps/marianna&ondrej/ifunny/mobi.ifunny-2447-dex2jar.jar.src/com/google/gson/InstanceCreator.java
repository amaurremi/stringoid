package com.google.gson;

import java.lang.reflect.Type;

public abstract interface InstanceCreator<T> {
    public abstract T createInstance(Type paramType);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/InstanceCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */