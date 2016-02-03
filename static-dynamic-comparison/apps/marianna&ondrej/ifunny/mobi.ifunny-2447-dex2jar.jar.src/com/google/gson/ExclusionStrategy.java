package com.google.gson;

public abstract interface ExclusionStrategy {
    public abstract boolean shouldSkipClass(Class<?> paramClass);

    public abstract boolean shouldSkipField(FieldAttributes paramFieldAttributes);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/ExclusionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */