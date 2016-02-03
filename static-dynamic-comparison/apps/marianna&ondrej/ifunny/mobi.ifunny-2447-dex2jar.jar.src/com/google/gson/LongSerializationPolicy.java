package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT, STRING;

    private LongSerializationPolicy() {
    }

    public abstract JsonElement serialize(Long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/LongSerializationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */